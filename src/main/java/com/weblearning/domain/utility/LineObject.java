package com.weblearning.domain.utility;

import java.util.List;

public class LineObject {
	
	List <CoordinateObject> coordinateList;
	CoordinateObject coordinateObject;
	String distance;
	
	public List <CoordinateObject> getCoordinateList(){
		return coordinateList;
	}
	
	public void setCoordinateList(List <CoordinateObject> cO){
		coordinateList = cO;
		
	}
	
	public String getDistance(){
		return distance;
	}
	
	public void setDistance(String dtc){
		distance = dtc;
	}
	
	public CoordinateObject getCoordinateObject(){
		return coordinateObject;
	}
	
	public void setCoordinateObject(CoordinateObject c){
		coordinateObject = c;
	}

}
