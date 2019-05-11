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
 
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/BrewDay";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "xiaocong310";
 
    public static boolean dbNewRecipe(String recipeName, float recipeQuantity, String recipeUnit, ArrayList<RecipeIngredient> ingredients) {
    	int recipeID = 0;
    	String sql = "INSERT INTO recipe (RecipeName, Unit, Quantity) VALUES (\"" + recipeName + "\", \"" + recipeUnit + "\", " + recipeQuantity + ")";
    	System.out.println(sql);
    	Connection conn = null;
    	boolean flag = true;
    	
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate(sql);
		    
		    recipeID = dbGetRecipeID(recipeName);
		    System.out.println("Id = " + recipeID);
            
            for (int i = 0; i < ingredients.size(); i++)
            {
            	flag = dbNewRecipeIngredient(recipeID,ingredients.get(i));
            }

            // 完成后关闭
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
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate(sql);

            // 完成后关闭
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
    
    public static boolean dbUpdateCapacity(Equipment equipment) {
    	String name = equipment.getName();
	    float capacity = equipment.getCapacity();
		String sql = "UPDATE Equipment SET Capacity = " + capacity + " WHERE name = \"" + name + "\"";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    stmt = conn.createStatement();
		    stmt.executeUpdate(sql); 
		
		    // 完成后关闭
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
    
    public static boolean dbUpdateStorageIngredient(StorageIngredient ingredient) {
    	String name = ingredient.getIngredientName();
	    float quantity = ingredient.getQuantity();
		String sql = "UPDATE StorageIngredient SET Quantity = " + quantity + " WHERE IngredientName = \"" + name + "\"";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    stmt = conn.createStatement();
		    stmt.executeUpdate(sql); 
		
		    // 完成后关闭
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

    public static boolean dbUpdateRecipeIngredient(RecipeIngredient ingredient) {
    	String name = ingredient.getIngredientName();
	    float quantity = ingredient.getQuantity();
		String sql = "UPDATE RecipeIngredient SET Quantity = " + quantity + " WHERE IngredientName = \"" + name + "\"";
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    stmt = conn.createStatement(  );
		    stmt.executeUpdate(sql); 
		
		    // 完成后关闭
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
    
    public static boolean dbAddNote(Note note) {
    	String noteTitle = note.getTitle();
    	java.sql.Date noteDate = note.getDate();
    	String noteContent = note.getContent();
    	String sql = "INSERT INTO Note (title, date, content) VALUES "
    			+ "(\"" + noteTitle + "\", \'" + noteDate + "\', \"" + noteContent + "\")";
    	System.out.println(sql);
    	Connection conn = null;
		Statement stmt = null;
    	
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
		    stmt = conn.createStatement(  );
		    stmt.executeUpdate(sql); 
		
		    // 完成后关闭
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

    public static float dbGetStorageingredientQuantity(String IngredientName) {
		String sql = "SELECT Quantity FROM StorageIngredient WHERE IngredientName = \"" + IngredientName + "\";";
		Connection conn = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    float quantity = 0;
		    while(rs.next()) {
			    quantity  = rs.getFloat("Quantity");
			    System.out.println(quantity);
		    }
		    // 完成后关闭
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
    
    public static ArrayList<Float> dbGetRecipeingredientQuantity(Recipe recipe) {
    	ArrayList<Float> res = new ArrayList<Float>();
    	int RecipeID = dbGetRecipeID(recipe.getRecipeName());
    	String sql = "SELECT Quantity FROM RecipeIngredient WHERE RecipeID = \"" + RecipeID + "\";";
    	System.out.println(sql);
		Connection conn = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    float quantity = 0;
		    while(rs.next()) {
			    quantity  = rs.getFloat("Quantity");
			    res.add(quantity);
			    System.out.println(quantity);
		    }
		    // 完成后关闭
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
    
	private static int dbGetRecipeID(String RecipeName) {
		String sql = "SELECT id FROM Recipe WHERE RecipeName = \"" + RecipeName + "\";";
		System.out.println(sql);
		Connection conn = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    int id = 0;
		    while(rs.next()) {
			    id  = rs.getInt("id");
		    }
		    // 完成后关闭
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
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    stmt = conn.createStatement(  );
		    stmt.executeUpdate(sql); 
		
		    // 完成后关闭
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
		dbDeleteRecipe("Test3");
	}

}