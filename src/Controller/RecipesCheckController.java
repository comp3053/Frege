package Controller;

import java.util.ArrayList;

import mainPart.Database;

public class RecipesCheckController {
	public RecipesCheckController() {
		
	}
	
	public ArrayList<Float> getRecipeIngredient(String name){
		return Database.dbGetRecipeIngredientQuantity(Database.dbGetRecipeID(name));
	}
}
