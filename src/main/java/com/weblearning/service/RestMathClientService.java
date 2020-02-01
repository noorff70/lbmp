package com.weblearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weblearning.domain.Problem;

@Service
public interface RestMathClientService {

	public List<Problem> returnAnswerList(List<Problem> answerList);
	public List<Problem> returnExpression(List<Problem> answerList);
	public List<Problem> returnGraph(List<Problem> answerList);
	public String returnMathbot(String question);
}
