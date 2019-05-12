package Controller;

import java.util.ArrayList;

import mainPart.Brew;
import mainPart.Database;
import mainPart.Recipe;

public class CheckRecipesController {
	public CheckRecipesController() {
		
	}
	
	public ArrayList<Float> getAbsoluteIngredient(String recipeName, float batchSize) {
		return Recipe.convertToAbsoluteMeasure(Database.dbGetRecipeID(recipeName), batchSize);
	}
	public ArrayList<Float> checkMissing(String recipeName, float batchSize) {
		return Recipe.checkMissing(Database.dbGetRecipeID(recipeName), batchSize);
	}
}
