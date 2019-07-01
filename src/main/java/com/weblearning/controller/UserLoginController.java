package com.weblearning.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weblearning.domain.MessageReturned;
import com.weblearning.domain.Student;
import com.weblearning.domain.Tutor;
import com.weblearning.security.model.LoggedUser;
import com.weblearning.security.model.User;
import com.weblearning.security.service.LoginService;


@RestController
public class UserLoginController {
	
	private static final Logger logger = Logger.getLogger(UserLoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value="/loginview")
	public LoggedUser getLoginPage(@RequestBody User user ){
		
		//MessageReturned msgRtn;
		LoggedUser loggedUser = new LoggedUser();
		
		//boolean login = loginService.isValidUser(user.getUsername(), user.getPassword());
		loggedUser = loginService.isValidUser(user.getUsername(), user.getPassword());
		
		

		return loggedUser;
	}
	
	/*@PostMapping(value="/insertUser")
	public MessageReturned insertUser(@RequestBody User usr ){
		
		MessageReturned msgRtn;
		
		User user = new User();
		user.setPassword(usr.getPassword());
		user.setUsername(usr.getUsername());
		
		msgRtn = loginService.insertUser(user);
		
		//RestTemplate restTemplate = new RestTemplate();
		
		//String fooResourceUrl
		//   = "https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyCsvWlEp2m3zPIRJGaI-nKhpicXsegy72w";
																								
		//ResponseEntity<String> response   = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);

		return msgRtn;
	}*/
	
	@PostMapping(value="/insertUser")
	public MessageReturned insertUser(@RequestBody User usr ){
		
		MessageReturned msgRtn= new MessageReturned();
		String role = usr.getUserRole();
		
		if (role.equals("Tutor")) {
			Tutor tutor = new Tutor();
			tutor.setPassword(usr.getPassword());
			tutor.setUsername(usr.getUsername());
			tutor.setPostalCode(usr.getPostalCode());
			tutor.setGradeTutor(usr.getGradeTutor());
			
			msgRtn = loginService.insertTutor(tutor);
		}
		else if(role.equals("Student")) {
			
			Student student = new Student();
			student.setPassword(usr.getPassword());
			student.setUsername(usr.getUsername());
			student.setPostalCode(usr.getPostalCode());
			student.setGradeTutor(usr.getGradeTutor());
			
			msgRtn = loginService.insertStudent(student);
		}

		return msgRtn;
	}
	
	@PostMapping(value="/updateUser")
	public MessageReturned updateUser (@RequestBody User usr) {
		
		MessageReturned msgRtn= new MessageReturned();
		
		if (usr.getUserRole().equals("Tutor")) {
			
			Tutor tutor = new Tutor();
			tutor.setPassword(usr.getPassword());
			tutor.setUsername(usr.getUsername());
			tutor.setPostalCode(usr.getPostalCode());
			tutor.setGradeTutor(usr.getGradeTutor());
			
			msgRtn = loginService.updateTutor(tutor);
			
		}else if (usr.getUserRole().equals("Student")) {
			Student student = new Student();
			student.setPassword(usr.getPassword());
			student.setUsername(usr.getUsername());
			student.setPostalCode(usr.getPostalCode());
			student.setGradeTutor(usr.getGradeTutor());
			
			msgRtn = loginService.updateStudent(student);
		}
		
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
