package Controller;

import mainPart.Database;

public class EquipmentController {
	public EquipmentController() {
		
	}
	
	public float getCapacity() {
		return Database.dbGetEquipmentCapacity();
	}
}
