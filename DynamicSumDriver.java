/**
 * CISC 380
 * Algorithms Assignment 4
 *
 * Tests the methods of the DynamicSum class.
 * 
 * @author YOUR NAME HERE
 * Due Date: xx/xx/xx
 *
 *  This driver file contains a single example test case to get you started.
 *  You should include more test cases to ensure that your implementation works correctly.
 *  You do NOT need to submit this file.
 *
 */



public class DynamicSumDriver{

    public static void main(String[] args){
		
        DynamicSum dSum = new DynamicSum();

        int[] testArr = {10,10,10,10,10,10,10,10,10,10,10};

        System.out.println(dSum.isSum    (testArr, 14));
        System.out.println(dSum.isSumMem (testArr, 14));
        // System.out.println(dSum.getSubset(testArr, 14));
		System.out.println(testArr);
		
dSum.getSubset(testArr, 30);
    }//main

}//class