package com.accolite.app.dbcon;

import java.util.*;
import com.accolite.app.models.*;
import java.sql.*;

public class MealsDTO {

	/*
	 * a method used for fetching all meals info from db
	 */
	public static List<Meal> getAllMeals() {
		List<Meal> meals = new ArrayList<Meal>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select id,mname,price from test.meal");

			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				Integer price = rs.getInt(3);

				meals.add(new Meal(id, name, price));
			}

			s.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meals;
	}

	/*
	 * a method used for getting info of a specific meal from db
	 */
	public static Meal getMeal(int id) {
		Meal meal = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select id,mname,price from test.meal where id=" + id);

			while (rs.next()) {
				Integer id1 = rs.getInt(1);
				String name = rs.getString(2);
				Integer price = rs.getInt(3);

				meal = new Meal(id, name, price);
			}

			s.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meal;
	}

	/*
	 * a method used to add a new meal into db
	 */
	public static String addMeal(Meal meal) {
		String name = meal.getName();
		int id = meal.getId();
		int price = meal.getPrice();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into test.meal values(?, ?, ?)");

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.executeUpdate();

			ps.close();
			con.close();
			return "inserted succefully";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/*
	 * a method used to update the existing meal in db
	 */
	public static String updateMeal(int id, Meal meal)
	{
		String name = meal.getName();
		int price = meal.getPrice();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
			PreparedStatement ps = con.prepareStatement("update test.meal set id=?,mname=?,price=? where id=?");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setInt(4, id);
			ps.executeUpdate();

			ps.close();
			con.close();
			return "updated succefully";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * a mthod used to delete a meal from db
	 */
	public static String deleteMeal(int id, Meal meal)
	{
		String name = meal.getName();
		int price = meal.getPrice();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from test.meal where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			con.close();
			return "deleted succefully";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
