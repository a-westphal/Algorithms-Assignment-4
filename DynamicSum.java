/**
 * CISC 380
 * Algorithms Assignment 4
 * 
 * Implements dynamic programming solutions to see if a subset adds up to a value.
 * 
 * @author Abby Westphal, Chase Rapp
 * Due Date: 04/03/2020
 */



public class DynamicSum{

    public DynamicSum()
	{
        //YOUR CODE HERE
    }//constructor

    /**
     *Checks to see if a subset of arr adds up to exactly t with an iterative solution.
	 *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return True, if a subset adds up to t, false otherwise.
     * 
     */
    public boolean isSum(int[] arr, int t)
	{
		boolean[][] results = new boolean[arr.length][t + 1];
		
		for(int i = 0;i < results.length;i++)
			for(int j = 0;j < results[i].length;j++)
				results[i][j] = false;
			
		for(int i = 0;i < arr.length;i++)
			results[i][arr[i]] = true;
		
		
		for(int i = 0;i < arr.length;i++)
		{
			for(int j = 0;j <= t;j++)
			{
				if(j > 0 && i > 0)
				{
					results[i][j] = results[i-1][j] || results[i][j];
					
					if(j-arr[i] >= 0)
						results[i][j] = results[i][j] || results[i-1][j-arr[i]];
				}
			}
		}

		return results[arr.length - 1][t];
    }//isSum

    /**
     *Checks to see if a subset of arr adds up to exactly t with a memoizied solution.
	 *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return    True, if a subset adds up to t, false otherwise.
     * 
     */
    public boolean isSumMem(int[] arr, int t) 
	{
		Boolean[][] results = new Boolean[arr.length][t + 1];
		
		for(int i = 0;i < results.length;i++)
			for(int j = 0;j < results[i].length;j++)
				results[i][j] = null;
			
		for(int i = 0;i < arr.length;i++)
			results[i][arr[i]] = true;

		return memRecursion(arr,results,arr.length-1,t);
    }//isSumMem

	private Boolean memRecursion(int[] arr,Boolean[][] results,int i,int j)
	{
		if(i >= 0 && j >= 0)
		{
			if(results[i][j] == null)
			{
				results[i][j] = memRecursion(arr,results,i-1,j);
				
				if(j-arr[i] >= 0)
					results[i][j] = results[i][j] || memRecursion(arr,results,i-1,j-arr[i]);
			}
			
			return results[i][j];
		}
		
		else
			return false;
	}
	
    /**
     * Recovers the subset of arr that adds up to t, if it exists.
	 *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return a subset of arr that adds up to t, null otherwise.
     * 
     */
    public int[] getSubset(int[] arr, int t)
	{
        //YOUR CODE HERE

        return null;
    }//getSubset

}//class