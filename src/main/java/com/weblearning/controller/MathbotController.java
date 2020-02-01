package com.weblearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.weblearning.domain.MathbotQuestion;
import com.weblearning.service.RestMathClientService;

@Controller
public class MathbotController {

	@Autowired
	private RestMathClientService restMathClient;

	@PostMapping( value="/mathAssistant", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> getMathbot(@RequestBody MathbotQuestion test) {

		String ans =  restMathClient.returnMathbot(test.getQuestion());
		
		return ResponseEntity.ok(ans);
	}

}
