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
 
    public static boolean addRecipe(Recipe recipe) {
    	String recipeName = recipe.getRecipeName();
    	String recipeUnit = recipe.getUnit();
    	float recipeQuantity = recipe.getQuantity();
    	ArrayList<RecipeIngredient> ingredients = recipe.getIngredients();
    	String sql = "INSERT INTO recipe (RecipeName, Unit, Quantity) VALUES (?, ?, ?)";
    	boolean result = false;
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
            int recipeID = rs.getInt(1);
            
            for (int i = 0; i < ingredients.size(); i++)
            {
            	addRecipeIngredient(recipeID,ingredients.get(i));
            }

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

    public static boolean addRecipeIngredient(int recipeID, RecipeIngredient ingredient) {
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
            System.out.println(result);

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
    
    public static boolean addNote(Note note) {
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
}