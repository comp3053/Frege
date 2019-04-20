import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Brew {
	private float batchSize;
	private Date date;
	private Map<String, Recipe> recipe;
	
	public float getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(float batchSize) {
		this.batchSize = batchSize;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void Brew(String recipeName) {
		//unfinished method
	}
	public ArrayList checkRecipes() {
		//unfinished method
		return null;
	}
	
	public void addRecipe(String recipeName, Recipe r) {
		if(!recipe.containsKey(recipeName))
		{
			recipe.put(recipeName, r);
			r.addBrew(recipeName, this);
		}
	}
}
