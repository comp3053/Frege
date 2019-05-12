package Controller;

import java.util.ArrayList;

import mainPart.Brew;
import mainPart.Database;
import mainPart.Recipe;

public class CheckRecipesController {
	public CheckRecipesController() {
		
	}
	
	public ArrayList<String> getAllRecipeName(){
		return Recipe.getAllRecipeName();
	}
}
