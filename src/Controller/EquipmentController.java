package Controller;

import mainPart.Database;

public class EquipmentController {
	public EquipmentController() {
		
	}
	
	//View ask for the equipment capacity to show
	public float getCapacity() {
		return Database.dbGetEquipmentCapacity();
	}
}
