package Controller;

import mainPart.Recipe;

public class RecipesDeleteController {
	public RecipesDeleteController() {
		
	}
	
	//View give the name that user want to delete
	public boolean deleteR(String name) {
		return Recipe.deleteRecipe(name);
	}
}
