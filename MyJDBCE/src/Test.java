import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		try {
			display();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("After display method call");
	}

	public static void display() throws IOException, ClassNotFoundException {
		say();
	}

	public static void say() throws IOException, ClassNotFoundException {
		System.out.println("I am from say Method");
		Class.forName("com.mysql.cj.jdbc.Drive");
		System.out.println("Driver CLass Loaded");
	}
}
