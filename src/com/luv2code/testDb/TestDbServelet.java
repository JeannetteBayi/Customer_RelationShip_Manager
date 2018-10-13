package com.luv2code.testDb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServelet
 */
@WebServlet("/TestDbServelet")
public class TestDbServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String user = "hbstudent";
		String pass = "hbstudent";
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
	//	String driver = "com.mysql.jdbc.Driver";
		System.out.println("trying");
		try {
			
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url, user, pass );
			System.out.println("success"+conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
