package com.weblearning.domain;

import java.util.List;

import com.weblearning.domain.utility.LineObject;
import com.weblearning.domain.utility.PolygonObject;
import com.weblearning.domain.utility.geometry.Triangle;

public class GeometryObject {
	
	List <LineObject> lineObject;
	PolygonObject polygonObject;
	Triangle triangle;
	String question;
	String answer;
	String slNo;
	String pathToPicture;
	
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
	
	public void setQuestion(String q) {
		this.question = q;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public void setAnswer(String a) {
		this.answer = a;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public String getSlNo( ) {
		return this.slNo;
	}
	
	public void setSlNo(String sl) {
		this.slNo = sl;
	}
	
	public String getPathToPicture() {
		return this.pathToPicture;
	}
	
	public void setPathToPicture(String path) {
		this.pathToPicture = path;
	}

}
