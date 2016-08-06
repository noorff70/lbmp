package com.weblearning.service;

import java.util.List;

import com.weblearning.domain.Problem;

public interface MathClassLoaderService {
	
	public List<Problem> getProblemList(String className);

}
