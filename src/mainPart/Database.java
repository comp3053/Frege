package mainPart;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import UI.HomePage;
 
public class Database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/BrewDay";
 
    static final String USER = "root";
    static final String PASS = "xiaocong310";
 
    public static boolean dbNewRecipe(String recipeName, float recipeQuantity, String recipeUnit, ArrayList<RecipeIngredient> ingredients) {
    	int recipeID = 0;
    	String sql = "INSERT INTO recipe (RecipeName, Unit, Quantity) VALUES (\"" + recipeName + "\", \"" + recipeUnit + "\", " + recipeQuantity + ")";
    	System.out.println(sql);
    	Connection conn = null;
    	boolean flag = true;
    	
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate(sql);
		    
		    recipeID = dbGetRecipeID(recipeName);
		    System.out.println("Id = " + recipeID);
            
            for (int i = 0; i < ingredients.size(); i++)
            {
            	flag = dbNewRecipeIngredient(recipeID,ingredients.get(i));
            	if (!flag) break;
            }

            stmt.close();
            conn.close();
            
            return flag;
        } catch(SQLException e)
        {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return false;
    }

    public static boolean dbNewRecipeIngredient(int recipeID, RecipeIngredient ingredient) {
    	String ingredientName = ingredient.getIngredientName();
    	String ingredientUnit = ingredient.getUnit();
    	float ingredientQuantity = ingredient.getQuantity();
    	String sql = "INSERT INTO RecipeIngredient (RecipeID, IngredientName, Unit, Quantity) "
    			+ "VALUES (" + recipeID + ", \"" + ingredientName + "\", \"" + ingredientUnit + "\", " + ingredientQuantity + ")";
    	System.out.println(sql);
    	boolean result = false;
    	Connection conn = null;
    	
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            
            return true;
        } catch(SQLException e)
        {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return result;
    }
    
    public static boolean dbUpdateCapacity(float capacity) {
		String sql = "UPDATE Equipment SET Capacity = " + capacity + " WHERE name = \"Frege\"";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    stmt = conn.createStatement();
		    stmt.executeUpdate(sql); 
		
		    stmt.close();
		    conn.close();
		    
		    return true;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public static float dbGetCapacity() {
    	String sql = "SELECT Capacity FROM Equipment WHERE name = \"Frege\"";
		System.out.println(sql);
		Connection conn = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    float capacity = 0;
		    while(rs.next()) {
		    	capacity  = rs.getFloat("Capacity");
		    }

		    stmt.close();
		    conn.close();
		   
		    return capacity;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
    }
    
    public static boolean dbUpdateStorageIngredient(String name, float quantity) {
		String sql = "UPDATE StorageIngredient SET Quantity = " + quantity + " WHERE IngredientName = \"" + name + "\"";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    stmt = conn.createStatement();
		    stmt.executeUpdate(sql); 
		
		    stmt.close();
		    conn.close();
		    
		    return true;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
    }

    public static boolean dbUpdateRecipeIngredient(int recipeID, String ingredient, float quantity) {
		String sql = "UPDATE RecipeIngredient SET Quantity = " + quantity + 
				" WHERE RecipeID = " + recipeID + " AND IngredientName = \"" + ingredient + "\"";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    stmt = conn.createStatement(  );
		    stmt.executeUpdate(sql); 
		
		    stmt.close();
		    conn.close();
		    
		    return true;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public static int dbAddNote(Note note) {
    	String noteRecipe = note.getRecipeName();
    	String noteTitle = note.getTitle();
    	java.sql.Date noteDate = note.getDate();
    	String noteContent = note.getContent();
    	String sql = "INSERT INTO Note (title, recipeName, date, content) VALUES "
    			+ "(\"" + noteTitle + "\", \""+ noteRecipe + "\", \'" + noteDate + "\', \"" + noteContent + "\")";
    	System.out.println(sql);
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		int noteID = 0;
    	
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
		    stmt = conn.createStatement();
		    stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		    rs = stmt.getGeneratedKeys();
		    if (rs.next()) {  
		        noteID = rs.getInt(1);  
		    } 
		    
		    stmt.close();
		    conn.close();
        } catch(SQLException e)
        {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return noteID;
    }

    public static float dbGetStorageingredientQuantity(String IngredientName) {
		String sql = "SELECT Quantity FROM StorageIngredient WHERE IngredientName = \"" + IngredientName + "\"";
		System.out.println(sql);
		Connection conn = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    float quantity = 0;
		    while(rs.next()) {
			    quantity  = rs.getFloat("Quantity");
		    }

		    stmt.close();
		    conn.close();
		   
		    return quantity;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
    }
    
    public static ArrayList<Float> dbGetRecipeIngredientQuantity(int RecipeID) {
    	ArrayList<Float> res = new ArrayList<Float>();
    	String sql = "SELECT Quantity FROM RecipeIngredient WHERE RecipeID = \"" + RecipeID + "\";";
    	System.out.println(sql);
		Connection conn = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);

		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    float quantity = 0;
		    while(rs.next()) {
			    quantity  = rs.getFloat("Quantity");
			    res.add(quantity);
			    System.out.println(quantity);
		    }

		    stmt.close();
		    conn.close();
		   
		    return res;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
    
	public static int dbGetRecipeID(String RecipeName) {
		String sql = "SELECT id FROM Recipe WHERE RecipeName = \"" + RecipeName + "\";";
		System.out.println(sql);
		Connection conn = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    int id = 0;
		    while(rs.next()) {
			    id  = rs.getInt("id");
		    }

		    stmt.close();
		    conn.close();
		   
		    return id;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean dbDeleteRecipe(String RecipeName) {
		// check whether the recipe is in the list
		if (dbGetRecipeID(RecipeName) == 0) return false;
		
		String sql = "DELETE FROM Recipe Where RecipeName = \"" + RecipeName + "\"";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    stmt = conn.createStatement(  );
		    stmt.executeUpdate(sql); 
		
		    stmt.close();
		    conn.close();
		    
		    return true;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static float dbGetEquipmentCapacity() {
		String sql = "SELECT Capacity FROM Equipment WHERE name = \"Frege\"";
		System.out.println(sql);
		Connection conn = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    float quantity = 0;
		    while(rs.next()) {
			    quantity  = rs.getFloat("Capacity");
			    System.out.println(quantity);
		    }

		    stmt.close();
		    conn.close();
		   
		    return quantity;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static ArrayList<Integer> dbGetAllRecipeID() {
		ArrayList<Integer> res = new ArrayList<Integer>();
    	String sql = "SELECT id FROM Recipe";
    	System.out.println(sql);
		Connection conn = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    int id = 0;
		    while(rs.next()) {
			    id = rs.getInt("id");
			    res.add(id);
		    }

		    stmt.close();
		    conn.close();
		   
		    return res;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String dbGetRecipeName(int recipeID) {
		String sql = "SELECT RecipeName FROM Recipe WHERE id = " + recipeID;
		System.out.println(sql);
		Connection conn = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    String name = new String();
		    while(rs.next()) {
			    name = rs.getString("RecipeName");
		    }

		    stmt.close();
		    conn.close();
		   
		    return name;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Note> dbGetAllNotes() {
		ArrayList<Note> allNotes = new ArrayList<Note>();
		String sql = "SELECT * FROM Note";
		System.out.println(sql);
		Connection conn = null;
		
		try{
		    Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next()) {
		    	String recipeName = rs.getString("recipeName");
			    String title = rs.getString("title");
			    java.sql.Date date = rs.getDate("date");
			    String content = rs.getString("content");
			    Note note = new Note(recipeName, title, date, content);
			    allNotes.add(note);
		    }

		    stmt.close();
		    conn.close();
		   
		    return allNotes;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean dbBrew(int recipeID, int noteID, float batchSize) {
    	String sql = "INSERT INTO Brew (RecipeID, NoteID, BatchSize) VALUES (" + recipeID + ", " + noteID + ", " + batchSize + ")";
    	System.out.println(sql);
    	Connection conn = null;
    	
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            
            return true;
        } catch(SQLException e)
        {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return false;
	}
	
	public static void main(String[] args) {
//		if (Recipe.recommendRecipe(10).size() == 0) {
//			System.out.println(Recipe.checkMissing(12, 10));
//		} else {
//			System.out.println(Recipe.recommendRecipe(1));
//		}
		Note note = new Note("zy", "title", "gggg");
		System.out.println(dbAddNote(note));
	}

}