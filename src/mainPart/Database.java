package mainPart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
 
public class Database {
 
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/BrewDay";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "xiaocong310";
 
    public static int dbNewRecipe(String recipeName, float recipeQuantity, String recipeUnit, ArrayList<RecipeIngredient> ingredients) {
    	int recipeID = 0;
    	String sql = "INSERT INTO recipe (RecipeName, Unit, Quantity) VALUES (?, ?, ?)";
    	Connection conn = null;
    	
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, recipeName);
            ps.setString(2, recipeUnit);
            ps.setObject(3, recipeQuantity);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            recipeID = rs.getInt(1);
            
            for (int i = 0; i < ingredients.size(); i++)
            {
            	dbNewRecipeIngredient(recipeID,ingredients.get(i));
            }

            // 完成后关闭
            ps.close();
            conn.close();
        } catch(SQLException e)
        {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return recipeID;
    }

    public static boolean dbNewRecipeIngredient(int recipeID, RecipeIngredient ingredient) {
    	String ingredientName = ingredient.getIngredientName();
    	String ingredientUnit = ingredient.getUnit();
    	float ingredientQuantity = ingredient.getQuantity();
    	String sql = "INSERT INTO RecipeIngredient (RecipeID IngredientName, Unit, Quantity) VALUES (?, ?, ?, ?)";
    	boolean result = false;
    	Connection conn = null;
    	
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, recipeID);
            ps.setString(2, ingredientName);
            ps.setString(3, ingredientUnit);
            ps.setFloat(4, ingredientQuantity);
            ps.executeUpdate();

            // 完成后关闭
            ps.close();
            conn.close();
            
            result = true;
            return result;
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
		String sql = "UPDATE Equipment SET Capacity = ? WHERE name = ?";
		boolean result = false;
		Connection conn = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setFloat(1, capacity);
		    ps.setString(2, name);
		    ps.executeUpdate();
		
		    // 完成后关闭
		    ps.close();
		    conn.close();
		    
		    result = true;
		    return result;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    public static boolean dbUpdateStorageIngredient(StorageIngredient ingredient) {
    	String name = ingredient.getIngredientName();
	    float quantity = ingredient.getQuantity();
		String sql = "UPDATE StorageIngredient SET Quantity = ? WHERE name = ?";
		boolean result = false;
		Connection conn = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setFloat(1, quantity);
		    ps.setString(2, name);
		    ps.executeUpdate();
		
		    // 完成后关闭
		    ps.close();
		    conn.close();
		    
		    result = true;
		    return result;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
    }

    public static boolean dbUpdateRecipeIngredient(RecipeIngredient ingredient) {
    	String name = ingredient.getIngredientName();
	    float quantity = ingredient.getQuantity();
		String sql = "UPDATE RecipeIngredient SET Quantity = ? WHERE name = ?";
		boolean result = false;
		Connection conn = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setFloat(1, quantity);
		    ps.setString(2, name);
		    ps.executeUpdate();
		
		    // 完成后关闭
		    ps.close();
		    conn.close();
		    
		    result = true;
		    return result;
		} catch(SQLException e)
		{
		    System.err.println("Error: " + e);
		    e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    public static boolean dbAddNote(Note note) {
    	String noteTitle = note.getTitle();
    	java.sql.Date noteDate = note.getDate();
    	String noteContent = note.getContent();
    	String sql = "INSERT INTO Note (title, date, content) VALUES (?, ?, ?)";
    	boolean result = false;
    	Connection conn = null;
    	
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, noteTitle);
            ps.setDate(2, noteDate);
            ps.setString(3, noteContent);
            ps.executeUpdate();

            // 完成后关闭
            ps.close();
            conn.close();
            
            result = true;
            return result;
        } catch(SQLException e)
        {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return result;
    }

    public static float dbGetStorageingredientQuantity(String name) {
		String sql = "SELECT Quantity FROM StorageIngredient WHERE IngredientName = ?";
		boolean result = false;
		Connection conn = null;
		
		try{
		    // 注册 JDBC 驱动
		    Class.forName(JDBC_DRIVER);
		
		    // 打开链接
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    // 执行查询
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, name);
		    ResultSet rs = ps.executeQuery(sql);
		
		    float quantity  = rs.getFloat("Quantity");
		    // 完成后关闭
		    ps.close();
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
}