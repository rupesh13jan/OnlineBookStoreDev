package com.journaldev.spring.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.dbconnection.DBConnection;
import com.journaldev.spring.model.BookModel;
import com.journaldev.spring.model.FormBean;
import com.journaldev.spring.model.User;
import api.apis.login.AccessLoginDB;
import api.apis.login.LoginBean;
import api.apis.login.RegisterBean;
import api.apis.login.RegisterUserDB;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	String username;
	String password;
	int otp;
	int paymentid;
	int user_id = 0;
	RestStatementAPI restApi = new RestStatementAPI();

	@RequestMapping(value = "/dummy", method = RequestMethod.GET)
	public String dummy(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		return "dummy";
	}
	
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/CeleryJuice", method = RequestMethod.GET)
	public String celery(@Validated LoginBean user, Model model) throws Exception {
		System.out.println("CeleryJuice Requested ");

		System.out.println(username);
		System.out.println(password);

		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		Map<Integer, LinkedList<Users>> allData = restApi.displayUsersBasedOnName(con, username);
		
		for (Entry<Integer, LinkedList<Users>> element : allData.entrySet()) {

			for (Users ele : element.getValue()) {
				user_id = ele.getUser_id();
			}
		}
		System.out.println("User Id" + user_id);
		OrderUI orderjson = new OrderUI();
		orderjson.setUser_id(user_id);
		orderjson.setBook_id(1);

		AfterOrder afterorder = new AfterOrder();
		afterorder.setPaymentStatus("NotStarted");
		paymentid = restApi.getOrderIDUI(con, orderjson, afterorder);
		System.out.println(paymentid);
		return "CeleryJuice";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String payment(Locale locale, Model model) throws Exception {
		System.out.println("Payment Page Requested, locale = " + locale);
		System.out.println(username);
		System.out.println(password);
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		System.out.println("User Id" + user_id+"Payment Id"+paymentid);
		
		Payment paymentjson=new Payment();
		otp=restApi.changeStatusOfPaymentUI( con,  user_id,paymentid);
		System.out.println("Otp:"+otp);
		return "payment1";
	}

	@RequestMapping(value = "/orderstatus", method = RequestMethod.GET)
	public String orderstatus(Locale locale, Model model) throws Exception {
		System.out.println("Order status is requested, locale = " + locale);
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		System.out.println("User Id" + user_id+"Payment Id"+paymentid);
		
		int val=restApi.changeStatusOfPaymenttypeUI(con,user_id,paymentid,otp);
		System.out.println("3rd api cmpltd"+val);
		System.out.println(restApi.getOrderDetails(con,paymentid));
		return "orderstatus";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		System.out.println("Index file is requested, locale = " + locale);
		return "index";
	}

	@RequestMapping(value = "/viewbooks", method = RequestMethod.GET)
	public String viewbooks(Locale locale, Model model) {
		System.out.println("Books are requested, locale = " + locale);

		return "BookHome";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Locale locale, Model model) {
		System.out.println("Login Page Requested, locale = " + locale);
		return "Login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home(@Validated LoginBean user, Model model) {
		System.out.println("home Page Requested");

		model.addAttribute("userName", user.getUsername());
		model.addAttribute("uPassword", user.getPassword());
		username = user.getUsername();
		password = user.getPassword();
		if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) // Validation
		{
			return "index";
		} else {

			AccessLoginDB accessLoginDB = new AccessLoginDB();
			String accessValidate = accessLoginDB.readLogin(user); // Connecting to DB and Business logic to verify the
			System.out.println(accessLoginDB.getUserType(user)); // usertype value
			int usertype = accessLoginDB.getUserType(user);
			System.out.println("DB Value ::::" + accessValidate);
			if (accessValidate.equals("SUCCESS") && usertype == 1) // If function returns success then user will be
																	// rooted to Home page
			{
				System.out.println("Normal user access");
				return "BookHome";
			} else if (accessValidate.equals("SUCCESS") && usertype == 2) {
				System.out.println("Admin is accessing");
				return "BookHome";
			} else {
				System.out.println("No user in db");
				return "index";
			}
		}

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated RegisterBean reg, Model model) {
		System.out.println("inserting profile values to db");
		model.addAttribute("firstName", reg.getFirstName());
		model.addAttribute("lastName", reg.getLastName());
		model.addAttribute("password", reg.getPassword());
		model.addAttribute("contact", reg.getContact());
		model.addAttribute("address", reg.getAddress());
		model.addAttribute("username", reg.getUserName());
		model.addAttribute("username", reg.getEmail());
		model.addAttribute("confirmpassword", reg.getConfirmpassword());
		if ((reg.getUserName().isEmpty() || reg.getPassword().isEmpty())
				&& (reg.getUserName() != reg.getConfirmpassword())) // Validation
		{
			return "RegistrationPage";
		} else {

			RegisterUserDB accessLoginDB = new RegisterUserDB();
			String accessValidate = accessLoginDB.registerUser(reg); // Connecting to DB and Business logic to verify
																		// the
																		// user
			System.out.println("DB Value ::::" + accessValidate);
			if (accessValidate.equals("SUCCESS")) // If function returns success then user will be rooted to Home page
			{
				return "Login";
			} else {

				return "Login";
			}
		}

	}

	@RequestMapping(value = "/searchBooks/{searchPAttern}", method = RequestMethod.POST)
	public String searchBooks(@PathVariable String searchPAttern, @Validated FormBean reg, Model model)
			throws Exception {
		model.addAttribute("searchBook", reg.getSearchBook());
		System.out.println(reg.getSearchBook());
		System.out.println("Search Books are requested for  " + reg.getSearchBook());
//		DBConnection dbcon = new DBConnection();
//		Connection con = dbcon.connectToDB();
		AccessLoginDB accessLoginDB = new AccessLoginDB();
		ArrayList allData = accessLoginDB.getBooksBasedOnID(reg.getSearchBook());
		model.addAttribute("allBooks", allData);
		return "ViewBooks";

	}

	@RequestMapping(value = "/viewUsers/{id}", method = RequestMethod.GET)
	public String viewUsers(@PathVariable("id") int id, Model model) {
		System.out.println("View Users Page Requested");
		AccessLoginDB accessLoginDB = new AccessLoginDB();
		ArrayList accessValidate = accessLoginDB.getUsersBasedOnUserType(id);
		model.addAttribute("allUsers", accessValidate);
		return "displayUsers";
	}

	@RequestMapping(value = "/displayUsers/{id}", method = RequestMethod.GET)
	public String viewUsersJson(@PathVariable("id") int id, Model model) {
		System.out.println("View Users Page Requested");
		AccessLoginDB accessLoginDB = new AccessLoginDB();
		ArrayList accessValidate = accessLoginDB.getUsersBasedOnUserType(id);
		model.addAttribute("allUsers", accessValidate);
		return "Hi";

	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(@Validated User user, Model model) {
		System.out.println("Registration Page Requested");
		return "RegistrationPage";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
}
