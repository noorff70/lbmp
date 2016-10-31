package com.weblearning.domain;

import java.util.List;
import java.util.Map;

import org.springframework.context.MessageSource;

public class MathConfiguration {

	Map<Integer, List<Integer>> factors;
	Map<Integer, List<Integer>> primeFactors;
	MessageSource mSource;
	
	public void setFactors(Map<Integer, List<Integer>> factor){
		factors = factor;
	}
	
	public Map<Integer, List<Integer>> getFactors(){
		return factors;
	}
	
	public void setPrimeFactors(Map<Integer, List<Integer>> pFactor){
		primeFactors = pFactor;
	}
	
	public Map<Integer, List<Integer>> getPrimeFactors(){
		return primeFactors;
	}

	public MessageSource getmSource() {
		return mSource;
	}

	public void setmSource(MessageSource mSource) {
		this.mSource = mSource;
	}
}
