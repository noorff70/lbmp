package com.weblearning.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.weblearning.security.service.LoginService;

/*
 * Running with Test Runner
 * classpath configuration for root-context.xml for configuration
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:root-context.xml" })
public class UserLoginControllerTest {

	@Autowired
	LoginService loginService;

	@InjectMocks
	UserLoginController userLoginController;

	private MockMvc mockMVC;

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		this.mockMVC = MockMvcBuilders.standaloneSetup(userLoginController).build();

	}

	@Test
	public void testGetUserCredential() throws Exception {

		assertTrue(loginService.isValidUser("guest", "123"));
		assertFalse(loginService.isValidUser("guest", "456"));

	}

}
