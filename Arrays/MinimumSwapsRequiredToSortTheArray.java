import java.util.*;
import static java.lang.System.*;

public class MinimumSwapsRequiredToSortTheArray
{	
    // O(n log n)
	// S(n) : O(n)
    // idea is to sort the gievn array along 
    // with the indices	 then convert it back to
	// original array by swapping the coresponding 
    // elements and count number of swaps at the same time
	
	static class Element 
	{
		int value;
		int index;
		
		Element(int value, int index)
		{
			this.value = value;
			this.index = index;
		}
	}
	
	static int getMinSwaps(int[] A)
	{
		List<Element> list = new ArrayList<>();

	    for(int i=0; i<A.length; i++)
			list.add(new Element(A[i], i));
		
		int swapCount = 0;
		
		Collections.sort(list, (a, b)->a.value-b.value);
		
		//This runs in O(n) actually
		//Since every round of innter whilev loop
		//Places an element at its proper place
		for(int i=0; i<A.length; i++)
		{
		    int index = list.get(i).index;
						
			//If element is alreay at proper location don't go inside the loop			
			while(index != i)
			{
			    Element e2 = list.get(index);
				Element e1 = list.get(i);
				list.set(index, e1);
				list.set(i, e2);
				index = list.get(i).index;
				swapCount++;
			}				
		}
		
		return swapCount;
	}
	

	// T(n) : O(n*n)
	// S(n) : O(1)
	//This is nothing but the selection sort
	static int getMinIndex(int[] A, int index)
	{
		int minIndex = index;
		int minVal = A[index];
		
		for(int i=index+1; i<A.length; i++)
		{
			if(minVal > A[i])
			{
				minVal = A[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	static int bruteForce(int[] A)
	{
		int swapCount = 0;
		
		for(int i=0; i<A.length; i++)
		{
			int minIndex = getMinIndex(A, i);
			
			if(minIndex == i)
				continue;
			
			int temp = A[minIndex];
			A[minIndex] = A[i];
			A[i] = temp;
			swapCount++;
		}
		
		return swapCount;
	}
	
	
	public static void main(String [] args)
	{
		int A[] = {101,758,315,730,472,619,460,479};				
		//out.println(getMinSwaps(A));
		out.println(bruteForce(A));
	}
}