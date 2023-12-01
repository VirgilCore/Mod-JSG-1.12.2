package tauri.dev.jsg.renderer.machine;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CircuitFabricatorRendererState extends AbstractMachineRendererState {

    public List<Float> colors = new ArrayList<>();
    public CircuitFabricatorRendererState() {
    }

    public CircuitFabricatorRendererState(long workStateChanged, int machineProgress, boolean isWorking, ItemStack workingOnItemStack, float[] colors) {
        super(workStateChanged, machineProgress, isWorking, workingOnItemStack);
        this.colors = new ArrayList<Float>() {{
            for (float color : colors) add(color);
        }};
    }

    @Override
    public void toBytes(ByteBuf buf) {
        super.toBytes(buf);
        buf.writeInt(colors.size());
        for (float color : colors)
            buf.writeFloat(color);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        super.fromBytes(buf);
        int s = buf.readInt();
        colors.clear();
        for (int i = 0; i < s; i++)
            colors.add(buf.readFloat());
    }
}
