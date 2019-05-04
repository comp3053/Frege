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
	
	public void updateCapacity(float capacity) {
		if (capacity >= 0)
		{
			Scanner inputCapacity = new Scanner(System.in);
	        float newCapacity = inputCapacity.nextFloat();
	        this.capacity = newCapacity;
		}
		else 
		{
			System.out.println("Capacity should be non-negative!");
		}
	}
	
}
