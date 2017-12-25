package com.weblearning.domain;
import java.util.Map;

/*
 * A number object can be represented as 3(1+ 2root(3) + 4root(2))
 * commonfactor=3, 
 * rootobject 1- root-3, whole-2
 * rootobject 2- root-2, whole-4
 */
public class NumberObject {
	
	
	Map <Integer, Integer> rootObject;
	Integer commonFactor;
	
	public Map<Integer, Integer> getRootObject() {
		return rootObject;
	}
	public void setRootObject(Map<Integer, Integer> rootObject) {
		this.rootObject = rootObject;
	}
	public Integer getCommonFactor() {
		return commonFactor;
	}
	public void setCommonFactor(Integer commonFactor) {
		this.commonFactor = commonFactor;
	}

}
