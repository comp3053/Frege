package Controller;

import java.util.ArrayList;

import mainPart.Recipe;

public class BrewController {
	public BrewController() {
		
	}
	
	public ArrayList<String> recommandRecipe(float batchSize) {
		return Recipe.recommendRecipe(batchSize);
	}
}
