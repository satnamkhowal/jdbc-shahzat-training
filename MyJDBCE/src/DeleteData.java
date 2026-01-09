import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class lOaded");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:/mydb", "root", "root");
			PreparedStatement ps = conn.prepareStatement("delete from student where id=?");
			int id = 4;
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
