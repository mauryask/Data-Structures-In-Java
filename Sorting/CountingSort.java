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
	static int findMax(int input[])
	{
		int max = input[0];
		for(int i=1; i<input.length; i++)
		{
		   if(max < input[i])
			   max = input[i];
		}
		return max;
	}
		
	static void fillCount(int input[], int count[])
	{
		for(int i=0; i<input.length; i++)
		  count[input[i]]++;
	  
	  //updating count array
	  for(int i=1; i<count.length; i++)
		  count[i] = count[i] + count[i-1];
	}
	
	static void countingSort(int input[], int count[], int output[])
	{
		for(int i = input.length-1; i>=0; i--)
		{
			count[input[i]]--;
			int index =  count[input[i]];
			output[index] = input[i];
		}
	}
	
	public static void main(String [] args)
	{
		//int input[] = {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
		int input[] = {5,4,7,8,9,3,5,5,7,8,9,6,3,4};
		int output[] = new int[input.length];
	    int max = findMax(input); //O(n)
		
		//initialize count with zero initially
		int count [] = new int[max+1];
		fillCount(input, count); //O(n+k) where  k = max
		countingSort(input,count,output);  // O(n)
		for(int i : output)
			System.out.print(i+" ");
	}
}