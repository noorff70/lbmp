package com.weblearning.math.grade;

import java.util.List;

import com.weblearning.domain.MathConfiguration;
//import com.weblearning.domain.Problem;

public abstract class GenericQuestion implements Question{
	
	MathConfiguration mathConfig;
	
	//public abstract List<?> getQuestions(); 
	public abstract List<?> getQuestions(MathConfiguration mathConfig); 
	
	public void setMathConfiguration(MathConfiguration mConfig){
		mathConfig = mConfig;
	}
	
	//public List<Problem> getGeometryQuestions(MathConfiguration mathConfig){
	//	return null;
	//}

}
