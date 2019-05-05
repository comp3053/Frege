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
 
    public boolean addRecipe(Recipe recipe) {
    	String recipeName = recipe.getRecipeName();
    	String recipeUnit = recipe.getUnit();
    	float recipeQuantity = recipe.getQuantity();
    	ArrayList<RecipeIngredient> ingredients = recipe.getIngredients();
    	String sql = "INSERT INTO recipe (RecipeName, Unit, Quantity) VALUES (?, ?, ?)";
    	boolean result = false;
    	Connection conn = null;
        Statement stmt = null;
    	
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
            
            for (int i = 0; i < ingredients.size(); i++)
            {
            	addRecipeIngredient(,ingredients.get(i));
            }

            // 完成后关闭
            ps.close();
            conn.close();
            
            result = true;
            return result;
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return result;
    }

    public boolean addRecipeIngredient(int recipeID, RecipeIngredient ingredient) {
    	String ingredientName = ingredient.getIngredientName();
    	String ingredientUnit = ingredient.getUnit();
    	float ingredientQuantity = ingredient.getQuantity();
    	String sql = "INSERT INTO RecipeIngredient (RecipeID IngredientName, Unit, Quantity) VALUES (?, ?, ?, ?)";
    	boolean result = false;
    	Connection conn = null;
        Statement stmt = null;
    	
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
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return result;
    }
    
    public void addNote(String title, Date date, String content) {
        Connection conn = null;
        Statement stmt = null;
    	try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO Note (title, date, content) VALUES (" + title + "," + date + "," + content + ");";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            System.out.println(sql);

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
}