package Controller;

import java.util.ArrayList;

import mainPart.Recipe;
import mainPart.RecipeIngredient;

public class RecipesUpdateController {
	public RecipesUpdateController() {
		
	}
	
	public boolean updateRecipe(String name, float maltQ, float hopQ, float yeastQ, float sugarQ, float additiveQ) {
		ArrayList<RecipeIngredient> updateR = new ArrayList<RecipeIngredient>();
		if(maltQ != 0) {
			RecipeIngredient malt = new RecipeIngredient("malt", maltQ, "kg");
			updateR.add(malt);
		}
		if(hopQ != 0) {
			RecipeIngredient hop = new RecipeIngredient("hop", hopQ, "kg");
			updateR.add(hop);
		}
		if(yeastQ != 0) {
			RecipeIngredient yeast = new RecipeIngredient("yeast", yeastQ, "kg");
			updateR.add(yeast);
		}
		if(sugarQ != 0) {
			RecipeIngredient sugar = new RecipeIngredient("sugar", sugarQ, "kg");
			updateR.add(sugar);
		}
		if(additiveQ != 0) {
			RecipeIngredient additive = new RecipeIngredient("additive", additiveQ, "kg");
			updateR.add(additive);
		}
		
		return Recipe.updateRecipe();
	} 
}
