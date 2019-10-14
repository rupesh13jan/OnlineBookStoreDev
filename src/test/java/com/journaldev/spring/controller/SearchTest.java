package com.journaldev.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaldev.spring.dbconnection.DBConnection;
import com.journaldev.spring.model.BookModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import  org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
public class SearchTest {

	@InjectMocks
	RestApiController restApiController;
	@Mock
	RestStatementAPI restApi;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(restApiController)
				.build();
	}
	
	@Test
	public void testsearchBooks() throws Exception {

		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.connectToDB();
		restApiController.searchBooks("e");
		Mockito.when(restApiController.searchBooks("e"));

		
	}

}
