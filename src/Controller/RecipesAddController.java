package Controller;
import java.util.ArrayList;
import mainPart.Recipe;
import mainPart.RecipeIngredient;

public class RecipesAddController {
	public RecipesAddController() {
		
	}
	
	//View give the recipe name and ingredients amounts, controller gives them all to the database
	public boolean addRecipe(String name, float maltQ, float hopQ, float yeastQ, float sugarQ, float additiveQ) {
		ArrayList<RecipeIngredient> addR = new ArrayList<RecipeIngredient>();
		
		RecipeIngredient malt = new RecipeIngredient("malt", maltQ, "kg");
		addR.add(malt);
		
		RecipeIngredient hop = new RecipeIngredient("hop", hopQ, "kg");
		addR.add(hop);
		
		RecipeIngredient yeast = new RecipeIngredient("yeast", yeastQ, "kg");
		addR.add(yeast);
		
		RecipeIngredient sugar = new RecipeIngredient("sugar", sugarQ, "kg");
		addR.add(sugar);
		
		RecipeIngredient additive = new RecipeIngredient("additive", additiveQ, "kg");
		addR.add(additive);
		
		return Recipe.addRecipe(name, 1, "l",addR);
	}
}
