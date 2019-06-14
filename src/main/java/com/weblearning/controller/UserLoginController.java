package com.weblearning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weblearning.domain.MessageReturned;
import com.weblearning.security.model.User;
import com.weblearning.security.service.LoginService;
import com.weblearning.utilities.LBMPExeption;


@RestController
public class UserLoginController {
	
	private static final Logger logger = Logger.getLogger(UserLoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value="/loginview")
	public MessageReturned getLoginPage(@RequestBody User user ){
		
		MessageReturned msgRtn;
		
		//boolean login = loginService.isValidUser(user.getUsername(), user.getPassword());
		msgRtn = loginService.isValidUser(user.getUsername(), user.getPassword());

		return msgRtn;
	}
	
	@PostMapping(value="/insertUser")
	public MessageReturned insertUser(@RequestBody User usr ){
		
		MessageReturned msgRtn;
		
		User user = new User();
		user.setPassword(usr.getPassword());
		user.setUsername(usr.getUsername());
		
		//boolean login = loginService.insertUser(user);
		msgRtn = loginService.insertUser(user);

		return msgRtn;
	}
	

	/* Receives user name and password from jsp page "loginview" through post method
	 * 
	 */
	/*@ExceptionHandler({LBMPExeption.class})
	@RequestMapping(value="userregister", method=RequestMethod.POST)
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
	}*/

}
