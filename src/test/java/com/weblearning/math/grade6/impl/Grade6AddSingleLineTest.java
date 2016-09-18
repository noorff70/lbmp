package com.weblearning.math.grade6.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Grade6AddSingleLineTest {

	int []numbers;
	Grade6AddSingleLine grade6AddSingleLine;
	
	@Before
    public void setUp() throws Exception {
         
        this.numbers = new int[]{1000, 5000, 2000};
        grade6AddSingleLine = new Grade6AddSingleLine();
        
    }
	
	@Test
    public void testRule1() {
		
		int result = grade6AddSingleLine.rule1Ans(numbers);
			
        assertEquals(result, 8000);
    }

}
