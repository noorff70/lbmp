package com.weblearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.weblearning.domain.MathbotQuestion;
import com.weblearning.domain.Problem;
import com.weblearning.service.RestMathClientService;

@Service("restMathClient")
public class RestMathClientServiceImpl implements RestMathClientService{

	private static final Logger logger = Logger.getLogger(RestMathClientServiceImpl.class);
	
	@Override
	public List<Problem> returnAnswerList(List<Problem> answerList) {
		List<Problem> problemList = new ArrayList<Problem>();
		
		String uri = "http://localhost:5000/answers";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> entity = new HttpEntity<Object>(answerList, headers);
		String answer = restTemplate.postForObject(uri, entity, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			problemList = mapper.readValue(answer, mapper.getTypeFactory().constructCollectionType(List.class, Problem.class));
		}catch(Exception e) {
			logger.error("From RestMathClientServiceImpl:  "+ e);
		}
		
		return problemList;

	}
	
	@Override
	public List<Problem> returnExpression(List<Problem> answerList) {
		List<Problem> problemList = new ArrayList<Problem>();
		
		String uri = "http://localhost:5000/getExpressions";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> entity = new HttpEntity<Object>(answerList, headers);
		String answer = restTemplate.postForObject(uri, entity, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			problemList = mapper.readValue(answer, mapper.getTypeFactory().constructCollectionType(List.class, Problem.class));
		}catch(Exception e) {
			logger.error("From RestMathClientServiceImpl:  "+ e);
		}
		
		return problemList;

	}
	
	public List<Problem> returnGraph(List<Problem> answerList){
		
		List<Problem> problemList = new ArrayList<Problem>();
		
		String uri = "http://localhost:5000/getGraph";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> entity = new HttpEntity<Object>(answerList, headers);
		String answer = restTemplate.postForObject(uri, entity, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			problemList = mapper.readValue(answer, mapper.getTypeFactory().constructCollectionType(List.class, Problem.class));
		}catch(Exception e) {
			logger.error("From RestMathClientServiceImpl:  "+ e);
		}
		
		return problemList;
		
	}
	
	public String returnMathbot(String question){
		
		String problemAnswer= null;
		
		String uri = "http://localhost:5000/getMathAssistant";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
			

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> entity = new HttpEntity<Object>(question, headers);
		String answer = restTemplate.postForObject(uri, entity, String.class);
	//	System.out.println(answer);
		
	//	ObjectMapper mapper = new ObjectMapper();
	//	try {
	//		problemAnswer = mapper.readValue(answer, mapper.getTypeFactory().constructCollectionType(List.class, MathbotQuestion.class));
	//	}catch(Exception e) {
	//		logger.error("From RestMathClientServiceImpl:  "+ e);
	//	}
		
	//	return problemAnswer;
		return answer;
		
	}
 
}
