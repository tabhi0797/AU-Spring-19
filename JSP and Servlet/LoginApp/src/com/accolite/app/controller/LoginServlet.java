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

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getSession().invalidate();
		RequestDispatcher loginPage = request.getRequestDispatcher("login.jsp");
		loginPage.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String connString = getServletContext().getInitParameter("connString");
		String driver = getServletContext().getInitParameter("driver");
		String dbUserName = getServletContext().getInitParameter("dbUserName");
		String dbPwd = getServletContext().getInitParameter("dbPwd");

		try {
			// setting up driver
			Class.forName(driver);
			Connection con = DriverManager.getConnection(connString, dbUserName, dbPwd);
			
			// preparing a sql statement
			PreparedStatement sqlStmt = con.prepareStatement("select pwd, nickname, city from test.users where username = ?");
			sqlStmt.setString(1, username);

			// executing query
			ResultSet result = sqlStmt.executeQuery();
			if (result.next() == false)
				onCredentialError(request, response);
			else {
				String actualPassword = result.getString(1);

				if (actualPassword.equals(password)) {
					
					//valid user: storing the username, nickname, city in session
					String nickname = result.getString(2);
					String city = result.getString(3);
					
					HttpSession session = request.getSession();
					session.setAttribute("usertoken", username);
					session.setAttribute("nickname", nickname);
					session.setAttribute("city", city);
					session.setAttribute("password", password);
					response.sendRedirect(getServletContext().getContextPath() + "/home");
					
				} else {
					onCredentialError(request, response);
				}
			}
			
			sqlStmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver class not found");
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e);
		}

	}

	public void onCredentialError(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setAttribute("error", "Invalid Username/Password");
			RequestDispatcher loginPage = request.getRequestDispatcher("login.jsp");
			loginPage.include(request, response);
		} catch (IOException | ServletException e) {
			System.out.println("An Exception occured at server : " + e);
		}
		
	}

}
