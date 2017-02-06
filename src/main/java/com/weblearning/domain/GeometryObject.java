package com.weblearning.domain;

import java.util.List;

import com.weblearning.domain.utility.LineObject;
import com.weblearning.domain.utility.PolygonObject;
import com.weblearning.domain.utility.geometry.Triangle;

public class GeometryObject {
	
	List <LineObject> lineObject;
	PolygonObject polygonObject;
	Triangle triangle;
	
	public void setLineObject(List<LineObject> lo){
		lineObject = lo;
	}
	
	public List <LineObject> getLineObject (){
		return lineObject;
	}
	
	public void setPolygonObject(PolygonObject poly){
		polygonObject= poly;
	}
	
	public PolygonObject getPolygonObject(){
		return polygonObject;
	}
	
	public void setTriangle(Triangle tr){
		triangle = tr;
	}
	
	public Triangle getTriangle(){
		return triangle;
	}

}
