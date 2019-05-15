package mainPart;

public class Ingredient {
	private String ingredientName;
	private float quantity;
	private String unit;
	
	// constructor
	public Ingredient(String name, float quantity, String unit) {
		this.ingredientName = name;
		this.quantity = quantity;
		this.unit = unit;
	}
	
	// get and set functions
	public String getIngredientName() {
		return this.ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public float getQuantity() {
		return this.quantity;
	}
	public void setQuantity(float amount) {
		this.quantity = amount;
	}
	public String getUnit() {
		return this.unit;
	}
	public boolean setUnit(String unit) {
		// user must input a valid unit
		if (unit.equals("kg") || unit.equals("g") || unit.equals("ml") || unit.equals("l")) {
			this.unit = unit;
			return true;
		} else {
			// if they give a wrong type of unit, give a warning 
			System.out.println("Unit Invalid! (Must be \"kg\" or \"g\" or \"ml\" or \"l\")");
			return false;
		}
		
	}
}
