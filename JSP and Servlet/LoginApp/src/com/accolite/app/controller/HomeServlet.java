package com.accolite.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/HomeServlet", "/home" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher homePage = request.getRequestDispatcher("home.jsp");
		homePage.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = (String)request.getSession().getAttribute("usertoken");
		String nickname = (String)request.getParameter("nickname");
		String city = (String)request.getParameter("city");
		String password = (String)request.getParameter("password");
		String connString = getServletContext().getInitParameter("connString");
		String driver = getServletContext().getInitParameter("driver");
		String dbUserName = getServletContext().getInitParameter("dbUserName");
		String dbPwd = getServletContext().getInitParameter("dbPwd");

		
		try {
			// setting up driver
			Class.forName(driver);
			Connection con = DriverManager.getConnection(connString, dbUserName, dbPwd);
			con.setAutoCommit(false);
			
			// preparing a sql statement
			Statement sqlStmt = con.createStatement();
//			sqlStmt.setString(1, nickname);
//			sqlStmt.setString(2, city);
//			sqlStmt.setString(3, password);
//			sqlStmt.setString(4, username);
			
			// executing query
			int result = sqlStmt.executeUpdate("update test.users set username='"+username+"',pwd ='"+password+"',nickname ='"+nickname+"',city='"+city+"' where username = '"+username+"'");
			con.commit();
//			getServletConfig().getServletContext().setAttribute("usertoken", username);
			request.getSession().setAttribute("nickname", nickname);
			request.getSession().setAttribute("city", city);
			request.getSession().setAttribute("password", password);
			
			response.sendRedirect(request.getContextPath()+"/success.jsp");
			

			sqlStmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver class not found");
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e);
		}

	
	}

}
