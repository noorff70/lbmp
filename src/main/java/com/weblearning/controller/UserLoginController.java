package com.weblearning.controller;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weblearning.security.model.User;
import com.weblearning.security.service.LoginService;
import com.weblearning.utilities.LBMPExeption;


@Controller
public class UserLoginController {
	
	private static final Logger logger = Logger.getLogger(UserLoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="loginview", method=RequestMethod.GET)
	public String getLoginPage(@ModelAttribute(value = "user") User user, BindingResult result,HttpServletRequest request){
		
	
		return "loginview";
	}
	

	/* Receives user name and password from jsp page "loginview" through post method
	 * 
	 */
	@ExceptionHandler({LBMPExeption.class})
	@RequestMapping(value="loginview", method=RequestMethod.POST)
	public String getUserCredential(@Valid @ModelAttribute("logininfo") User user,BindingResult result, HttpServletRequest request){
			
		//Validates input from the UI
		if (result.hasErrors()) {
			logger.error("Error at UserLoginController", new Exception("Testing"));
            return "loginview";
        }
		
		
		boolean validUser = loginService.isValidUser(user.getUsername(), user.getPassword());
		
		
		if (validUser)
			return "index";
		else
			return "loginview";
	}

}
