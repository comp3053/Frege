import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Brew<recipes> {
	private float batchSize;
	private Date date;
	private Map<String, Recipe> recipe;
	//private ArrayList<Recipe> recipes;
	private ArrayList<Ingredient> ingredient;
	private ArrayList<RecipeIngredient> RIn;
	
	
	public float getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(float batchSize) {
		this.batchSize = batchSize;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void Brew(String recipeName) {
		//unfinished method
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		recipes = checkRecipes();
		for(int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).getRecipeName().equals(recipeName)) {
				for(int j = 0; j < ingredient.size(); j++) {
					String a = (String)recipes.get(i).getIngredients().get(j);
					switch (a) {
					case "malts":
						recipes.get(i).getIngredients();
						
						break;
					case "hops":
						
						break;
					case "yeasts":
						
						break;
					case "sugars":
						
						break;
					case "additives":
						
						break;
					default:
						System.out.println("Ingredient invaild!");
						break;
					}
				}
			}
		}
	}
	
	public ArrayList<Recipe> checkRecipes() {
		//unfinished method
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		for (int i = 0; i < recipes.size(); i++){
			if (recipes.get(i).CheckIngredients(this.batchSize) == true){
				result.add(recipes.get(i));
			}
		}
		return result;
	}
	
	public void addRecipe(String recipeName, Recipe r) {
		if(!recipe.containsKey(recipeName))
		{
			recipe.put(recipeName, r);
			r.addBrew(recipeName, this);
		}
	}
}
