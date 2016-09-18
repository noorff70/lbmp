package com.weblearning.math.utilities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;

import com.weblearning.domain.utility.FractionObject;

public class MathUtilitiesTest {

	List<FractionObject> fractionList = new ArrayList<FractionObject>();
	MathUtilitiesTest utilities;
	
	@Before
    public void setUp() throws Exception {
 			
		FractionObject fo1 = new FractionObject();
		fo1.setNumerator(5);
		fo1.setDenominator(8);
		fo1.setPrefix("+");
		
			
		FractionObject fo2 = new FractionObject();	
		fo2.setNumerator(6);
		fo2.setDenominator(10);
		fo2.setPrefix("+");
		
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
		
		String s1 = "5/8 + 6/10";
		String s2 = MathUtilities.getQuestionAsStringFraction(fractionList);
		
		assertEquals(s1, s2);
		
	}

}
