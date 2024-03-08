//Time Complexity : O(n+k)
/*
* Drawbacks
* Does not work with -ve numbers 
* (but you can modify it to work with -ve numbers)
* it is not good technique if k(max) >> n
* k should be of about O(n)
*/
public class CountingSort 
{
	static int findMax(int input[], int n)
	{
		int max = input[0];
		for(int i=1; i<n; i++)
		{
		   if(max < input[i])
			   max = input[i];
		}
		return max;
	}
		
	static void fillCount(int input[], int count[], int n)
	{
		for(int i=0; i<n; i++)
		  count[input[i]]++;
	  
	  //updating count array
	  for(int i=1; i<count.length; i++)
		  count[i] += count[i-1];
	}
	
	static void countingSort(int input[], int count[], int n)
	{
		int output[] = new int[n];
		//We go from right to left to maintrain the statbility of the count sort
		//that is the elemnts should come in the same order that they appeared in original array
		for(int i = n-1; i>=0; i--)
		{
			int index =  --count[input[i]];
			output[index] = input[i];
		}
		
		//copy the output array into input array
		for(int i=0; i<n; i++)
			input[i] = output[i];
	}
	
	public static void main(String [] args)
	{
		//int input[] = {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
		int input[] = {5,4,7,8,9,3,5,5,7,8,9,6,3,4};
		int n = input.length;
	    int max = findMax(input, n); //O(n)
		
		//initialize count with zero initially
		int count [] = new int[max+1];
		fillCount(input, count, n); //O(n+k) where  k = max
		countingSort(input,count, n);  // O(n)
		for(int i : input)
			System.out.print(i+" ");
	}
}