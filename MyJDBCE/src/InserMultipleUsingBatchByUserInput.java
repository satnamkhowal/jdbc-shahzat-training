import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InserMultipleUsingBatchByUserInput {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:/mydb", "root", "root");
			System.out.println("Connecton done");
			PreparedStatement ps = conn.prepareStatement("insert into student (name,fee) value(?,?)");
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("Enter Student name.....");
				String name = sc.next();
				System.out.println("Enter Student fee.....");
				float fee = sc.nextFloat();
				ps.setString(1, name);
				ps.setFloat(2, fee);
				ps.addBatch();
				System.out.println("Do you want to insert more record y/n");
				String ans = sc.next();
				if (ans.startsWith("n")) {
					break;
				} else {
					continue;
				}
			}
			int i[]=ps.executeBatch();
			System.out.println(i.length);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
