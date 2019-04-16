import java.util.ArrayList;

public class Recipe {
	private String recipeName;
	private float quantity;
	private String unit;
	private ArrayList RecipeIngredient;
	
	public void setRecipeName(String name) {
		this.recipeName = name;
	}
	
	public String getRecipeName() {
		return this.recipeName;
	}
	
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	public float getQuantity() {
		return this.quantity;
	}
	
	public boolean setUnit(String unit) {
		if (unit.equals("kg") || unit.equals("g") || unit.equals("ml") || unit.equals("l")) {
			this.unit = unit;
			return true;
		}
		return false;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public boolean updateIngredient(String ingreName, float amount) {
		if ((amount >= 0) && (ingreName.equals("malts")||ingreName.equals("hops")||ingreName.equals("yeasts")||ingreName.equals("sugars")||ingreName.equals("additives"))) {
			
			return true;
		}
		return false;
	}
}
