package com.weblearning.domain.utility.geometry;

import java.util.List;

public class PatchObject {
	
	List<String> coX;
	List<String> coY;
	String patchColor="";
	
	
	public List<String> getCoX() {
		return coX;
	}
	public void setCoX(List<String> coX) {
		this.coX = coX;
	}
	public List<String> getCoY() {
		return coY;
	}
	public void setCoY(List<String> coY) {
		this.coY = coY;
	}
	
	public void setPatchColor(String p) {
		patchColor = p;
	}
	
	public String getPatchColor() {
		return patchColor;
	}
	
	

}
