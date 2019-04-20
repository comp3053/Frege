
public class Ingredient {
	private String ingredientName;
	private float amount;
	private String unit;
	
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public boolean setUnit(String unit) {
		if (unit.equals("kg") || unit.equals("g") || unit.equals("ml") || unit.equals("l")) {
			this.unit = unit;
			return true;
		}
		else 
		{
			System.out.println("Unit Invalid! (Must be \"kg\" or \"g\" or \"ml\" or \"l\")");
			return false;
		}
		
	}
}
