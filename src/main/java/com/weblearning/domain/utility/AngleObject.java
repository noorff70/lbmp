package com.weblearning.domain.utility;

public class AngleObject {
	
	//name of the angle
	String nameOfAngle;
	//angle value in float
	Float degreeValue;
	//how the the line goes to left from center point 
	CoordinateObject leftC ;
	//how far the line goes to right from center point
	CoordinateObject rightC;
	//coordinate point of the angle
	CoordinateObject centerC;
	
	
	public String getNameOfAngle() {
		return nameOfAngle;
	}
	
	public void setNameOfAngle(String nameOfAngle) {
		this.nameOfAngle = nameOfAngle;
	}
	
	
	public float getDegreeValue() {
		return degreeValue;
	}
	
	public void setDegreeValue(float degree) {
		degreeValue = degree;
	}

	public CoordinateObject getLeftC() {
		return leftC;
	}

	public void setLeftC(CoordinateObject leftC) {
		this.leftC = leftC;
	}

	public CoordinateObject getRightC() {
		return rightC;
	}

	public void setRightC(CoordinateObject rightC) {
		this.rightC = rightC;
	}

	public CoordinateObject getCenterC() {
		return centerC;
	}

	public void setCenterC(CoordinateObject centerC) {
		this.centerC = centerC;
	}
	
	

}
