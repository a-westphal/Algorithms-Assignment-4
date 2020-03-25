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