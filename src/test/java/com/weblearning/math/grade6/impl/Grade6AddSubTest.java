package com.weblearning.math.grade6.impl;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


public class Grade6AddSubTest extends TestCase {
	
	int []numbers;
	Grade6AddSub grade6AddSub;
	
	@Before
    public void setUp() throws Exception {
         
        this.numbers = new int[]{1000, 5000, 2000};
        grade6AddSub = new Grade6AddSub();
        
    }
	
	@Test
    public void testRule1() {
		
		int result = grade6AddSub.rule1(numbers);
			
        assertEquals(result, 4000);
    }


}
