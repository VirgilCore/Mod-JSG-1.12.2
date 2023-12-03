package tauri.dev.jsg.tileentity.machine;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import tauri.dev.jsg.block.machine.CircuitFabricatorBlock;
import tauri.dev.jsg.gui.container.machine.pcbfabricator.CircuitFabricatorContainerGuiUpdate;
import tauri.dev.jsg.machine.AbstractMachineRecipe;
import tauri.dev.jsg.machine.pcbfabricator.CircuitFabricatorRecipe;
import tauri.dev.jsg.machine.pcbfabricator.CircuitFabricatorRecipes;
import tauri.dev.jsg.power.general.SmallEnergyStorage;
import tauri.dev.jsg.renderer.machine.AbstractMachineRendererState;
import tauri.dev.jsg.renderer.machine.CircuitFabricatorRendererState;
import tauri.dev.jsg.sound.JSGSoundHelper;
import tauri.dev.jsg.sound.SoundEventEnum;
import tauri.dev.jsg.sound.SoundPositionedEnum;
import tauri.dev.jsg.state.State;
import tauri.dev.jsg.state.StateTypeEnum;
import tauri.dev.jsg.util.JSGItemStackHandler;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class CircuitFabricatorTile extends AbstractMachineTile {

    public CircuitFabricatorRendererState rendererState = new CircuitFabricatorRendererState();
    public static final int CONTAINER_SIZE = 10;
    protected final JSGItemStackHandler itemStackHandler = new JSGItemStackHandler(CONTAINER_SIZE) {

        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return slot != 9; // output slot
        }

        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            markDirty();
            sendState(StateTypeEnum.RENDERER_UPDATE, getState(StateTypeEnum.RENDERER_UPDATE));
        }
    };
    protected final SmallEnergyStorage energyStorage = new SmallEnergyStorage(CircuitFabricatorBlock.MAX_ENERGY, CircuitFabricatorBlock.MAX_ENERGY_TRANSFER) {
        @Override
        protected void onEnergyChanged() {
            markDirty();
        }
    };
    protected final FluidTank fluidHandler = new FluidTank(CircuitFabricatorBlock.FLUID_CAPACITY) {
        @Override
        public boolean canFillFluidType(FluidStack fluid) {
            return fluid != null;
        }

        @Override
        protected void onContentsChanged() {
            markDirty();
            onItemHandlerChange();
            sendState(StateTypeEnum.RENDERER_UPDATE, getState(StateTypeEnum.RENDERER_UPDATE));
        }
    };

    @Override
    public JSGItemStackHandler getJSGItemHandler() {
        return itemStackHandler;
    }

    @Override
    protected void playLoopSound(boolean stop) {
        JSGSoundHelper.playPositionedSound(world, pos, SoundPositionedEnum.BEAMER_LOOP, !stop);
    }

    @Override
    protected void playSound(boolean start) {
        if (!start)
            JSGSoundHelper.playSoundEvent(world, pos, SoundEventEnum.BEAMER_STOP);
        else
            JSGSoundHelper.playSoundEvent(world, pos, SoundEventEnum.BEAMER_START);
    }

    @Override
    public AbstractMachineRecipe getRecipeIfPossible() {
        ArrayList<ItemStack> stacks = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            stacks.add(itemStackHandler.getStackInSlot(i));

        if(currentRecipe instanceof CircuitFabricatorRecipe){
            CircuitFabricatorRecipe recipe = (CircuitFabricatorRecipe) currentRecipe;
            if (!itemStackHandler.insertItem(9, recipe.getResult(), true).equals(ItemStack.EMPTY)) return null;
            if (fluidHandler.getFluid() == null) return null;
            if (recipe.isOk(energyStorage.getEnergyStored(), new FluidStack(fluidHandler.getFluid(), fluidHandler.getFluidAmount()), stacks))
                return recipe;
            return null;
        }

        for (CircuitFabricatorRecipe recipe : CircuitFabricatorRecipes.RECIPES) {
            if (!itemStackHandler.insertItem(9, recipe.getResult(), true).equals(ItemStack.EMPTY)) continue;
            if (fluidHandler.getFluid() == null) continue;
            if (recipe.isOk(energyStorage.getEnergyStored(), new FluidStack(fluidHandler.getFluid(), fluidHandler.getFluidAmount()), stacks))
                return recipe;
        }
        return null;
    }

    protected void workIsDone() {
        if (!isWorking || currentRecipe == null) return;
        CircuitFabricatorRecipe currentRecipe = (CircuitFabricatorRecipe) this.currentRecipe;
        itemStackHandler.insertItem(9, currentRecipe.getResult(), false);
        fluidHandler.drainInternal(currentRecipe.getSubFluidStack().amount, true);
        for (int i = 0; i < 9; i++) {
            int amount = 0;
            if (currentRecipe.getPattern().size() > i && currentRecipe.getPattern().get(i) != null)
                amount = currentRecipe.getPattern().get(i).getCount();
            itemStackHandler.extractItem(i, amount, false);
        }
        super.workIsDone();
    }

    @Override
    public SmallEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing) {
        return (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) || super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
            return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(fluidHandler);

        return super.getCapability(capability, facing);
    }

    @Override
    public State getState(StateTypeEnum stateType) {
        switch (stateType) {
            case GUI_UPDATE:
                return new CircuitFabricatorContainerGuiUpdate(energyStorage.getEnergyStored(), (fluidHandler.getFluid() != null ? new FluidStack(fluidHandler.getFluid(), fluidHandler.getFluidAmount()) : null), energyTransferedLastTick, machineStart, machineEnd);
            case RENDERER_UPDATE:
                ItemStack stack = currentRecipe != null ? ((CircuitFabricatorRecipe) currentRecipe).getResult() : itemStackHandler.getStackInSlot(9);
                float[] colors = currentRecipe != null ? ((CircuitFabricatorRecipe) currentRecipe).getBeamColors() : new float[]{1f, 1f, 1f};
                return new CircuitFabricatorRendererState(workStateChanged, machineProgress, isWorking, stack, colors);
        }
        return null;
    }

    @Override
    public State createState(StateTypeEnum stateType) {
        switch (stateType) {
            case GUI_UPDATE:
                return new CircuitFabricatorContainerGuiUpdate();
            case RENDERER_UPDATE:
                return new CircuitFabricatorRendererState();
        }
        return null;
    }

    @Override
    public void setState(StateTypeEnum stateType, State state) {
        switch (stateType) {
            case GUI_UPDATE:
                CircuitFabricatorContainerGuiUpdate guiUpdate = (CircuitFabricatorContainerGuiUpdate) state;
                energyStorage.setEnergyStored(guiUpdate.energyStored);
                energyTransferedLastTick = guiUpdate.energyTransferedLastTick;
                machineStart = guiUpdate.machineStart;
                machineEnd = guiUpdate.machineEnd;
                fluidHandler.setFluid(guiUpdate.fluidStack);
                markDirty();
                break;
            case RENDERER_UPDATE:
                rendererState = (CircuitFabricatorRendererState) state;
                this.machineProgress = rendererState.machineProgress;
                this.isWorking = rendererState.isWorking;
                markDirty();
                break;
        }
    }

    public AbstractMachineRendererState getRendererState() {
        return rendererState;
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound fluidHandlerCompound = new NBTTagCompound();
        fluidHandler.writeToNBT(fluidHandlerCompound);
        compound.setTag("fluidHandler", fluidHandlerCompound);

        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        fluidHandler.readFromNBT(compound.getCompoundTag("fluidHandler"));

        super.readFromNBT(compound);
    }
}
