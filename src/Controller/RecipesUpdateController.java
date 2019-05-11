package Controller;

import java.util.ArrayList;

import mainPart.Recipe;
import mainPart.RecipeIngredient;

public class RecipesUpdateController {
	public RecipesUpdateController() {
		
	}
	
	public boolean updateRecipe(String name, float maltQ, float hopQ, float yeastQ, float sugarQ, float additiveQ) {
		return Recipe.updateRecipe(name, maltQ, hopQ, yeastQ, sugarQ, additiveQ);
	} 
}
