package Controller;
import java.util.ArrayList;
import mainPart.Recipe;
import mainPart.RecipeIngredient;

public class RecipesAddController {
	public RecipesAddController() {
		
	}
	
	public boolean addRecipe(String name, float maltQ, float hopQ, float yeastQ, float sugerQ, float additiveQ) {
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
		if(sugerQ != 0) {
			RecipeIngredient suger = new RecipeIngredient("suger", sugerQ, "kg");
			addR.add(suger);
		}
		if(additiveQ != 0) {
			RecipeIngredient additive = new RecipeIngredient("additive", additiveQ, "kg");
			addR.add(additive);
		}
		
		Recipe newRecipe = new Recipe(name, 1, "l", addR);
		return newRecipe.addRecipe(name, 1, "l",addR);
	}
}
