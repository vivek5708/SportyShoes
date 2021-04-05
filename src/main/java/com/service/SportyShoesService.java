package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.model.Footwear;
import com.model.Users;

@Service
public class SportyShoesService {

	public boolean loginValidate(String userName, String password) {
		if(userName.equals("vivek") && password.equals("dummy")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addProductService(int productId, String productName, String brand, String price, String productType, String imageUrl,String productDesc) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			PreparedStatement pst = conn.prepareStatement("insert into footwear(id, product_name, brand, price, product_type, image_url, product_desc, quantity_purchased) values(?,?,?,?,?,?,?,?)");

			pst.setInt(1, productId);
			pst.setString(2, productName);
			pst.setString(3, brand);
			pst.setString(4, price);
			pst.setString(5, productType);
			pst.setString(6, imageUrl);
			pst.setString(7, productDesc);
			pst.setInt(8, 0);

			pst.executeUpdate();

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();

		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
	}
	
	public ArrayList<Footwear> fetchFootwearProduct() {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Footwear> footwearList = new ArrayList<Footwear>();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			stmt = conn.createStatement();

			String sql = "SELECT * FROM footwear";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int id =  rs.getInt("Id");
				String productName = rs.getString("product_name");
				String brand = rs.getString("brand");
				String price = rs.getString("price");
				String productType = rs.getString("product_type");
				String imageUrl = rs.getString("image_url");
				String productDesc = rs.getString("product_desc");
				int quantity_purchased = rs.getInt("quantity_purchased");

				Footwear rObj = new Footwear(id, productName, brand, price, productType, imageUrl, productDesc,quantity_purchased);
				footwearList.add(rObj);
			}
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
		
		return footwearList;
	}
	
	public void deleteProduct(int id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			PreparedStatement pst = conn.prepareStatement("delete from footwear where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();

		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
	}
	
	public void putUserRecords(String firstName, String lastName, String email, String password) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			PreparedStatement pst = conn.prepareStatement("insert into user(firstName, lastName, email, password) values(?,?,?,?)");

			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, email);
			pst.setString(4, password);

			pst.executeUpdate();

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();

		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
	}
	
	public ArrayList<Users> fetchAllUsers(){
		
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Users> userList = new ArrayList<Users>();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			stmt = conn.createStatement();

			String sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String firstName =  rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String password = rs.getString("password");

				Users userObj = new Users(firstName, lastName, email, password);
				userList.add(userObj);
			}
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
		
		return userList;
	}
	
	public ArrayList<Users> searchUsers(String userName){
		Connection conn = null;
		ArrayList<Users> userList = new ArrayList<Users>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			PreparedStatement pst = conn.prepareStatement("select * from user where LOWER(firstName)=? OR LOWER(lastName)=?");

			pst.setString(1, userName.toLowerCase());
			pst.setString(2, userName.toLowerCase());

			//pst.executeUpdate();
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				String firstName =  rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String password = rs.getString("password");

				Users userObj = new Users(firstName, lastName, email, password);
				userList.add(userObj);
			}

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();

		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
		
		return userList;
	}
	
	public Footwear fetchFootwearObject(int id) {
		Connection conn = null;
		Footwear rObj = new Footwear();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			PreparedStatement pst = conn.prepareStatement("select * from footwear where id=?");

			pst.setInt(1, id);
			

			//pst.executeUpdate();
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				int id1 =  rs.getInt("Id");
				String productName = rs.getString("product_name");
				String brand = rs.getString("brand");
				String price = rs.getString("price");
				String productType = rs.getString("product_type");
				String imageUrl = rs.getString("image_url");
				String productDesc = rs.getString("product_desc");

				rObj = new Footwear(id1, productName, brand, price, productType, imageUrl, productDesc, 0);
				
			}

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();

		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
		
		return rObj;
	}
	
	public void updateFootwearProduct(int id, String productName, 
			String productBarnd, String productPrice, String productType, String imageUrl, String productDesc) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			PreparedStatement pst = conn.prepareStatement("update footwear set product_name=?, brand=?, price=?, product_type=?, image_url=?, product_desc=? where id=?");

			pst.setString(1, productName);
			pst.setString(2, productBarnd);
			pst.setString(3, productPrice);
			pst.setString(4, productType);
			pst.setString(5, imageUrl);
			pst.setString(6, productDesc);
			pst.setInt(7, id);

			pst.executeUpdate();

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();

		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
	}
	
	public void buyProduct(int id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			PreparedStatement pst = conn.prepareStatement("update footwear set quantity_purchased=quantity_purchased+1 where id=?");

			pst.setInt(1, id);

			pst.executeUpdate();

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();

		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
	}
	
	public ArrayList<Footwear> fetchProductsPurchased(){
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Footwear> footwearList = new ArrayList<Footwear>();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","");

			stmt = conn.createStatement();

			String sql = "SELECT * FROM footwear where quantity_purchased>0";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int id =  rs.getInt("Id");
				String productName = rs.getString("product_name");
				String brand = rs.getString("brand");
				String price = rs.getString("price");
				String productType = rs.getString("product_type");
				String imageUrl = rs.getString("image_url");
				String productDesc = rs.getString("product_desc");
				int quantity_purchased = rs.getInt("quantity_purchased");

				Footwear rObj = new Footwear(id, productName, brand, price, productType, imageUrl, productDesc,quantity_purchased);
				footwearList.add(rObj);
			}
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
		
		return footwearList;
	}
}
