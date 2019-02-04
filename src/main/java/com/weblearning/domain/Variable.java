package com.weblearning.domain;

import java.util.List;

public class Variable {
	
	int lowerLimit;
	int upperLimit;
	String variableName;
	String variableType;
	int variableValue;
	List<?>valueList;
	
	public int getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public int getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
	public String getVariableName() {
		return this.variableName;
	}
	public void setVariableName(String name) {
		this.variableName= name;
	}
	public String getVariableType() {
		return this.variableType;
	}
	public void setVariableType(String vType) {
		this.variableType = vType;
	}
	public void setVariableValue(int vValue) {
		this.variableValue = vValue;
	}
	
	public int getVariableValue() {
		return this.variableValue;
	}
	public List<?> getValueList() {
		return valueList;
	}
	public void setValueList(List<?> valueList) {
		this.valueList = valueList;
	}

}
