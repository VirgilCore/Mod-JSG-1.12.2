package tauri.dev.jsg.block.machine;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tauri.dev.jsg.JSG;
import tauri.dev.jsg.gui.GuiIdEnum;
import tauri.dev.jsg.item.machine.MachineItemBlock;
import tauri.dev.jsg.renderer.machine.CircuitFabricatorRenderer;
import tauri.dev.jsg.tileentity.machine.CircuitFabricatorTile;

import javax.annotation.Nonnull;

public class CircuitFabricatorBlock extends AbstractMachineBlock {
    public static final String BLOCK_NAME = "circuit_fabricator_block";
    public static final int MAX_ENERGY = 9_000_000;
    public static final int MAX_ENERGY_TRANSFER = 20_000;
    public static final int FLUID_CAPACITY = 5000;

    public CircuitFabricatorBlock() {
        super(BLOCK_NAME);
    }

    @Override
    public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState state) {
        return new CircuitFabricatorTile();
    }

    @Override
    public Class<? extends TileEntity> getTileEntityClass() {
        return CircuitFabricatorTile.class;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TileEntitySpecialRenderer<? extends TileEntity> getTESR() {
        return new CircuitFabricatorRenderer();
    }

    @Override
    protected void showGui(EntityPlayer player, EnumHand hand, World world, BlockPos pos) {
        if (FluidUtil.interactWithFluidHandler(player, hand, world, pos, null)) return;
        player.openGui(JSG.instance, GuiIdEnum.GUI_circuit_fabricator.id, world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void breakBlock(World world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        if (!world.isRemote) {
            CircuitFabricatorTile tile = (CircuitFabricatorTile) world.getTileEntity(pos);
            if (tile != null) {
                tile.onBreak();
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public ItemBlock getItemBlock() {
        return new MachineItemBlock(this, BLOCK_NAME, MAX_ENERGY);
    }

    @Nonnull
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean renderHighlight(IBlockState state) {
        return false;
    }
}
