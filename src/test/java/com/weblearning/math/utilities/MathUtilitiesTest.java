package com.weblearning.math.utilities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;


import com.weblearning.domain.utility.FractionObject;
import com.weblearning.utilities.Constants;



public class MathUtilitiesTest {
	

	List<FractionObject> fractionList = new ArrayList<FractionObject>();
	MathUtilitiesTest utilities;
	
	@Before
    public void setUp() throws Exception {
 			
		FractionObject fo1 = new FractionObject();
		fo1.setNumerator(5);
		fo1.setDenominator(8);
		fo1.setPrefix("+");
		fo1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
		
			
		FractionObject fo2 = new FractionObject();	
		fo2.setNumerator(6);
		fo2.setDenominator(10);
		fo2.setPrefix("+");
		fo2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
		
		fractionList.add(fo1);
		fractionList.add(fo2);
        
    }
	
	@Test
    public void testGetResultAsFraction() {
		
		Fraction f1 = new Fraction(49, 40);
		Fraction f2 = MathUtilities.getResultAsFraction(fractionList);
			
        assertEquals(f1, f2);
    }
	
	@Test
	public void testGetResultAsStringFraction(){
		
		String s2 = MathUtilities.getQuestionAsStringFraction(fractionList);
		
		//The UI will be presented as '$\frac{5}{8}$ + $\frac{6}{10}$' for MathJax Script
		
		assertEquals("$\\frac{5}{8}$ + $\\frac{6}{10}$", s2);
		
	}
	
	@Test
	public void testGetHCF(){
		
		List<Integer> primeList = new ArrayList<Integer>();
		
		//All prime numbers
		List<Integer> testList1 = new ArrayList<Integer>();
		testList1.add(2);
		testList1.add(3);
		testList1.add(7);
		
		//Not prime numbers
		List<Integer> testList2 = new ArrayList<Integer>();
		testList2.add(4);
		testList2.add(6);
		testList2.add(8);
		
		List<?> hcfList1 = new ArrayList();
		hcfList1 = MathUtilities.getHCF(testList1, primeList);
		
		List<?> hcfList2 = new ArrayList();
		//hcfList2 = MathUtilities.getHCF(testList2, primeList);
		
		//assertTrue(StringUtils.isEmpty(hcfList1));
		//assertEquals(2, hcfList2.get(0));
		
	}

}
