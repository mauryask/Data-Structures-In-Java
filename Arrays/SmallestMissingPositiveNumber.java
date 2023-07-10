/*
* T(n) : O(n)
* S(n) : O(1)
*/

import static java.lang.System.*;
import java.util.*;

public class SmallestMissingPositiveNumber 
{
	//Shifting all the positive nbumbers to the left
	static int arrangePositiveValues(int[] A)
	{
		int i = -1;
        
		for(int j=0; j<A.length; j++)
		{
			if(A[j] > 0)
			{
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}	

       return i+1; //count of the positive numbers
	}
	
	static int getSmallestPositiveNumber(int[] A)
	{
		int count = arrangePositiveValues(A);
		
		for(int i=0; i<count; i++)
		{
			    //Get the index for the current number
				int index = (int)Math.abs(A[i])-1; 
				//If index is greater han count-1 continue
				if(index > count-1)
					continue;
				//Make this number negative (to mark it as found)
				A[index] = -1 * Math.abs(A[index]);
		}
		
		//Find the first index that contains positive value
		for(int i=0; i<A.length; i++)
			if(A[i] > 0)
				return i+1;
					
		return count+1;
	}
	
	public static void main(String[] args)
	{
		int[] A = {-1, 2, 3, -7, 6, -10, 8, 15};
	    // int[] A = { 2, 3, -7, 6, 8, 1, -10, 15};
	    //int[] A = {1, 1, 0, -1, -2};
		out.println(getSmallestPositiveNumber(A));		
	}
}