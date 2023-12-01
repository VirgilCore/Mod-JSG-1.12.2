package tauri.dev.jsg.gui;

import java.util.HashMap;
import java.util.Map;

public enum GuiIdEnum {
	GUI_DHD(0),
	GUI_STARGATE(1),
	GUI_CAPACITOR(2),
	GUI_BEAMER(3),
	GUI_PEGASUS_DHD(4),
	GUI_RINGS(5),
	GUI_ASSEMBLER(6),
	GUI_CRYSTAL_CHAMBER(7),
	GUI_circuit_fabricator(8),
	GUI_ORE_WASHING(9),
	GUI_ZPM_HUB(10),
	GUI_ZPM_SLOT(11),
	GUI_COUNTDOWN(12),
	GUI_LAB(13),
	;
    public final int id;
	
	GuiIdEnum(int id) {
		this.id = id;
	}
	
	private static final Map<Integer, GuiIdEnum> idMap = new HashMap<>();
	static {
		for (GuiIdEnum guidEnum : values())
			idMap.put(guidEnum.id, guidEnum);
	}
	
	public static GuiIdEnum valueOf(int id) {
		return idMap.get(id);
	}
}
