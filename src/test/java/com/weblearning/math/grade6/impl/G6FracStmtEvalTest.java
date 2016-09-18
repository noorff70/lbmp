package com.weblearning.math.grade6.impl;

import junit.framework.TestCase;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;


public class G6FracStmtEvalTest extends TestCase{
	
	G6FracStmtEval g6FracStmtEval;

	Fraction f1, f2, f3, f4, f5, f6;
	
	@Before
    public void setUp() throws Exception {
         
        g6FracStmtEval = new G6FracStmtEval();
        
        f1 = new Fraction (1, 3);
        f2 = new Fraction (3, 1);
        
        f3 = new Fraction (100, 10);
        f4 = new Fraction (20, 100);
 
        f5 = new Fraction (1, 3);
        f6 = new Fraction (1, 3);
        
    }
	
	public void testContainsFactor(){
		
		String result1 = g6FracStmtEval.getResult(f1, f2);
		String result2 = g6FracStmtEval.getResult(f3, f4);
		String result3 = g6FracStmtEval.getResult(f5, f6);
		
		assertEquals("B", result1);
		assertEquals("A", result2);
		assertEquals("C", result3);
	}

}
