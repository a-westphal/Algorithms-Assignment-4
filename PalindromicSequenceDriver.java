/**
 * CISC 380
 * Algorithms Assignment 4
 *
 * Tests the methods of the PalindromicSubsequence class.
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

        String x = "AACGAA";

        System.out.println(PalindromicSequence.getLongestPalindrome(x));
        System.out.println(PalindromicSequence.getLengthLongestPalindrome(x));

    }//main

}//class

/*
		A A C G A A
	A	1 x x x x x
	A	x 1 x x x x
	C	x x 1 x x x
	G	x x x 1 x x
	A	x x x x 1 x
	A	x x x x x 1
	
		A A C G A A
	A	1 2 2 2 3 4
	A	2 1 x x x x
	C	2 x 1 x x x
	G	2 x x 1 x x
	A	3 x x x 1 x
	A	4 x x x x 1


*/