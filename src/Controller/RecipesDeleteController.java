package Controller;

import mainPart.Recipe;

public class RecipesDeleteController {
	public RecipesDeleteController() {
		
	}
	
	public boolean deleteR(String name) {
		return Recipe.deleteRecipe(name);
	}
}
