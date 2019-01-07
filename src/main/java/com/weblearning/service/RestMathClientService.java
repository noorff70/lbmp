package com.weblearning.service;

import java.util.List;

import com.weblearning.domain.Problem;

public interface RestMathClientService {

	public List<Problem> returnAnswerList(List<Problem> answerList);
	public List<Problem> returnExpression(List<Problem> answerList);
}
