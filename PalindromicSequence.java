/**
 * CISC 380
 * Algorithms Assignment 4 EXTRA CREDIT
 * 
 * Implements a dynamic programming solution to find the length of the longest palindromic subsequence.
 * 
 * @author Abby Westphal, Chase Rapp
 * Due Date: 04/03/20
 */


public class PalindromicSequence{

    /**
     * Implements a dynamic programming solution to find the length of the longest Palindromic subsequence of the given string.
     * 
     * 
     * @param x the string that may contain a palindromic subsequence
     * @return the length of the longest palindromic subsequence, or 0 if there is none.
     */
    public static int getLengthLongestPalindrome(String x){
        //YOUR CODE HERE
        int [] [] table = new int [x.length()][x.length()];

        //initialize the table to be full of 0's with 1's on the diagonal
       for(int i = 0; i < x.length(); i ++)
        {
            for(int j = 0; j < x.length(); j ++)
            {
                if(i == j)
                {
                    table[i][j] = 1;
                }
                else
                {
                    table[i][j] = 0;
                }

                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }

        /*  i starts at 2 because we use it to compare groups of two characters within the string
            essentially comparing the first and last characters, and if they are the same, we add
            2 to the sum at the correct index  */
        for(int i = 2; i <= x.length(); i++)
        {
            /* start comparing values of entire string, and continually "reduce" the 
                string length  
                essentially comparing the first and last values of the string over and 
                over, moving where the first and last values are located */
            for(int j = 0; j < x.length() - i + 1; j++)
            {
                /* variable that moves around to actually compare characters  */
               int hold = i + j -1; 

               /*   if on the first pass of i j == hold, then that value = 2, because 
                    we haven't summed anything yet(due to it being the first i pass)  */
                if(x.charAt(j) == x.charAt(hold) && i == 2)
                {
                    table[j][hold] = 2;
                }
                
                /*  if it isn't the first pass of i, add two to the right diagonal value */ 
                else if(x.charAt(j) == x.charAt(h))
                {
                    table[j][hold] = table[j+1][hold-1] + 2;
                }

                /*  otherwise, take the maximum of the cell left of and above the cell we are 
                    currently looking at*/ 
                else
                {
                    table[j][hold] = Math.max(table[j][hold-1], table[j+1][hold]);
                }

            }
        }


        System.out.println("\nFilled in table: ");
        for(int i = 0; i < x.length(); i ++)
        {
            for(int j = 0; j < x.length(); j ++)
            {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }

        return table[0][x.length()-1];

    }//longestPalindrome

    /**
     * Implements a dynamic programming solution to return the longest palindromic subsequence of the given string 
     * @param x the string that may contain a palindromic subsequence
     * @return the string of the longest palindrome, or null if there is none
     */
    public static String getLongestPalindrome(String x) {
        //YOUR EXTRA CREDIT CODE HERE
    
        return null;
    }



}//class