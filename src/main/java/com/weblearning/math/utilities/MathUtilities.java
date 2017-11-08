package com.weblearning.math.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;

import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.RootObject;
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.UniqueObjectMap;
import com.weblearning.utilities.Constants;

/* Utility class
 * 
 */

public class MathUtilities {
	
	private static Logger logger = Logger.getLogger(MathUtilities.class);
	
	/*Returns a random number within a rangs
	 * 
	 */
	public static int getRandomNumber(int min, int max){
		
		logger.debug("Max: "+ max + " " + "Min: " + min);

		Random r = new Random();
		int randomNumber =0;
		
		if (max > min){
			
			randomNumber = r.nextInt(max - min + 1) + min;
		}
		else{
			randomNumber = r.nextInt(min - max + 1) + max;
		}
		
		return randomNumber;
	}
	
	
	/*
	 * Returns a list of random numbers
	 */
	public static int[] getRandomNumbers(int maxLine, int min, int max){
	
	int numbers[] = new int[maxLine];
	
	for (int i=0; i<maxLine; i++){
		//Get the number of Digits in the number, so that the max is a million and the min is thousand
		
		numbers[i]= MathUtilities.getRandomNumber(min, max);
	}
	
	return numbers;
	}
	
	
	/*
	 *  Convert the numbers to Word Format
	 */
	
	public static String getNumberConvertedToWord(int[] numbers){
		
		String wordFormat ="";
		String innerString="";
		
		Map<Integer, String> wordMap = new HashMap<Integer, String>();
		wordMap.put(1, "One");
		wordMap.put(2, "Two");
		wordMap.put(3, "Three");
		wordMap.put(4, "Four");
		wordMap.put(5, "Five");
		wordMap.put(6, "Six");
		wordMap.put(7, "Seven");
		wordMap.put(8, "Eight");
		wordMap.put(9, "Nine");
		wordMap.put(10, "Ten");
		wordMap.put(11, "Eleven");
		wordMap.put(12, "Twelve");
		wordMap.put(13, "Thirteen");
		wordMap.put(14, "Fourteen");
		wordMap.put(15, "Fifteen");
		wordMap.put(16, "Sixteen");
		wordMap.put(17, "Seventeen");
		wordMap.put(18, "Eighteen");
		wordMap.put(19, "Nineteen");
		wordMap.put(20, "Twenty");
		wordMap.put(30, "Thirty");
		wordMap.put(40, "Forty");
		wordMap.put(50, "Fifty");
		wordMap.put(60, "Sixty");
		wordMap.put(70, "Seventy");
		wordMap.put(80, "Eighty");
		wordMap.put(90, "Ninety");
		
		
		//loopp through the numbers
		for (int x=0; x<numbers.length; x++){
			
			//Take the first number
			int j= numbers[x];
			int unit =1;
			//Loop untill the first number is diminished
			while (j>0){
				String temp="";
												
				int digit = j % 100;
				temp = (String) wordMap.get(digit);
				
				if (temp == null){
					if (digit >20){
						int tempNumber = digit/10;
						temp = (String)wordMap.get(tempNumber*10);
						tempNumber = digit % 10;
						temp = temp + " " +(String)wordMap.get(tempNumber)  ;
					}
				}
				
				//Find out the hundreth position
				j= j/100;
				digit = j%10;
				
				//j is now the next hndreth position
				j= j/10;
				
				if (wordMap.get(digit)!= null)
					temp = (String) wordMap.get(digit) + " " + "Hundred " + temp ;
			
				if (unit ==2 && j >=0)
					temp = temp + " " + "Thousand " ;
				
				if (unit ==3 && j>=0)
					temp = temp + " " + "Million " ;
				
				innerString = temp + innerString;
				
				unit ++;
			}
			if ( x+1 <numbers.length)
				wordFormat+= innerString + " + ";
			else 
				wordFormat+= innerString;
			
			innerString = "";
		}
		
		return wordFormat;
	}
	
	/*returns a list of prime numbers upto 100
	 * 
	 */
	
	public static List<Integer> getPrimeNumberList(int beg, int end){
		
		List<Integer> primeList = new ArrayList<Integer>();
				
		for (int i=beg; i<end; i++)
		{
			boolean prime = true;
			
			for (int j=2; j<=i/2; j++) {
				if (i ==2 || i ==1){
					break;
				}
				
				if (i % j == 0){
					prime = false;
					break;
				}
			}
			if (prime == true){
				primeList.add(i);
			}
		}
		return primeList;
	}
	
	
	/*
	 * Check for a prime number
	 */
	public static boolean checkForPrime(int i){
		
		boolean prime = true;
		
		if (i==1 || i==2 || i==3)
			return prime;
		else{
			for (int j=1; j<i/2; j++){
				if (i %j ==0){
					prime =false;
					break;
				}
			}
		}
		return prime;
	}
	
	
	/*Create a list of factors of a number in a map
	 * ex- 4 has the factors 2, 14 has the factor- 2,7 etc
	 */
	public static Map<Integer, List<Integer>> getFactors(){
		
		Map<Integer, List<Integer>> mapOfFactors = new LinkedHashMap<Integer, List<Integer>>();
		
		//List factors from 1 to 1000
		for (int i=1; i<1000; i++){
			List<Integer> listOfFactors = new ArrayList<Integer>();
			//Now list all the factors for that number
			for(int j=1; j<= i ; j++){
				if (i % j==0){
					listOfFactors.add(j);
				}
			}
			mapOfFactors.put(i, listOfFactors);
		}
		
		return mapOfFactors;
	}
	
	public static Map<Integer, List<Integer>> getPrimeFactors(){
		
		Map<Integer, List<Integer>> mapOfFactors = new LinkedHashMap<Integer, List<Integer>>();
		
		//List factors from 1 to 1000
		for (int i=1; i<500; i++){
			List<Integer> listOfFactors = new ArrayList<Integer>();
			for(int j=1; j<= i ; j++){
				if (i % j==0 && checkForPrime(j)){
					//check if that number is a prime number
					listOfFactors.add(j);
				}
			}
			mapOfFactors.put(i, listOfFactors);
		}
		
		return mapOfFactors;
	}
	
	
	/*Returns the HCF List of a given 
	 * numberList- input by user
	 * primeList- Initially null.
	 * 
	 */
	public static List<Integer> getHCF(List<Integer> numberList, List<Integer> primeList){
		
		//not sure what was the logic????
		/*for (int i=0; i< numberList.size(); i++){
			if ((int)numberList.get(i) ==1){
				return primeList;
			}
		}*/
		
		//get the maximum number in the sorted list where last item is the max number
		int maxNumber = (int) numberList.get(numberList.size()-1);
		boolean primeFactor = false;
		List<Integer> tempNumberList = null;
		int i=0;
		int counter=0;
		
		//iterate through all the numbers from 2 to the max/2 of the numbers and find if all numbers in list is divisible by i to make in a prime factor
		for (i=2; i<=maxNumber/2; i++ ){
			boolean contd = false;
			primeFactor = false;
			for (int count=0; count<numberList.size(); count++ ){
				int number = (int)numberList.get(count);
				counter++;		
				if (number%i ==0){
					contd = true;
					primeFactor=true;
					counter = count;
				}
				else{
					contd = false;
					primeFactor = false;
					counter=count;
					break;
				}
			}
			
			if (contd && counter==numberList.size()-1) {
				primeFactor= true;
				contd = true;
				primeList.add(i);
				break;
			}
			else
			{
				primeFactor = false;
				contd = false;
			}
		
		}
		if (primeFactor ){
			tempNumberList = new ArrayList();
			
			//now divide all the numbers by i to get a new numberlist and put i in the primelist
			for (int k=0; k<numberList.size(); k++ ){
				tempNumberList.add((int)numberList.get(k)/i);
			}

			
			numberList = new ArrayList();
			numberList = tempNumberList;
			getHCF(numberList, primeList);
		}
		//hcf(numberList, primeList);
		return primeList;
	}
	
	/*Returns the LCM List of a given 
	 * numberList- input by user
	 * lcmList- Initially null.
	 * 
	 * Algorithm- 2,4 7- divide by 2 to get another 1,2,7 and put 2 in a list
	 * next iteration- divide by 2 and put 2 in the same list while the new row will be 1,1,7
	 * next divide by 7 and put 7 in the list and the new row will be 1,1,1,
	 * The 
	 * 
	 */
	public static List<Integer> getLCM(List<Integer> numberList, List<Integer> lcmList){
		
		 boolean allOnes = false;

		 //check if all the numbers in the new list is 1
         for (int i=0; i< numberList.size(); i++){
        	 if ((int)numberList.get(i) ==1){
        		 allOnes = true;
             }
        	 else
        		 allOnes = false;
         }

        

         if (allOnes == true)
        	 return lcmList;
 
         //get the maximum number in the sorted list where last item is the max number
         int maxNumber = (int) numberList.get(numberList.size()-1);
         boolean divisible = false;
         boolean cond= false;
         List<Integer> tempNumberList = null;

         int i=0;
         for (i=2; i<=maxNumber; i++ ){
        	 divisible = false;
             
        	 for (int count=0; count<numberList.size(); count++ ){
            	 int number = (int)numberList.get(count);                            
            	 	if (number%i ==0){
            	 		divisible = true;
                    }
             }

             if (divisible ) {
            	 cond= true;
                 lcmList.add(i);
                 break;
             }
             else {
            	 cond = false;
             }
         }

         if (cond ){
        	 tempNumberList = new ArrayList<Integer>();

             for (int k=0; k<numberList.size(); k++ ){
            	 int newNumber = (int)numberList.get(k);
            	 if (newNumber%i == 0)
            		 tempNumberList.add(newNumber/i);
            	 else
            		 tempNumberList.add(newNumber);

             }

             numberList = new ArrayList<Integer>();
             numberList = tempNumberList;
             getLCM(numberList, lcmList);
         }

         return lcmList;	
	}
	
	/*Finding the exponent
	 * numerator = numerator of the number. For Integer this is the only parameter passed on.
	 * denominator- Only supplied when there is a fraction
	 * exponent- the exponential of a number
	 * 
	 * Will return double precision upto 4 decimal points when the exponential is for a decimal.
	 * 
	 */
	public static String getExponential(String numerator, String denominator, int exponent, String type){
		
		if (Constants.EXPONENTS_WHOLE_NUMBER.equals(type)){
			
			int expoInt = Integer.parseInt(numerator);
			int expoIntResult=expoInt;
			
			for (int i=exponent; i>1; i--){
				expoIntResult = expoIntResult*expoInt;
			}
			return Integer.toString(expoIntResult);
		}
		else if (Constants.EXPONENTS_DECIMALS.equals(type)){
			
			double expoDouble = Double.parseDouble(numerator);
			double expoDoubleResult = expoDouble;
			
			for (int i=exponent; i>1; i--){
				expoDoubleResult = expoDoubleResult*expoDouble;
			}
			BigDecimal roundUp = new BigDecimal(expoDoubleResult);
			roundUp = roundUp.setScale(4, BigDecimal.ROUND_HALF_UP);
			
			return roundUp.toString();
		}
		else if (Constants.EXPONENTS_FRACTION.equals(type)){
			
			int expoNumerator = Integer.parseInt(numerator);
			int expoDenominator = Integer.parseInt(denominator);
			
			Fraction fracResult = new Fraction(expoNumerator, expoDenominator);
			
			Fraction frac = new Fraction (expoNumerator, expoDenominator);
			
			for (int i= exponent; i>1; i--){
				fracResult = fracResult.multiply(frac);
			}
			
			return fracResult.toString();
		}
		
		
		return null;
	}
	
	/*
	 * Takes a list of fractions and performs operation
	 */
	public static Fraction getResultAsFraction(List<FractionObject> fractionList){
		
		Fraction result = new Fraction (0,1);
		
		for (int i=0; i< fractionList.size(); i++){
			
			FractionObject fo = fractionList.get(i);
			String prefix = fo.getPrefix();
			//String postfix = fo.getPostFix();
			Fraction f = new Fraction(fo.getNumerator(), fo.getDenominator());
			
			switch(prefix){
			case ("+"):
				result = result.add(f);
				break;
			case ("-"):
				result = result.subtract(f);
				break;
			case ("/"):
				result = result.divide(f);
				break;
			case ("*"):
				result = result.multiply(f);
				break;
			}
			
		}
		return result;
		
	}
	
	/*
	 * Get the question as a string ex- 5/8 + 6/10
	 */

	public static String getQuestionAsStringFraction(List<FractionObject> fractionList){
		
		String result = null;
		
		for (int i=0; i< fractionList.size(); i++){
			
			FractionObject fo = fractionList.get(i);
			String prefix = fo.getPrefix();
			int numerator = fo.getNumerator();
			int denominator = fo.getDenominator();
			
			if (numerator == denominator){
				//result = Integer.toString(1);
				
				if (i==0 && prefix.equals("+"))
				{
					if (fo.isMissingFraction())
						result = " X ";
					else
						result = Integer.toString(1);
				}
				else if (i==0 && prefix.equals("-"))
				{
					if (fo.isMissingFraction())
						result = prefix + " X ";
					else
					result = prefix + Integer.toString(1);
				}
				
				else{
					if (fo.isMissingFraction())
						result = result + " " + prefix + " X ";
					else
					result = result + " "+prefix+ " "  + Integer.toString(1);
				}
				
				
			}
			else if (fo.getFractionType().equals(Constants.FRACTION_TYPE_WHOLE)){
				if (i==0 && prefix.equals("+"))
				{
					if (fo.isMissingFraction())
						result = " X ";
					else
						result = Integer.toString(numerator);
				}
				else if (i==0 && prefix.equals("-"))
				{
					if (fo.isMissingFraction())
						result = prefix + " X ";
					else
					result = prefix + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
				else if (prefix.equals("*"))
				{
					result = result + " "+prefix+ " "  + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
				else if (prefix.equals("/"))
				{
					result = result + " "+prefix+ " "  + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
				else{
					if (fo.isMissingFraction())
						result = result + " " + prefix + " X ";
					else
					result = result + " "+prefix+ " "  + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
				
			}
			else if(fo.getFractionType().equals(Constants.FRACTION_TYPE_NORMAL))
			{
				if (i==0 && prefix.equals("+"))
				{
					if (fo.isMissingFraction())
						result = " X ";
					else
						result = "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
				else if (i==0 && prefix.equals("-"))
				{
					if (fo.isMissingFraction())
						result = prefix + " X ";
					else
					result = prefix + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
				else if (prefix.equals("*"))
				{
					if (fo.isMissingFraction())
						result = result + prefix + " X ";
					else
						result = result + " "+prefix+ " "  + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
				else if (prefix.equals("/"))
				{
					if (fo.isMissingFraction())
						result = prefix + " X ";
					else
						result = result + " "+prefix+ " "  + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
				else{
					if (fo.isMissingFraction())
						result = result + " " + prefix + " X ";
					else
					result = result + " "+prefix+ " "  + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				}
			}
			else if (fo.getFractionType().equals(Constants.FRACTION_TYPE_MIXED)){
				int newNumerator = numerator % denominator; 
				int wholePart = numerator/denominator;
				
				if (i==0 && prefix.equals("+")){
					if (fo.isMissingFraction())
						result = " X ";
					else{
						if (newNumerator ==0)
							result = Integer.toString(wholePart);
						else
							result = wholePart + "$\\frac{"+Integer.toString(newNumerator)+ "}{"+Integer.toString(denominator)+"}$";
					}
				}
				else if (i==0 && prefix.equals("-")){
					if (fo.isMissingFraction())
						result = prefix +  " " + " X ";
					else{
						if (newNumerator ==0)
							result = prefix + wholePart;
						else
							result = prefix + wholePart + "$\\frac{"+Integer.toString(newNumerator)+ "}{"+Integer.toString(denominator)+"}$";
					}
				}
				else{
					if (fo.isMissingFraction())
						result = result + " " + prefix + " X ";
					else{
						if (newNumerator ==0)
							result = result + " "  + prefix + wholePart;
						else
							result = result + " "+prefix+ " "  +wholePart +  "$\\frac{"+Integer.toString(newNumerator)+ "}{"+Integer.toString(denominator)+"}$";
					}
				}
			}
			
		}
		
		return result;
		
	}
	
	/* This will take the min and max value and will return the fraction
	 * 
	 */
	public static int[] getNumeratorDenominator(int min, int max, String type){
		
		int [] numbers = new int[2];
		int numerator=0;
		int denominator =0;
		
		numerator = MathUtilities.getRandomNumber(min, max);
		if (Constants.FRACTION_TYPE_NORMAL.equals(type)){
			denominator = MathUtilities.getRandomNumber(min, max+2);
			while (denominator < numerator){
				denominator = MathUtilities.getRandomNumber(min, max+2);
			}
		}
		else if (Constants.FRACTION_TYPE_MIXED.equals(type)){
			denominator = MathUtilities.getRandomNumber(min, max-2);
			while (denominator > numerator)
				denominator = MathUtilities.getRandomNumber(min, max-2);
		}
		
		numbers[0] = numerator;
		numbers[1] = denominator;
		
		return numbers;
		
	}
	
	/*
	 * Takes an Fraction and converts into a FractionObject
	 */
	public static FractionObject getFractionAsString(Fraction result){
		
		FractionObject resultObject = new FractionObject();
		resultObject.setNumerator(result.getNumerator());
		resultObject.setDenominator(result.getDenominator());

		resultObject.setPrefix(Constants.SIGN_PLUS);
		
		if (result.getNumerator()> result.getDenominator())
			resultObject.setFractionType(Constants.FRACTION_TYPE_MIXED);
		else if (result.getNumerator()< result.getDenominator())
			resultObject.setFractionType(Constants.FRACTION_TYPE_NORMAL);
		else if (result.getNumerator()== result.getDenominator())
			resultObject.setFractionType(Constants.FRACTION_TYPE_WHOLE);
		
		
		return resultObject;
	}
	
	
	/*Returns a fraction object when a numerator/denominator supplied
	 * 
	 */
	public static FractionObject getFractionAsString(int numerator, int denominator, String fractionType){
		
		FractionObject resultObject = new FractionObject();
		resultObject.setNumerator(numerator);
		resultObject.setDenominator(denominator);

		resultObject.setPrefix(Constants.SIGN_PLUS);
		
		if (fractionType.equals(Constants.FRACTION_TYPE_MIXED))
			resultObject.setFractionType(Constants.FRACTION_TYPE_MIXED);
		else if (fractionType.equals(Constants.FRACTION_TYPE_NORMAL))
			resultObject.setFractionType(Constants.FRACTION_TYPE_NORMAL);
		else if (fractionType.equals(Constants.FRACTION_TYPE_WHOLE))
			resultObject.setFractionType(Constants.FRACTION_TYPE_WHOLE);
		
		
		return resultObject;
	}
	
	
	/*
	 * Converts a single fraction to a String
	 */
	public static String convertSingleFRactionToString(int numerator, int denominator){
		
		//return "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
		return "$"+numerator+"\\over" +denominator+"$";
		
	}
	
	/*
	 * Rounding a decimal point 
	 */
	public static double getRoundedAnswer(double answer,  int decimalPoint){
		
		if (decimalPoint ==1)
			return (double)Math.round(answer * 10)/10;
		else if (decimalPoint ==2)
			return (double)Math.round(answer * 100)/100;
		else if (decimalPoint ==3)
			return (double)Math.round(answer * 1000)/1000;
		else if (decimalPoint ==4)
			return (double)Math.round(answer * 10000)/10000;
		else if (decimalPoint ==5)
			return (double)Math.round(answer * 100000)/100000;
		else if (decimalPoint ==6)
			return (double)Math.round(answer * 1000000)/1000000;
		else if (decimalPoint ==7)
			return (double)Math.round(answer * 10000000)/10000000;
		else
			return (double)Math.round(answer * 100000000)/100000000;
		
	}
	
	/*compare the values num1 and num2 in Unique ObjectMap
	 * 
	 */
	@SuppressWarnings("unused")
	public static boolean isObjectPresent(int num1, int num2, Map objectMaps)
	{
		
		Iterator iterator = objectMaps.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<Integer, UniqueObjectMap> entry = (Entry<Integer, UniqueObjectMap>) iterator.next();
			UniqueObjectMap  mapObject = entry.getValue();
			
			if (num1 == (int)mapObject.getNumber() && num2 == (int)mapObject.getPow()){
				return true;
			}
				
			
		}
		return false;
		
	}
	
	public static double setPrecision(double numberToFormat, int precision)
	{
		
		Double toBeTruncated = new Double(numberToFormat);
		Double truncatedDouble = BigDecimal.valueOf(toBeTruncated).setScale(precision, RoundingMode.HALF_UP).doubleValue();
		
		return truncatedDouble;
		
	}
	
	public static Double convertToRadian(double angleInDegree){
		
		double radians=0.0; 
		
		if (angleInDegree ==0)
			radians=  Math.PI * 2;
		if (angleInDegree ==90)
			radians=  Math.PI * 3/2;
		if (angleInDegree ==180)
			radians =  Math.PI;
		if (angleInDegree == 225)
			radians = Math.PI*3/4;
		if (angleInDegree == 315)
			radians = Math.PI/4;
		
		return radians;
		
	}
	
	/*
	 * take input of a number and the root. Returns a Root Object
	 */
	
	public static RootObject getRoot(int value, int pow){
		
		RootObject rObject = new RootObject();
		
		List<Integer> listofFactors = new ArrayList<Integer>();
		Map<Integer, Integer> listOfOccurance = new HashMap<Integer, Integer>();
		//get the prime list in between 2-25
		List<Integer> primeList = MathUtilities.getPrimeNumberList(2, 25);
		
		int square=1;
		int root=1;
		
		while (value != 1) {
			for (int i = 0; i < primeList.size(); i++) {
				if (value % primeList.get(i) == 0) {
					value = value / primeList.get(i);
					listofFactors.add(primeList.get(i));
				}
			}
		}
		//now put the number of occurance of each prime factor in the list for that particukar square root
		for (int i = 0; i < listofFactors.size(); i++) {
			int key = listofFactors.get(i);
			if (null == listOfOccurance.get(key)){
				listOfOccurance.put(key, 1);
			}else{
				//get the value and increment by 1
				listOfOccurance.put(key, listOfOccurance.get(key)+1);
			}
		}
		

		for (Map.Entry<Integer, Integer> entry : listOfOccurance.entrySet()) {
			
			if (entry.getValue() / pow >0){
				int x = entry.getValue()/pow;
				square = square * (int)Math.pow(entry.getKey(), x);

			}
			if (entry.getValue() % pow >0){
				int x = entry.getKey();
				root = root* x;
			}

		}
		rObject.setRoot(root);
		rObject.setSquare(square);
		
		return rObject;
	}
	
	/*
	 * takes a questionlist and arranges the new question.
	 * The first is the original question. The second the answer to the question. The next three are the false answers. Swap
	 * the second with a random number from 3-max.
	 */
	public static List<QuestionLine>getQuestionList(List<QuestionLine>qList, int maxLength, int answerPos ){
		
		int randomNumber = getRandomNumber(1, maxLength);
		QuestionLine temp = qList.get(answerPos);
		qList.set(answerPos, qList.get(randomNumber));
		qList.set(randomNumber, temp);
		
		return qList;
		
	}
	/*COnverts a number to decimal points.
	 * Ex= 105/ 10, value= 105, decimalpoint= 1
	 * 
	 */
	
	public static double convertToDecimal(int value, int decimalPoint){

		return value/Math.pow((double)10, (double)decimalPoint);
	}
	
}
