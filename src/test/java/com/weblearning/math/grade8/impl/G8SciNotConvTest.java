package com.weblearning.math.grade8.impl;

import org.junit.Before;
import org.junit.Test;

import com.weblearning.math.grade8.impl.G8SciNotConv;

import junit.framework.TestCase;

public class G8SciNotConvTest extends TestCase {
	
	G8SciNotConv g8;

	@Before
	public void setUp() throws Exception {

	}

	//test negative numbers with roundings
	@Test
	public void testGetProblem2_1() {

		double df = .0000730285;
		g8 = new G8SciNotConv();
		
		String numberFormat = g8.moveDecimalRight(df);
		int pointToMove = g8.decimalMovedToRight(df);
		
		String answer = numberFormat + "x" + "${" +10+ "}^{" + pointToMove + "}$" ;

		assertEquals("7.30285x${10}^{-5}$", answer);
	}
	
	//test negative numbers with roundings
	@Test
	public void testGetProblem2_2() {

		double df = .0000730288;
		g8 = new G8SciNotConv();
			
		String numberFormat = g8.moveDecimalRight(df);
		int pointToMove = g8.decimalMovedToRight(df);
			
		String answer = numberFormat + "x" + "${" +10+ "}^{" + pointToMove + "}$" ;

		assertEquals("7.30288x${10}^{-5}$", answer);
	}
		
		//test negative numbers with roundings
	@Test
	public void testGetProblem2_3() {

		double df = .0000730284;
		g8 = new G8SciNotConv();
					
		String numberFormat = g8.moveDecimalRight(df);
		int pointToMove = g8.decimalMovedToRight(df);
					
		String answer = numberFormat + "x" + "${" +10+ "}^{" + pointToMove + "}$" ;

		assertEquals("7.30284x${10}^{-5}$", answer);
	}
	
	//test negative numbers with roundings
	@Test
	public void testGetProblem2_4() {

		double df = .071;
		g8 = new G8SciNotConv();
		
		String numberFormat = g8.moveDecimalRight(df);
		int pointToMove = g8.decimalMovedToRight(df);
		
		String answer = numberFormat + "x" + "${" +10+ "}^{" + pointToMove + "}$" ;

		assertEquals("7.1x${10}^{-2}$", answer);
	}
	

}
