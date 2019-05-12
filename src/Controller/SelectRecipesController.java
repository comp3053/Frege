package Controller;

import mainPart.Brew;

public class SelectRecipesController {
	public SelectRecipesController() {
		
	}
	
	public boolean brewRecipe(String recipeName, float batchSize) {
		return Brew.brew(recipeName, batchSize);
	}
}
