package com.weblearning.math.grade;

import java.util.List;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;

public abstract class GeometryQuestion implements Question{
	
	MathConfiguration mathConfig;
	
	public abstract List<Problem> getGeometryQuestions(MathConfiguration mathConfig); 
	
	public void setMathConfiguration(MathConfiguration mConfig){
		mathConfig = mConfig;
	}
	
	public List<?> getQuestions(MathConfiguration mathConfig){
		return null;
	}

}
