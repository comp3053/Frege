package Controller;

import mainPart.Equipment;

public class EquipmentUpdateController {
	public EquipmentUpdateController() {
		
	}
	
	public boolean updateEquipment(float capacity) {
		return Equipment.updateCapacity(capacity);
	}
}
