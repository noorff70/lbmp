package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.NumberObject;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.RootObject;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;
import com.weblearning.math.grade8.impl.G8ExpOperationAdv;

import junit.framework.TestCase;

public class G8ExpOperationAdvTest extends TestCase {

	@Before
	public void setUp() throws Exception {

	}

	//test the equation- 6*2^2 + 12* sqrt(2)^3
	@Test
	public void testGetProblem1() {
		// ex- (sqrt(2)*3)- convert 4*sqrt(2)- whole-4, root-2
		int A1power = 3;
		int A1base = 2;
		RootObject A11R = G8ExpOperationAdv.convertSquareRoottoRootObject(A1base, A1power, 2);

		int A12 = 12;
		RootObject A12R = new RootObject();
		A12R.setRoot(1);
		A12R.setWhole(A12);

		// now need to multiply the operation by passing on 2 root objects.
		RootObject r1 = new RootObject();

		ArrayList<RootObject> a1 = new ArrayList<RootObject>();
		a1.add(A11R);
		a1.add(A12R);

		r1 = MathUtilities.multiplyRoots(a1); //expected 24 root2
		
		//test multiplications
		assertEquals(2, r1.getRoot());
		assertEquals(24, r1.getWhole());

		// multiply a number with anothernumber to the power something to get a whole
		int A2power = 2;
		int A21 = 6;
		int A22 = A21 * (int) Math.pow(2, A2power);

		
		//test the formation of number
		assertEquals(24, A22);
		
		RootObject r2 = new RootObject();
		r2.setWhole(A22);
		r2.setRoot(1);

		List<RootObject> numeratorList = new ArrayList<RootObject>();
		numeratorList.add(r1);
		numeratorList.add(r2);

		List<RootObject> denominatorList = new ArrayList<RootObject>();
		RootObject rObject = new RootObject();
		rObject.setRoot(1);
		rObject.setWhole(1);
		denominatorList.add(rObject);

		// format the number object
		NumberObject numeratorN = MathUtilities.createNumberObject(numeratorList);
		
		//test common factor
		assertEquals(24, (int)numeratorN.getCommonFactor());
		
		List<NumberObject> nObjectList = new ArrayList<NumberObject>();
		nObjectList.add(numeratorN);
		NumberObject denominatorN = MathUtilities.createNumberObject(denominatorList);
		nObjectList.add(denominatorN);

		String ans = MathUtilities.formatNumberObject(nObjectList);

		//result is 24(1 + sqrt(2))
		assertEquals("$24(1+\\sqrt{2}))$", ans);
	}
	
	@Test
	public void testGetProblem3() {

		//A. construct 3(root2)^3 
		//A.1 construct (root2)^3
		int A1power = 3;//MathUtilities.getRandomNumber(1,6);
		int A1base = 2;
		//String A11 = "$\\sqrt"+A1base+ "^"+ "{" +A1power+ "}";
		RootObject A11R = G8ExpOperationAdv.convertSquareRoottoRootObject(A1base, A1power, 2);

		//A.2 Construct 3
		int A12 = -3;
		if (A12 ==0) A12= 3;
		
		//convert 3(root2)^3  to a RootObject. First make that a square- square(3*root2^3)= square(6root2)= 72  and then make rootobject 
		int n1 = (int)Math.pow(A11R.getWhole()*A12, 2)*A11R.getRoot();
		
		Fraction frac1 = Fraction.getReducedFraction(n1,1);
		RootObject fracNumeratorRootA1 = MathUtilities.getRoot(frac1.getNumerator(), A1base);
		RootObject fracDenominatorRootA2 = MathUtilities.getRoot(frac1.getDenominator(), A1base);
		List<RootObject> firstRootList = new ArrayList<RootObject>();
		firstRootList.add(fracNumeratorRootA1);
		firstRootList.add(fracDenominatorRootA2);
					
		//construct second one
		int B1power = 3;//MathUtilities.getRandomNumber(1,3);
		int B1base = 5;// MathUtilities.getRandomNumber(2,5);

		RootObject B11R = G8ExpOperationAdv.convertSquareRoottoRootObject(B1base, B1power, 2);
		
		int B12 = 2; //MathUtilities.getRandomNumber(1, 3);
		
		//convert 3(root2)^3  to a RootObject. First make that a square- square(3*root2^3)= square(6root2)= 72  and then make rootobject 
		int n2= (int)Math.pow(B11R.getWhole()*B12, 2)*B11R.getRoot();
		Fraction bfrac1 = Fraction.getReducedFraction(n2, 1);
		RootObject fracNumeratorRootB1 = MathUtilities.getRoot(bfrac1.getNumerator(), 2);
		RootObject fracDenominatorRootB2 = MathUtilities.getRoot(bfrac1.getDenominator(), 2);
		List<RootObject> secondRootList = new ArrayList<RootObject>();
		secondRootList.add(fracNumeratorRootB1);
		secondRootList.add(fracDenominatorRootB2);
			
		//Construct third one
		int C1power = 3;//MathUtilities.getRandomNumber(1,6);
		int C1base = 2;
		RootObject C11R = G8ExpOperationAdv.convertSquareRoottoRootObject(C1base, C1power, 2);

		//A.2 Construct 3
		int C12 = 2;// MathUtilities.getRandomNumber(1, 3);
		
		//convert 3(root2)^3  to a RootObject. First make that a square- square(3*root2^3)= square(6root2)= 72  and then make rootobject
		int n3 = (int)Math.pow(C11R.getWhole()*C12, 2)*C11R.getRoot();
		Fraction cfrac1 = Fraction.getReducedFraction(n3, 1);
		RootObject fracNumeratorRootC1 = MathUtilities.getRoot(cfrac1.getNumerator(), A1base);
		RootObject fracDenominatorRootC2 = MathUtilities.getRoot(cfrac1.getDenominator(), C1base);
		List<RootObject> thirdRootList = new ArrayList<RootObject>();
		thirdRootList.add(fracNumeratorRootC1);
		thirdRootList.add(fracDenominatorRootC2);

		
		List<RootObject> listOfRootObjects = new ArrayList<RootObject>();
		listOfRootObjects.add(fracNumeratorRootA1);
		listOfRootObjects.add(fracNumeratorRootB1);
		listOfRootObjects.add(fracNumeratorRootC1);
		
		
		List<RootObject> denominatorRootObjectList = new ArrayList<RootObject>();
		RootObject denominatorRoot = new RootObject();
		denominatorRoot.setRoot(1);
		denominatorRoot.setWhole(1);
		denominatorRootObjectList.add(denominatorRoot);
		

		//put the firstone as numerator and the second one as denominator in the map as key 1 and 2 respectively
		Map<Integer, List<RootObject>> rootListMap = new LinkedHashMap<Integer, List<RootObject>>();
		rootListMap.put(1, firstRootList);
		rootListMap.put(2, secondRootList);
		rootListMap.put(3, thirdRootList);
		
			
		//get the map as numberobject
		NumberObject numeratorObject = MathUtilities.performRootOperation(rootListMap).get(0);
		NumberObject denominatorObject = MathUtilities.performRootOperation(rootListMap).get(1);
		
		List<NumberObject> numberObjectList = new ArrayList<NumberObject>();
		numberObjectList.add(numeratorObject);
		numberObjectList.add(denominatorObject);
		
		String actualResult = MathUtilities.formatNumberObject(numberObjectList);
		//String expectedResult = "$10(\sqrt{2}+\sqrt{5}))$";
		assertEquals("$10(\\sqrt{2}+\\sqrt{5}))$", actualResult);


		System.out.println("");
		
	}
	
	

}
