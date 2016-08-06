package com.weblearning.math.grade;

import java.util.List;

import com.weblearning.domain.MathConfiguration;

public abstract class Question {
	
	MathConfiguration mathConfig;
	
	//public abstract List<?> getQuestions(); 
	public abstract List<?> getQuestions(MathConfiguration mathConfig); 
	
	public void setMathConfiguration(MathConfiguration mConfig){
		mathConfig = mConfig;
	}

}
