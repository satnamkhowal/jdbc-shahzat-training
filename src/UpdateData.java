import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class lOaded");
			Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:/mydb", "root", "root");
			Statement stmt=  conn.createStatement();
			int i=stmt.executeUpdate("update student set name='Shree Ram', fee=3553 where id=2");  //insert, update, delete  
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
