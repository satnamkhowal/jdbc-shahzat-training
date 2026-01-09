import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class lOaded");
			Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:/mydb", "root", "root");
			Statement stmt=  conn.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from student");  //insert, update, delete  
			 while (rs.next()) {
				 System.out.println(rs);
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getFloat("fee"));
				System.out.println("=========================");
				
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
