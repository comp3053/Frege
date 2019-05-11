package Controller;

import mainPart.Brew;

public class SelectRecipesController {
	public SelectRecipesController() {
		
	}
	
	public boolean brewRecipe(String recipeName) {
		return Brew.brew(recipeName);
	}
}
