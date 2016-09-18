package com.weblearning.domain.utility;

/*
 * Holds an fraction as +(5/8)-
 * prefix +
 * fraction- 5/8 (numerator/ denominator)
 * postfix -
 */
public class FractionObject {
	
	private String preFix;
	private int numerator;
	private int denominator;
	private String postFix;
	private String fractionType;
	private boolean missingFraction;
	
	public String getPrefix() {
		return preFix;
	}
	public void setPrefix(String prefix) {
		this.preFix = prefix;
	}


	public String getPostFix() {
		return postFix;
	}
	public void setPostFix(String postFix) {
		this.postFix = postFix;
	}
	
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	public String getFractionType() {
		return fractionType;
	}
	public void setFractionType(String fractionType) {
		this.fractionType = fractionType;
	}
	
	public boolean isMissingFraction() {
		return missingFraction;
	}
	public void setMissingFraction(boolean missingFraction) {
		this.missingFraction = missingFraction;
	}
	

}
