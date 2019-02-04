package com.weblearning.domain;

import java.util.List;

public class GraphObject {
	
	String title;
	List<String> rowVals;
	List<String> colVals;
	String graphType;
	String Xlabel;
	String Ylabel;
	//List<String> colValues;
	List<Variable> variableList;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String t) {
		this.title = t;
	}
	public String getGraphType() {
		return this.graphType;
	}
	public void setGraphType(String gt) {
		this.graphType = gt;
	}

//	public List<String> getColValues() {
//		return colValues;
//	}
//	public void setColValues(List<String> colValues) {
//		this.colValues = colValues;
//	}
	public List<String> getRowVals() {
		return rowVals;
	}
	public void setRowVals(List<String> row) {
		rowVals = row;
	}
	public List<String> getColVals() {
		return colVals;
	}
	public void setColVals(List<String> col) {
		colVals = col;
	}
	public String getXlabel() {
		return Xlabel;
	}
	public void setXlabel(String xlabel) {
		Xlabel = xlabel;
	}
	public String getYlabel() {
		return Ylabel;
	}
	public void setYlabel(String ylabel) {
		Ylabel = ylabel;
	}
	public List<?> getVariableList() {
		return variableList;
	}
	public void setVariableList(List<Variable> vList) {
		this.variableList = vList;
	}
	
}
