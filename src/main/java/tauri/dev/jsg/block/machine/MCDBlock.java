package tauri.dev.jsg.block.machine;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tauri.dev.jsg.JSG;
import tauri.dev.jsg.gui.GuiIdEnum;
import tauri.dev.jsg.item.machine.MachineItemBlock;
import tauri.dev.jsg.renderer.machine.MCDRenderer;
import tauri.dev.jsg.tileentity.machine.MCDTile;
import tauri.dev.jsg.util.JSGAxisAlignedBB;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AssemblerBlock extends AbstractMachineBlock {
    public static final String BLOCK_NAME = "molecular_constructor_block";
    public static final int MAX_ENERGY = 9_000_000;
    public static final int MAX_ENERGY_TRANSFER = 20_000;

    public AssemblerBlock() {
        super(BLOCK_NAME);
    }

    @Override
    public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState state) {
        return new MCDTile();
    }

    @Override
    public Class<? extends TileEntity> getTileEntityClass() {
        return MCDTile.class;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TileEntitySpecialRenderer<? extends TileEntity> getTESR() {
        return new MCDRenderer();
    }

    @Override
    protected void showGui(EntityPlayer player, EnumHand hand, World world, BlockPos pos) {
        player.openGui(JSG.instance, GuiIdEnum.GUI_ASSEMBLER.id, world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void breakBlock(World world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        if (!world.isRemote) {
            MCDTile tile = (MCDTile) world.getTileEntity(pos);
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

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
        return new JSGAxisAlignedBB(0, 0, 0, 1, 0.8, 1);
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
        return new JSGAxisAlignedBB(0, 0, 0, 1, 0.8, 1);
    }

    @Nonnull
    @Override
    public EnumBlockRenderType getRenderType(@Nonnull IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public boolean renderHighlight(IBlockState state) {
        return false;
    }
}
