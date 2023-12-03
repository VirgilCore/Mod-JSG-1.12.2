package tauri.dev.jsg.renderer.machine;

import net.minecraft.item.ItemStack;

public class MCDRendererState extends AbstractMachineRendererState {
    public MCDRendererState() {
        super();
    }

    public MCDRendererState(long workStateChanged, int machineProgress, boolean isWorking, ItemStack workingOnItemStack) {
        super(workStateChanged, machineProgress, isWorking, workingOnItemStack);
    }
}
