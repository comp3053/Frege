package Controller;
import java.util.ArrayList;
import mainPart.Recipe;
import mainPart.RecipeIngredient;

public class RecipesAddController {
	public RecipesAddController() {
		
	}
	
	public boolean addRecipe(String name, float maltQ, float hopQ, float yeastQ, float sugarQ, float additiveQ) {
		ArrayList<RecipeIngredient> addR = new ArrayList<RecipeIngredient>();
		if(maltQ != 0) {
			RecipeIngredient malt = new RecipeIngredient("malt", maltQ, "kg");
			addR.add(malt);
		}
		if(hopQ != 0) {
			RecipeIngredient hop = new RecipeIngredient("hop", hopQ, "kg");
			addR.add(hop);
		}
		if(yeastQ != 0) {
			RecipeIngredient yeast = new RecipeIngredient("yeast", yeastQ, "kg");
			addR.add(yeast);
		}
		if(sugarQ != 0) {
			RecipeIngredient sugar = new RecipeIngredient("sugar", sugarQ, "kg");
			addR.add(sugar);
		}
		if(additiveQ != 0) {
			RecipeIngredient additive = new RecipeIngredient("additive", additiveQ, "kg");
			addR.add(additive);
		}
		
		return Recipe.addRecipe(name, 1, "l",addR);
	}
}
