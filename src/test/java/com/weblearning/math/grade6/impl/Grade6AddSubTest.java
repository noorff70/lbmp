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
		
		//test rule 1
		String result1[] = grade6AddSub.rule(numbers, 1);
		String result2[] = grade6AddSub.rule(numbers, 2);
		String result3[] = grade6AddSub.rule(numbers, 3);
		String result4[] = grade6AddSub.rule(numbers, 4);
			
        assertEquals(Integer.parseInt(result1[1]), 4000);
        assertEquals(Integer.parseInt(result2[1]), -2000);
        assertEquals(Integer.parseInt(result3[1]), -4000);
        assertEquals(Integer.parseInt(result4[1]), 2000);
    }


}
