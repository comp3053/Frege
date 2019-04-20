import java.util.ArrayList;
import java.util.Map;

public class Recipe<ingredients> {
	private String recipeName;
	private float quantity;
	private String unit;
	private ArrayList<RecipeIngredient> ingredients;
	private Map<String, Brew> Brews;
	
	public void setRecipeName(String name) {
		this.recipeName = name;
	}
	
	public String getRecipeName() {
		return this.recipeName;
	}
	
	public boolean setQuantity(float quantity) {
		if (quantity >= 0)
		{
			this.quantity = quantity;
			return true;
		} else {
			System.out.println("Quantity should be non-negative!");
			return false;
		}
	}
	
	public float getQuantity() {
		return this.quantity;
	}
	
	public boolean setUnit(String unit) {
		if (unit.equals("kg") || unit.equals("g") || unit.equals("ml") || unit.equals("l"))
		{
			this.unit = unit;
			return true;
		} else {
			System.out.println("Unit invaild!");
			return false;
		}
		
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	// Qualifier with Brew class
	public void addBrew(String name, Brew b) {
		if (!Brews.containsKey(b))
		{
			Brews.put(name, b);
			b.addRecipe(name, this);
		}
	}
	
	public boolean updateIngredient(String ingreName, float amount) {
		if ((amount >= 0))
		{
			switch (ingreName)
			{
			case "malts":
				ingredients.get(0).updateAmount(amount);
				break;
			case "hops":
				ingredients.get(1).updateAmount(amount);
				break;
			case "yeasts":
				ingredients.get(2).updateAmount(amount);
				break;
			case "sugars":
				ingredients.get(3).updateAmount(amount);
				break;
			case "additives":
				ingredients.get(4).updateAmount(amount);
				break;
			default:
				System.out.println("Ingredient invaild!");
				return false;
			}
		} else {
			System.out.println("Ingredient amount should be non-negative!");
			return false;
		}
		return true;
	}
	
	public ingredients convertToAbsoluteMeasure(float batchSize) {
		// unfinished method
		return null;
	}
	
	public ArrayList<Ingredient> CheckIngredients(float batchSize) {
		ArrayList<Ingredient> result = new ArrayList<Ingredient>();
		
		for (int i = 0; i < ingredients.size(); i++)
		{
			if (ingredients.get(i).getAmount() < batchSize)
			{
				result.add(ingredients.get(i));
				
			}
		}
		return result;
	}			
}
