package com.journaldev.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.journaldev.spring.model.BookModel;

public class RestStatementAPI {

	public Map<Integer, LinkedList<Users>> getUsersDetails(Connection con) throws Exception {
		Map<Integer, LinkedList<Users>> allData = new LinkedHashMap<Integer, LinkedList<Users>>();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from bookapp.user");
		while (rs.next()) {
			LinkedList<Users> allUsersList = new LinkedList<Users>();
			allUsersList.add(new Users(rs.getString("username"), rs.getString("password"), rs.getString("firstname"),
					rs.getString("lastname"), rs.getString("contact"), rs.getString("address"), rs.getString("email"),
					rs.getInt("user_id"), rs.getInt("usertype")));
			allData.put(rs.getInt("user_id"), allUsersList);
		}
		return allData;

	}

	public LinkedList getOrderDetails(Connection con,int paymentid) throws Exception {
		Map<Integer, LinkedList<Users>> allData = new LinkedHashMap<Integer, LinkedList<Users>>();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from bookapp.orders where paymentid="+paymentid);
		LinkedList allUsersList = new LinkedList();
		while (rs.next()) {
			
			allUsersList.add(rs.getInt("orderid"));
			allUsersList.add(rs.getInt("userid"));
			allUsersList.add(rs.getString("paymentstatus"));
			allUsersList.add(rs.getInt("bookid"));
			allUsersList.add(rs.getInt("otp"));
			
			allUsersList.add(rs.getString("orderstatus"));
			
		}
		return allUsersList;

	}
	public LinkedList<BookModel> getBooks(Connection con, String searchPAttern) throws Exception {
		LinkedList<BookModel> allData = new LinkedList<BookModel>();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from bookapp.books where bookname like '%" + searchPAttern
				+ "%' or author='%" + searchPAttern + "%' or booktype='%" + searchPAttern + "%'");
		Integer i = 0;

		while (rs.next()) {
			LinkedList<BookModel> allUsersList = new LinkedList<BookModel>();
			allUsersList.add(new BookModel(rs.getInt("id"), rs.getString("bookname"), rs.getString("booktype"),
					rs.getString("author")));

			allData.addAll(allUsersList);
		}
		return allData;
	}

	public int getOrderID(Connection con, Order orderjson, AfterOrder afterorder) throws Exception {
		PreparedStatement preparedStatement = null;
		afterorder.setPaymentID(getRandomNumber());
		String query = "insert into bookapp.orders(userid,paymentstatus,bookid,orderstatus,paymentid) values (?,?,?,?,?)";
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, orderjson.getUser_id());
		preparedStatement.setString(2, "NotStarted");
		preparedStatement.setInt(3, orderjson.getBook_id());
		preparedStatement.setString(4, "Created");
		preparedStatement.setInt(5, afterorder.getPaymentID());
		int i = preparedStatement.executeUpdate();
		return i;
	}

	public int getOrderIDUI(Connection con, OrderUI orderjson, AfterOrder afterorder) throws Exception {
		PreparedStatement preparedStatement = null;
		afterorder.setPaymentID(getRandomNumber());
		String query = "insert into bookapp.orders(userid,paymentstatus,bookid,orderstatus,paymentid) values (?,?,?,?,?)";
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, orderjson.getUser_id());
		preparedStatement.setString(2, "NotStarted");
		preparedStatement.setInt(3, orderjson.getBook_id());
		preparedStatement.setString(4, "Created");
		preparedStatement.setInt(5, afterorder.getPaymentID());
		int i = preparedStatement.executeUpdate();
		return afterorder.getPaymentID();
	}

	public static int getRandomNumber() {
		int x = (int) (Math.random() * ((1000 - 1) + 1)) + 1;
		return x;
	}

	public int changeStatusOfPayment(Connection con, Payment paymentjson) throws Exception {
		PreparedStatement preparedStatement = null;
		int otp = getOTP();
		String query = "update orders set paymentstatus=\"Pending\",orderstatus=\"Pending\",otp=\"" + otp
				+ "\" where paymentid='" + paymentjson.getPaymentid() + "' and paymentstatus='NotStarted' and userid='"
				+ paymentjson.getUser_id() + "' and bookid='" + paymentjson.getBook_id() + "'";
		preparedStatement = con.prepareStatement(query);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		if (i == 1) {
			return otp;
		} else {
			return otp;
		}

	}

	public int changeStatusOfPaymentUI(Connection con, int user_id, int paymentid) throws Exception {
		PreparedStatement preparedStatement = null;
		int otp = getOTP();
		String query = "update orders set paymentstatus=\"Pending\",orderstatus=\"Pending\",otp=\"" + otp
				+ "\" where paymentid='" + paymentid + "' and paymentstatus='NotStarted' and userid='" + user_id + "'";
		preparedStatement = con.prepareStatement(query);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		if (i == 1) {
			return otp;
		} else {
			return otp;
		}

	}

	public static int getOTP() {
		int x = (int) (Math.random() * ((10000 - 1) + 1)) + 1;
		return x;
	}

	
	public int changeStatusOfPaymenttypeUI(Connection con, int user_id, int paymentid, int otp) throws Exception {
		PreparedStatement preparedStatement = null;
		String query = "update orders set paymentstatus=\"Completed\", orderstatus=\"Completed\", " + "paymenttype=\""
				+"NetBanking"
				+ "\"  where otp='" + otp + "' and paymentid='" + paymentid
				+ "' and paymentstatus='Pending' and userid='" + user_id + "'";
		preparedStatement = con.prepareStatement(query);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		return i;

	}

	public int changeStatusOfPaymenttype(Connection con, PaymentType paymenttypejson) throws Exception {
		PreparedStatement preparedStatement = null;
		String query = "update orders set paymentstatus=\"Completed\", orderstatus=\"Completed\", paymenttype=\""
				+ paymenttypejson.getPaymenttype() + "\"  where otp='" + paymenttypejson.getOtp() + "' and paymentid='"
				+ paymenttypejson.getPaymentid() + "' and paymentstatus='Pending' and userid='"
				+ paymenttypejson.getUser_id() + "' and bookid='" + paymenttypejson.getBook_id() + "'";
		preparedStatement = con.prepareStatement(query);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		return i;

	}

	public Map<Integer, LinkedList<Users>> displayUsersBasedOnID(Connection con, int id) throws Exception {
		Map<Integer, LinkedList<Users>> allData = new LinkedHashMap<Integer, LinkedList<Users>>();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from bookapp.user where usertype=" + id);
		while (rs.next()) {
			LinkedList<Users> allUsersList = new LinkedList<Users>();
			allUsersList.add(new Users(rs.getString("username"), rs.getString("password"), rs.getString("firstname"),
					rs.getString("lastname"), rs.getString("contact"), rs.getString("address"), rs.getString("email"),
					rs.getInt("user_id"), rs.getInt("usertype")));
			allData.put(rs.getInt("user_id"), allUsersList);
		}
		return allData;
	}

	public boolean displayUsersBasedOnUsernameAndPassword(Connection con, String username,String password) throws Exception {
		//Map<Integer, LinkedList<Users>> allData = new LinkedHashMap<Integer, LinkedList<Users>>();
		Statement stmt = con.createStatement();
		System.out.println("select * from bookapp.user where username like '" + username+ "' and password like '"+password+"'");
		ResultSet rs = stmt.executeQuery("select * from bookapp.user where username like '" + username+ "' and password like '"+password+"'");
		
//		String val=rs.getString("username");
//		System.out.println(val);
		
		return rs.next();
	}
	public int displayPaymentId(Connection con, String id) throws Exception {
		Map<Integer, LinkedList<Users>> allData = new LinkedHashMap<Integer, LinkedList<Users>>();
		Statement stmt = con.createStatement();
		System.out.println("username:" + id);
		System.out.println("select * from bookapp.user where username like '" + id + "'");
		ResultSet rs = stmt.executeQuery("select * from bookapp.user where username like 'ram'");
		int paymentid = 0;
		while (rs.next()) {

			paymentid = rs.getInt("paymentid");

		}

		return paymentid;
	}

	public Map<Integer, LinkedList<Users>> displayUsersBasedOnName(Connection con, String id) throws Exception {
		Map<Integer, LinkedList<Users>> allData = new LinkedHashMap<Integer, LinkedList<Users>>();
		Statement stmt = con.createStatement();
		System.out.println("username:" + id);
		System.out.println("select * from bookapp.user where username like '" + id + "'");
		ResultSet rs = stmt.executeQuery("select * from bookapp.user where username like 'ram'");
		while (rs.next()) {
			LinkedList<Users> allUsersList = new LinkedList<Users>();
			allUsersList.add(new Users(rs.getString("username"), rs.getString("password"), rs.getString("firstname"),
					rs.getString("lastname"), rs.getString("contact"), rs.getString("address"), rs.getString("email"),
					rs.getInt("user_id"), rs.getInt("usertype")));
			allData.put(rs.getInt("user_id"), allUsersList);
		}

		return allData;
	}

	public int insertUsers(Connection con, Users usersjson) throws Exception {
		PreparedStatement preparedStatement = null;
		String query = "insert into bookapp.user(username,firstname,lastname,email,password,address,contact,usertype) values (?,?,?,?,?,?,?,1)"; // Insert
																																					// user
																																					// details
																																					// into
																																					// the
																																					// table
																																					// 'USERS'
		preparedStatement = con.prepareStatement(query); // Making use of prepared statements here to insert bunch of
															// data
		preparedStatement.setString(1, usersjson.getUsername());
		preparedStatement.setString(2, usersjson.getFirstname());
		preparedStatement.setString(3, usersjson.getLastname());
		preparedStatement.setString(4, usersjson.getEmail());
		preparedStatement.setString(5, usersjson.getPassword());
		preparedStatement.setString(6, usersjson.getAddress());
		preparedStatement.setString(7, usersjson.getContact());
		int i = preparedStatement.executeUpdate();
		System.out.println(i);

		return i;
	}

	public int updateUsers(Connection con, Users usersjson, String email) throws Exception {
		PreparedStatement preparedStatement = null;
		String query = "update user set usertype=" + usersjson.getUsertype() + " where email='" + email + "'"; // Insert
																												// user
																												// details
																												// into
																												// the
																												// table
																												// 'USERS'
		preparedStatement = con.prepareStatement(query); // Making use of prepared statements here to insert bunch of
															// data
		int i = preparedStatement.executeUpdate();
		System.out.println(i);

		return i;
	}

}
