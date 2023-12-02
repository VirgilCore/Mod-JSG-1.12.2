package tauri.dev.jsg.gui.container.machine.mcd;

import tauri.dev.jsg.gui.container.machine.AbstractMachineContainerGuiUpdate;

public class MCDContainerGuiUpdate extends AbstractMachineContainerGuiUpdate {
    public MCDContainerGuiUpdate() {
        super();
    }

    public MCDContainerGuiUpdate(int energyStored, int energyTransferedLastTick, long machineStart, long machineEnd) {
        super(energyStored, energyTransferedLastTick, machineStart, machineEnd);
    }
}
