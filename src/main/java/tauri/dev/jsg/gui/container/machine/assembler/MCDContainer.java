package tauri.dev.jsg.gui.container.machine.assembler;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import tauri.dev.jsg.block.JSGBlocks;
import tauri.dev.jsg.gui.container.JSGContainer;
import tauri.dev.jsg.gui.util.ContainerHelper;
import tauri.dev.jsg.item.JSGItems;
import tauri.dev.jsg.packet.JSGPacketHandler;
import tauri.dev.jsg.packet.StateUpdatePacketToClient;
import tauri.dev.jsg.power.general.SmallEnergyStorage;
import tauri.dev.jsg.state.StateTypeEnum;
import tauri.dev.jsg.tileentity.machine.MCDTile;

import javax.annotation.Nonnull;
import java.util.ArrayList;

import static tauri.dev.jsg.tileentity.machine.MCDTile.CONTAINER_SIZE;
import static tauri.dev.jsg.tileentity.machine.MCDTile.getAllowedSchematics;

public class MCDContainer extends JSGContainer {

    public MCDTile tile;
    public ArrayList<Slot> slots = new ArrayList<>();
    private final BlockPos pos;
    private int lastEnergyStored;
    private int energyTransferedLastTick;

    private long machineStart = 0;
    private long machineEnd = 0;

    private final World world;

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public BlockPos getPos() {
        return pos;
    }

    @Override
    public Block[] getAllowedBlocks() {
        return new Block[]{JSGBlocks.MACHINE_ASSEMBLER};
    }

    public MCDContainer(IInventory playerInventory, World world, int x, int y, int z) {
        pos = new BlockPos(x, y, z);
        this.world = world;
        tile = (MCDTile) world.getTileEntity(pos);
        if (tile != null) {
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

            slots.add(new SlotItemHandler(itemHandler, 0, 10, 65));
            int i = 0;
            for (int y1 = 0; y1 < 3; y1++) {
                for (int x1 = 0; x1 < 3; x1++) {
                    slots.add(new SlotItemHandler(itemHandler, 1 + i, 34 + (18 * x1), 47 + (18 * y1)));
                    i++;
                }
            }
            slots.add(new SlotItemHandler(itemHandler, ++i, 102, 65));
            slots.add(new SlotItemHandler(itemHandler, ++i, 146, 65));
            for (Slot slot : slots)
                addSlotToContainer(slot);

            for (Slot slot : ContainerHelper.generatePlayerSlots(playerInventory, 149))
                addSlotToContainer(slot);
        }
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(@Nonnull EntityPlayer playerIn, int slotId) {
        ItemStack returnStack = ItemStack.EMPTY;
        Slot slot = getSlot(slotId);
        if (slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            returnStack = stack.copy();

            if (slotId == 0) {
                if (!(JSGItems.isInItemsArray(stack.getItem(), getAllowedSchematics()))) return ItemStack.EMPTY;
            }

            if (slotId < CONTAINER_SIZE) {
                // to player
                if (!this.mergeItemStack(stack, CONTAINER_SIZE, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            // from player
            else if (!this.mergeItemStack(stack, 0, CONTAINER_SIZE, true)) {
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return returnStack;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        SmallEnergyStorage energyStorage = (SmallEnergyStorage) tile.getCapability(CapabilityEnergy.ENERGY, null);

        if (machineStart != tile.getMachineStart() || machineEnd != tile.getMachineEnd() || (energyStorage != null && (lastEnergyStored != energyStorage.getEnergyStored() || energyTransferedLastTick != tile.getEnergyTransferedLastTick()))) {
            for (IContainerListener listener : listeners) {
                if (listener instanceof EntityPlayerMP) {
                    JSGPacketHandler.INSTANCE.sendTo(new StateUpdatePacketToClient(pos, StateTypeEnum.GUI_UPDATE, tile.getState(StateTypeEnum.GUI_UPDATE)), (EntityPlayerMP) listener);
                }
            }

            if(energyStorage == null) return;
            lastEnergyStored = energyStorage.getEnergyStored();
            energyTransferedLastTick = tile.getEnergyTransferedLastTick();
            machineStart = tile.getMachineStart();
            machineEnd = tile.getMachineEnd();
        }
    }
}
