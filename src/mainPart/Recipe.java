package mainPart;
import java.util.ArrayList;
import java.util.Map;

public class Recipe<ingredients> {
	private int id;
	private String recipeName;
	private float quantity;
	private String unit;
	private ArrayList<RecipeIngredient> ingredients;
	private Map<String, Brew> Brews;
	
	public Recipe(String recipeName, float quantity, String unit, ArrayList<RecipeIngredient> ingredients) {
		this.recipeName = recipeName;
		this.quantity = quantity;
		this.unit = unit;
		this.ingredients = ingredients;
		this.id = Database.dbNewRecipe(recipeName, quantity, unit, ingredients);
	}
	
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
	
	public ArrayList<RecipeIngredient> getIngredients() {
		return ingredients;
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
	
	public boolean updateRecipeIngredient(String ingreName, float quantity) {
		if ((quantity >= 0))
		{
			switch (ingreName)
			{
			case "malts":
				ingredients.get(0).updateQuantity(quantity);
				Database.dbUpdateRecipeIngredient(ingredients.get(0));
				break;
			case "hops":
				ingredients.get(1).updateQuantity(quantity);
				Database.dbUpdateRecipeIngredient(ingredients.get(1));
				break;
			case "yeasts":
				ingredients.get(2).updateQuantity(quantity);
				Database.dbUpdateRecipeIngredient(ingredients.get(2));
				break;
			case "sugars":
				ingredients.get(3).updateQuantity(quantity);
				Database.dbUpdateRecipeIngredient(ingredients.get(3));
				break;
			case "additives":
				ingredients.get(4).updateQuantity(quantity);
				Database.dbUpdateRecipeIngredient(ingredients.get(4));
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
	
	public boolean CheckIngredients(float batchSize) {
		boolean flag = true;
		for (int i = 0; i < ingredients.size(); i++)
		{
			if (ingredients.get(i).getQuantity() < batchSize)
			{
				flag = false;
			}
		}
		return flag;
	}	
}
