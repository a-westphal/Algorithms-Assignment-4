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
		/*
			RUNTIME: Theta(nt), where n is equal to the length of the input array. The program contains two nested for-loops, which each have one bound from 0->n and one from 0->t, and no other portion of the code runs longer than this.
		*/
		
		boolean[][] results = new boolean[arr.length][t + 1];
		
		for(int i = 0;i < results.length;i++)
			for(int j = 0;j < results[i].length;j++)
				results[i][j] = false;
			
		for(int i = 0;i < arr.length;i++)	// BASE CASE: the target value matches the size of the current element, therefore the target can be hit using the current element alone
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
		/*
			TODO figure out runtime explanation
		*/
		Boolean[][] results = new Boolean[arr.length][t + 1];
		
		for(int i = 0;i < results.length;i++)
			for(int j = 0;j < results[i].length;j++)
				results[i][j] = null;
			
		for(int i = 0;i < arr.length;i++)	// BASE CASE: the target value matches the size of the current element, therefore the target can be hit using the current element alone
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
		/*
			RUNTIME: Theta(nt), when n is the size of the input array. We've already determined that filling the table is a Theta(nt) operation, and the loops in our recovery code are at worst Theta(n), so they do not affect the asymptotic runtime adversely.
		*/
		
		Boolean[][] results = new Boolean[arr.length][t + 1];
		Integer[] subset = new Integer[arr.length];
		
		for(int i = 0;i < results.length;i++)
			for(int j = 0;j < results[i].length;j++)
				results[i][j] = null;
			
		for(int i = 0;i < arr.length;i++)
		{
			if(arr[i] < t)
				results[i][arr[i]] = true;
		}

		boolean success = memRecursion(arr,results,arr.length-1,t);

		// for(int it = 0;it < results.length;it++)
		// {
			// for(int jt = 0;jt < results[it].length;jt++)
			// {
				// Boolean element = results[it][jt];
				
				// if(element == null)
					// System.out.print("n");
				// else if(element == true)
					// System.out.print("t");
				// else if (element == false)
					// System.out.print("f");
				
				// System.out.print(" ");
			// }
			
			// System.out.println();
		// }
			
		if(!success)
			throw new RuntimeException("There is not a valid solution");
		
		else
		{
			int subset_idx = 0;
			
			int i = results.length - 1;
			int j = results[i].length - 1;
			
			while(i >= 0 && j >= 0)
			{				
				// System.out.println("Testing element " + i + " with value " + arr[i] + " against new weight " + (j - arr[i]));
				
				if((j - arr[i]) == 0)
				{
					// System.out.println("Using value: " + arr[i]);
					subset[subset_idx++] = arr[i];
				
					j -= arr[i];
				}
				
				else if((j-arr[i]) >= 0 && results[i-1][j-arr[i]] != null)
				{
					// System.out.println("First test passed");
					
					if(results[i-1][j-arr[i]] == true)
					{
						// System.out.println("Using value: " + arr[i]);
						subset[subset_idx++] = arr[i];
					
						j -= arr[i];
					}
				}
				
				i--;
			}
			
			// for(int d = 0;d < results.length;d++)
				// System.out.println(subset[d]);
			
		}
	
		// System.out.println("final result:");
		int count = 0;
		
		while(count < subset.length && subset[count] != null)
			count++;
		
		int[] final_result = new int[count];
		
		for(int i = 0;i < final_result.length;i++)
			final_result[i] = subset[i];
		
		// for(int i = 0;i < final_result.length;i++)
			// System.out.println(final_result[i]);
		
        return final_result;
    }//getSubset

}//class