package com.groot.abc;

import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/process")
public class UserReg extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		String n1=req.getParameter("name");
		String p1=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");
			//jdbc:<subprotocol>://<host>:<port>/<databaseName>

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","root");
			PreparedStatement ps=conn.prepareStatement("insert into users (name,password) value(?,?)");
			ps.setString(1, n1);
			ps.setString(2, p1);
			int i= ps.executeUpdate();
			System.out.println(i);
			PrintWriter out= res.getWriter();
			out.print("inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}
