/*
* Time Complexity : O(d * (n+b))
* d : is number of digits in largest element
* b : base of the nubers (here 10 in our case)
* if you want to sort alphabets then, b = 26
* n : ofcourse number of elements
**/

import java.util.Arrays;
public class RadixSort 
{
	static int findMax(int input[], int n) // O(n)
	{
		int max = input[0];
		for(int i=1; i<n; i++)
		 if(max < input[i])
			 max = input[i];
		 return max;
	}
	
	static void countingSort(int input[], int exp, int n) // O(n+b)
	{
		int count[] = new int[10];
		int output[] = new int[n];
		
		//fill count with zeros
		Arrays.fill(count, 0);
		
		//fill the coutn array with frequency of last digit in each nuber
		 for(int i=0; i<n; i++)
			 count[(input[i]/exp)%10]++;
		 
		 //update the count array
		 for(int i=1; i<10; i++) // O(b)
			 count[i] +=  count[i-1];
		 
		 for(int i=n-1; i>=0; i--)
		 {
			 int index = --count[(input[i]/exp)%10];
			 output[index] = input[i]; 
		 }
		 
		 //copy the output array into input array
		 for(int i=0; i<n; i++)
			 input[i] = output[i];
	}
	
	static void radixSort(int input[], int n) // O(n) + O(d*(n+b))
	{
		int max = findMax(input, n);
		
		// O(d), where d = number of digits in largest number
		for(int exp = 1 ; max/exp >0; exp *= 10) 
			countingSort(input, exp, n);
	}
	
	public static void main(String [] args)
	{
		int input[] = {10,3,273,40,375,110,99};
		radixSort(input, input.length);
		for(int i : input)
			System.out.print(i+" ");
	}
}