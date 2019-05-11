package Controller;

import java.util.ArrayList;

import mainPart.Recipe;

public class BrewController {
	public BrewController() {
		
	}
	
	public ArrayList<Recipe> recommandRecipe(float batchSize) {
		return Recipe.recommandRecipe(batchSize);
	}
}
