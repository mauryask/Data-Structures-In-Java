import static java.lang.System.*;
import java.util.*;

public class CreateLArgestNumberFromGivenDisgits
{
	// T(n) : O(n x logn)
    // S(n) : O(1)	
	static void naiveSolution(int[] A, int n)
	{
		Arrays.sort(A);
		
		String str  = "";
		for(int i = n-1; i>=0 ; i--)
			str += A[i];
		out.println(str);
	}
	
	// T(n) : O(n) 
	// S(n) : O(1)
	/*
	* The idea is the sigits are going to be
	* from 0-9 so we are going to store the frequency of each and every number in num array
	* and rest is below
	*/
	static void getNumber(int[] A, int n)
	{
		int num[] = new int[10];
		
		for(int x: A)
		  num[x]++;
		
        int mul = 1;
        int result = 0;
        for(int i = 0; i<10; i++)
		{
			int freq = num[i];
			
			while(freq-->0)
			{
				result  += (i*mul);
				mul = mul * 10;
			}
		}

        out.println(result);		
	}
	
	public static void main(String [] args)
	{
	    int A[] = {8, 6, 0, 4, 6, 4, 2, 7};
		getNumber(A, A.length);
		//naiveSolution(A, A.length);
	}
}