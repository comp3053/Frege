package Controller;

import mainPart.Equipment;

public class EquipmentUpdateController {
	public EquipmentUpdateController() {
		
	}
	
	//View ask to modify the equipment capacity
	public boolean updateEquipment(float capacity) {
		return Equipment.updateCapacity(capacity);
	}
}
