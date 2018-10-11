package com.weblearning.math.grade;

import java.util.List;

import com.weblearning.domain.MathConfiguration;
//import com.weblearning.domain.Problem;

public interface Question {
	
	// public List<Problem> getGeometryQuestions(MathConfiguration mathConfig); 
	
	public List<?> getQuestions(MathConfiguration mathConfig); 
	
	public void setMathConfiguration(MathConfiguration mConfig);


}
