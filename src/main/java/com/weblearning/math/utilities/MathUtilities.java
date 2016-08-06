package com.weblearning.math.utilities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.math3.fraction.Fraction;

import com.weblearning.utilities.Constants;

/* Utility class to for Gr 5
 * 
 */

public class MathUtilities {
	
	/*Returns a random number within a rangs
	 * 
	 */
	public static int getRandomNumber(int min, int max){
		
		Random r = new Random();
		int randomNumber = r.nextInt(max - min + 1) + min;
		
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
	
	@SuppressWarnings("rawtypes")
	public static List getPrimeNumberList(int beg, int end){
		
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
		
		for (int i=0; i< numberList.size(); i++){
			if ((int)numberList.get(i) ==1){
				return primeList;
			}
		}
		
		//get the maximum number in the sorted list where last item is the max number
		int maxNumber = (int) numberList.get(numberList.size()-1);
		boolean primeFactor = false;
		List<Integer> tempNumberList = null;
		int i=0;
		int counter=0;
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
	

}
