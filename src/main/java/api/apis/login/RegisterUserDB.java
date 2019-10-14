package api.apis.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.journaldev.spring.dbconnection.DBConnection;

public class RegisterUserDB {

	DBConnection dbConnection = new DBConnection();

	public String registerUser(RegisterBean registerBean) {
		String firstName = registerBean.getFirstName();
		String lastName = registerBean.getLastName();
		String userName = registerBean.getUserName();
		String password = registerBean.getPassword();
		String address = registerBean.getAddress();
		String email = registerBean.getEmail();
		String contact = registerBean.getContact();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = dbConnection.connectToDB();
			String query = "insert into bookapp.user(username,firstname,lastname,email,password,address,contact,usertype) values (?,?,?,?,?,?,?,1)"; // Insert
			preparedStatement = con.prepareStatement(query); // Making use of prepared statements here to insert bunch
																// of data

			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, password);
			preparedStatement.setString(6, address);
			preparedStatement.setString(7, contact);
			int i = preparedStatement.executeUpdate();
			if (i != 0) // Just to ensure data has been inserted into the database
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
	}
}
