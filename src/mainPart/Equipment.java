package mainPart;

public class Equipment {
	private String name;
	public float capacity;
	
	// constructor
	public Equipment(String name, float capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCapacity() {
		return capacity;
	}
	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	
	// methods
	public static boolean updateCapacity(float capacity) {
		// call this function to update the capacity of equipment in the database
		if (capacity >= 0) 
		{
			// update the capacity in the database
	        return Database.dbUpdateCapacity(capacity);
		} else {
			// the capacity can only larger than zero
			System.out.println("Capacity should be non-negative!");
		}
		return false;
	}
	
	public static float getEquipmentCapacity() {
		// call this function to get the capacity of equipment in the database
		return Database.dbGetCapacity();
	}
}
