import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InserMultipleUsingBatch {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:/mydb", "root", "root");
			System.out.println("Connecton done");
			PreparedStatement ps= conn.prepareStatement("insert into student (name,fee) value(?,?)");
			ps.setString(1, "Kishan");
			ps.setFloat(2, 678.9f);
			ps.addBatch();
			ps.setString(1, "Geeta");
			ps.setFloat(2, 6787.9f);
			ps.addBatch();
			ps.setString(1, "Heena");
			ps.setFloat(2, 6738.9f);
			ps.addBatch();
			int i[]=ps.executeBatch();
			System.out.println(i.length);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
