import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserRecordUsingPreparedStatement {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:/mydb", "root", "root");
			System.out.println("Connecton done");
			Statement stmt=conn.createStatement();
			int i=stmt.executeUpdate("insert into student (id,name,fee) value(4,'Kishan',455434),(3,'Rana Sanga',4788)");
			System.out.println(i);
			System.out.println();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
