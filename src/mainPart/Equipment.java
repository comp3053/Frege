package mainPart;
import java.util.Scanner;

public class Equipment {
	private String name;
	public float capacity;
	
	public Equipment(String name, float capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	
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
	
	public static boolean updateCapacity(float capacity) {
		if (capacity >= 0)
		{
	        return Database.dbUpdateCapacity(capacity);
		}
		else 
		{
			System.out.println("Capacity should be non-negative!");
		}
		return false;
	}
	
	public static float getEquipmentCapacity() {
		return Database.dbGetCapacity();
	}
}
