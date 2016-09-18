package com.weblearning.math.grade6.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;


public class Grade6MultiplyFractionTest extends TestCase{
	
	Grade6MultiplyFraction grade6MultiplyFraction;

	List<Integer> listFactor1WithOne = new ArrayList<Integer>();
	List<Integer> listFactor2WithOne = new ArrayList<Integer>(); 
	List<Integer> listFactor3 = new ArrayList<Integer>();
	
	@Before
    public void setUp() throws Exception {
         
        grade6MultiplyFraction = new Grade6MultiplyFraction();
        
        listFactor1WithOne.add(1);
        listFactor1WithOne.add(3);
        listFactor1WithOne.add(2);
        
        listFactor2WithOne.add(1);
        listFactor2WithOne.add(5);
        
        listFactor3.add(3);
        listFactor3.add(4);
        
    }
	
	public void testContainsFactor(){
		boolean result1 = grade6MultiplyFraction.containsFactor(listFactor1WithOne, listFactor2WithOne);
		boolean result2 = grade6MultiplyFraction.containsFactor(listFactor1WithOne, listFactor3);
		
		assertEquals(false, result1);
		assertEquals(true, result2);
	}

}
