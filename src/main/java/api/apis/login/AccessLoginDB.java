package api.apis.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import com.journaldev.spring.dbconnection.DBConnection;
import com.journaldev.spring.model.BookModel;

public class AccessLoginDB {

	DBConnection dbConnection = new DBConnection(); // Class to set up connection with mysql database
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	final private String database = "bookapp";

	public String readLogin(LoginBean loginBean) {
		try {

			connect = dbConnection.connectToDB();

			System.out.println("CHECK POINT 1");

			String userName = loginBean.getUsername(); // Keeping user entered values in temporary variables.
			String password = loginBean.getPassword();

			statement = connect.createStatement();

			System.out.println("CHECK POINT 2");

			resultSet = statement.executeQuery("select * from " + database + ".user");

			System.out.println("CHECK POINT 3");

			while (resultSet.next()) {
				System.out.println("CHECK POINT 4");
				// int Id = resultSet.getInt("id");
				String userNameDB = resultSet.getString("username");
				String passwordDB = resultSet.getString("password");
				if (userName.equals(userNameDB) && password.equals(passwordDB)) {
					return "SUCCESS"; //// If the user entered values are already present in the database, then
										//// SUCCESS message will be sent.
				}

				System.out.println("CHECK POINT 5");

			}
		} catch (Exception e) {

			System.out.println("Error in TRY" + e);

		}
		return "ERROR in readStudent";
	}

	public int getUserType(LoginBean loginBean) {
		try {

			connect = dbConnection.connectToDB();

			System.out.println("CHECK POINT 1");

			String userName = loginBean.getUsername(); // Keeping user entered values in temporary variables.
			String password = loginBean.getPassword();

			statement = connect.createStatement();

			System.out.println("CHECK POINT 2");

			resultSet = statement.executeQuery(
					"select usertype from " + database + ".user where username='" + loginBean.getUsername() + "'");

			System.out.println("CHECK POINT 3");

			while (resultSet.next()) {
				System.out.println("CHECK POINT 4");
				// int Id = resultSet.getInt("id");
				int userType = resultSet.getInt("usertype");
				System.out.println("CHECK POINT 5");
				return userType;

			}
		} catch (Exception e) {

			System.out.println("Error in TRY" + e);

		}
		return 0;
	}
	
//	public  ArrayList getBooks(String searchPAttern) throws Exception {
//		ArrayList allData = new ArrayList();
//		Statement stmt = con.createStatement();
//
//		ResultSet rs = stmt.executeQuery("select * from bookapp.books where bookname like '%"+searchPAttern+"%' or author='%"+searchPAttern+"%' or booktype='%"+searchPAttern+"%'");
//		Integer i=0;
//		
//		while (rs.next()) {
//			LinkedList<BookModel> allUsersList = new LinkedList<BookModel>();			
//			allUsersList.add(new BookModel(
//					rs.getInt("id"), rs.getString("bookname"),
//					rs.getString("booktype"), rs.getString("author")));			
//			
//			allData.add(rs.getString("bookname") );	
//			
//			
//		}
//		return allData;
//	}
	

public ArrayList getBooksBasedOnID(String searchPattern) {
		ArrayList usernames = new ArrayList();
		ArrayList allData = new ArrayList();
		try {

			connect = dbConnection.connectToDB();

			System.out.println("CHECK POINT 1");

			statement = connect.createStatement();

			System.out.println("CHECK POINT 2");

			if (searchPattern != null) {
				System.out.println("CHECK POINT 3");

				resultSet = statement.executeQuery("select * from bookapp.books where bookname like '%"+searchPattern+"%' or author='%"+searchPattern+"%' or booktype='%"+searchPattern+"%'");
				while (resultSet.next()) {
			LinkedList<BookModel> allUsersList = new LinkedList<BookModel>();			
			allUsersList.add(new BookModel(
					resultSet.getInt("id"), resultSet.getString("bookname"),
					resultSet.getString("booktype"), resultSet.getString("author")));			
			
			allData.add(resultSet.getString("bookname") );	
			
			
		}
			} else {
				System.out.println("CHECK POINT 3");

				resultSet = statement.executeQuery(
						"select * from bookapp.books");

				while (resultSet.next()) {
			LinkedList<BookModel> allUsersList = new LinkedList<BookModel>();			
			allUsersList.add(new BookModel(
					resultSet.getInt("id"), resultSet.getString("bookname"),
					resultSet.getString("booktype"), resultSet.getString("author")));			
			
			allData.add(resultSet.getString("bookname") );	
			
			
		}
			}

			return allData;
		} catch (Exception e) {

			System.out.println("Error in TRY" + e);

		}
		return allData;
	}


	public ArrayList getUsersBasedOnUserType(int usertype) {
		ArrayList usernames = new ArrayList();
		try {

			connect = dbConnection.connectToDB();

			System.out.println("CHECK POINT 1");

			statement = connect.createStatement();

			System.out.println("CHECK POINT 2");

			if (usertype != 0) {
				System.out.println("CHECK POINT 3");

				resultSet = statement.executeQuery("select * from " + database + ".user where usertype=" + usertype);

				while (resultSet.next()) {
					System.out.println("CHECK POINT 4");
					// int Id = resultSet.getInt("id");
					String userName = resultSet.getString("username");
					usernames.add(userName);

				}
			} else {
				System.out.println("CHECK POINT 3");

				resultSet = statement.executeQuery(
						"select user.username, usertype.usertypename from user,usertype where user.usertype=usertype.usertypeid");

				while (resultSet.next()) {
					System.out.println("CHECK POINT 4");
					// int Id = resultSet.getInt("id");
					String userName = resultSet.getString("user.username");
					String userTypeName = resultSet.getString("usertype.usertypename");
					usernames.add(userName + ":" + userTypeName);

				}
			}

			return usernames;
		} catch (Exception e) {

			System.out.println("Error in TRY" + e);

		}
		return usernames;
	}

	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
