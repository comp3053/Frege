package Controller;

import mainPart.Equipment;

public class EquipmentUpdateController {
	public EquipmentUpdateController() {
		
	}
	
	public boolean updateEquipment(float capacity) {
		Equipment equipment = new Equipment("Frege", capacity);
		return equipment.updateCapacity(capacity);
	}
}
