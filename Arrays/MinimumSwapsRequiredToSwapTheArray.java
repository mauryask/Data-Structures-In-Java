import java.util.*;
import static java.lang.System.*;

class Element
{
	int ele;
	int index;
	
	Element(int ele, int index)
	{
	  this.ele = ele;
	  this.index = index;
	}
}

public class MinimumSwapsRequiredToSwapTheArray 
{	
    // O(n log n)
	// S(n) : O(n)
    // idea is to sort the gievn array along 
    // with the indices	 then convert it back to
	// original array by swapping the coresponding 
    // elements and count number of swaps at the same time
	
	static int minSwap(int[] A,int n)
	{
		List<Element> list = new ArrayList<>();
		
	   	for(int i=0; i<n; i++)
	       list.add(new Element(A[i], i));
	   
        Collections.sort(list, (a,b)->{
			return a.ele - b.ele;
		});	   
		
		int i=0;
		int count = 0;
		
		while(i<n)
		{
			Element ele = list.get(i);
			int index = ele.index;
			
			if(index != i)
			{
				list.set(i, list.get(index));
				list.set(index, ele);
				count++;
			}
			else
				i++;
		}
		
		return count;
	}
	
	// T(n) : O(n*n)
	// S(n) : O(1)
	static int bruteForce(int[] A,int n)
	{
		int count = 0;
		
		for(int i=0; i<n; i++)
		{
			int min = minIndex(A, i, n);
			
			if(min != i)
			{
				int temp = A[i];
				A[i] = A[min];
				A[min] = temp;
				count++;
			}
		}
		
		return count;
	}
	
	static int minIndex(int[] A,int i, int n)
	{
		int minIndex = i;
		int min = A[i];
		
		for(int j=i+1; j<n; j++)
		{
			if(min > A[j])
			{
				min = A[j];
				minIndex = j;
			}
		}
		
		return minIndex;
	}
	
	public static void main(String [] args)
	{
		int A[] = {101,758,315,730,472,619,460,479};
		int n = A.length;
		
		//out.println(minSwap(A, n));
		out.println(bruteForce(A, n));
	}
}