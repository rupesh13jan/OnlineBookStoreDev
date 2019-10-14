package com.journaldev.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.journaldev.spring.dbconnection.DBConnection;
import com.journaldev.spring.model.BookModel;
import com.journaldev.spring.model.User;

@RestController
public class RestApiController {

	@Autowired
	private Users user;
	@Autowired
	private MessageBean msg;
	@Autowired
	private AfterOrder afterorder;
	@Autowired
	private AfterPayment afterpayment;
	@Autowired
	private LoginBeanAPI loginBeanAPI;
	RestStatementAPI restApi = new RestStatementAPI();
	/** Get api for searching the books**/
	@RequestMapping(value = "/viewBooks/{searchPAttern}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody	
	public  LinkedList<BookModel>  searchBooks(@PathVariable String searchPAttern) throws Exception {
		System.out.println("Search Books are requested for  "+ searchPAttern);
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		LinkedList<BookModel> allData = restApi.getBooks(con,searchPAttern);
		return allData;
	}
	
	
	/** Get login api for searching the books**/
	@RequestMapping(value = "/loginapi", method = RequestMethod.POST, produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody	
	public  MessageBean  loginapi(@RequestBody LoginBeanAPI loginjson) throws Exception {
		System.out.println("login requested for  ");
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		boolean allData = restApi.displayUsersBasedOnUsernameAndPassword(con,loginjson.getUsername(),loginjson.getPassword());
		if (allData) {
			msg.setStatus(202);
			msg.setMessage("Login successfully");
			return msg;
		} else {
			msg.setStatus(500);
			msg.setMessage("Please provide valid user");
			return msg;
		}
		
	}
	
	

	/** Get api for displaying all users **/
	@RequestMapping(value = "/displayUsers", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map<Integer, LinkedList<Users>> getUsers() throws Exception {
		System.out.println("display uesrs");
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		Map<Integer, LinkedList<Users>> allData = restApi.getUsersDetails(con);
		con.close();
		return allData;
	}

	/**
	 * Get api for displaying all users based on id(0-normal users,1-admin
	 * users,2-merchants)
	 **/
	@RequestMapping(value = "/displayViewers/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map<Integer, LinkedList<Users>> getUsersBasedOnID(@PathVariable int id) throws Exception {

		System.out.println("display users based on id");
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		Map<Integer, LinkedList<Users>> allData = restApi.displayUsersBasedOnID(con, id);
		con.close();
		return allData;
	}
	
	
	@RequestMapping(value = "/displayViewer/{name}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map<Integer, LinkedList<Users>> getUsersBasedOnName(@PathVariable String name) throws Exception {

		System.out.println("display users based on id");
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		Map<Integer, LinkedList<Users>> allData = restApi.displayUsersBasedOnName(con, name);
		con.close();
		return allData;
	}
	
	
	/**1... Post api for creating order id **/
	/***1.It will create the order id and generate one payment id and payment status will be "not started"****/
	@RequestMapping(method = RequestMethod.POST, value = "/addToCart", headers = { "content-type=application/json" })
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody	
	public Map<String,LinkedList<AfterOrder>> addToCart(@RequestBody Order orderjson) throws Exception {
		System.out.println("1st API...order id creation");
		Map<String,LinkedList<AfterOrder>>  allData=new LinkedHashMap<String,LinkedList<AfterOrder>>();
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		int val=restApi.getOrderID(con,orderjson,afterorder);
		if (val == 1) {
		
			afterorder.setPaymentStatus("NotStarted");
			
			LinkedList<AfterOrder> allUsersList = new LinkedList<AfterOrder>();
			allUsersList.add(new AfterOrder(afterorder.getPaymentID(), afterorder.getPaymentStatus()));
			allData.put("OrderID", allUsersList);
			
		}else {
			afterorder.setPaymentID(0);
			System.out.println();
			afterorder.setPaymentStatus("Try after some time");
			
			LinkedList<AfterOrder> allUsersList = new LinkedList<AfterOrder>();
			allUsersList.add(new AfterOrder(afterorder.getPaymentID(), afterorder.getPaymentStatus()));
			allData.put("OrderID", allUsersList);
			
		}
		return allData;
	}
	
	public static int getRandomNumber(){
	    int x = (int)(Math.random()*((1000-1)+1))+1;
	    return x;
	}
	
	
	/**2... Post api for changing payment status**/
	@RequestMapping(method = RequestMethod.POST, value = "/buynow", headers = { "content-type=application/json" })
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody	
	public Map<String,LinkedList<AfterPayment>> buynow(@RequestBody Payment paymentjson) throws Exception {
		System.out.println("2nd API");
		Map<String,LinkedList<AfterPayment>>  allData=new LinkedHashMap<String,LinkedList<AfterPayment>>();
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		int val=restApi.changeStatusOfPayment(con,paymentjson);
		if (val != 0) {
			afterpayment.setPaymentstatus("Pending");
			afterpayment.setPaymenttype("Please select the payment");
			afterpayment.setOtp(val);
			LinkedList<AfterPayment> allUsersList = new LinkedList<AfterPayment>();
			allUsersList.add(new AfterPayment(afterpayment.getPaymentstatus(), afterpayment.getPaymenttype(),afterpayment.getOtp()));
			allData.put("product availability", allUsersList);
		}else {
			afterpayment.setPaymenttype("try after some time");	
			afterpayment.setOtp(val);
			LinkedList<AfterPayment> allUsersList = new LinkedList<AfterPayment>();
			allUsersList.add(new AfterPayment(afterpayment.getPaymentstatus(), afterpayment.getPaymenttype(),afterpayment.getOtp()));
			allData.put("product availability", allUsersList);
		}
		return allData;
		
	}
	
	/**3... Post api for changing payment status**/
	@RequestMapping(method = RequestMethod.POST, value = "/addpayment", headers = { "content-type=application/json" })
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody	
	public MessageBean addpayment(@RequestBody PaymentType paymenttypejson) throws Exception {
		System.out.println("3rd API");
		Map<String,LinkedList<AfterPayment>>  allData=new LinkedHashMap<String,LinkedList<AfterPayment>>();
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		int val=restApi.changeStatusOfPaymenttype(con,paymenttypejson);
		if (val == 1) {
			msg.setStatus(202);
			msg.setMessage("Payment status completed successfully");
			return msg;
//			afterpayment.setPaymentstatus("Completed");
//			afterpayment.setPaymenttype(paymenttypejson.getPaymenttype());		
//			LinkedList<AfterPayment> allUsersList = new LinkedList<AfterPayment>();
//			allUsersList.add(new AfterPayment(afterpayment.getPaymentstatus(), afterpayment.getPaymenttype()));
//			allData.put("product availability", allUsersList);
		}else {
			msg.setStatus(500);
			msg.setMessage("Please try after sometime");
			return msg;
//			afterpayment.setPaymenttype("error");	
//			afterpayment.setPaymenttype("error");
//			LinkedList<AfterPayment> allUsersList = new LinkedList<AfterPayment>();
//			allUsersList.add(new AfterPayment(afterpayment.getPaymentstatus(), afterpayment.getPaymenttype()));
//			allData.put("product availability", allUsersList);
		}
		
		
	}
	/** Post Api for adding users **/
	/*
	 * request body required { "username": "value", "password": "value",
	 * "firstname": "value", "lastname": "value", "contact": "value", "address":
	 * "value", "email": "value", "usertype": int val }
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createUsers", headers = { "content-type=application/json" })
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	public MessageBean addTopics(@RequestBody Users usersjson) throws Exception {

		System.out.println("inserting users");
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		int i = restApi.insertUsers(con, usersjson);
		con.close();
		if (i == 1) {
			msg.setStatus(202);
			msg.setMessage("Inserted successfully");
			return msg;
		} else {
			msg.setStatus(500);
			msg.setMessage("Inserted unsuccessfully.Please try it later.");
			return msg;
		}

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/changeUsersType")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public MessageBean updateTopics(@RequestBody Users user) throws Exception {
		System.out.println("updating user");
		if (user.getUsertype() == 1 || user.getUsertype() == 2 || user.getUsertype() == 3) {
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.connectToDB();

			int i = restApi.updateUsers(con, user, user.getEmail());
			System.out.println(i);
			con.close();

			if (i == 1) {
				msg.setStatus(200);
				msg.setMessage("Updated successfully");
				return msg;
			} else if (i <= 0) {
				msg.setStatus(500);
				msg.setMessage("Updated unsuccessfully or Already updated.");
				return msg;
			} else {
				msg.setStatus(200);
				msg.setMessage("Updated successfully");
				return msg;
			}
		} else {
			msg.setStatus(500);
			msg.setMessage("Invalid usertype.");
			return msg;
		}
	}
}
