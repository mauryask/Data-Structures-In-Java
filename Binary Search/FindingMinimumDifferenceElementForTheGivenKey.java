// return index of the min diff element

import static java.lang.System.*;

public class FindingMinimumDifferenceElementForTheGivenKey
{
	static int getMinDiffElement(int A[], int key)
	{
		int start = 0;
		int end = A.length-1;
		int ceil = -1;
		int floor = -1;
		
		while(start <= end)
		{
			int mid = start + (end - start) / 2;
			
			if(A[mid] == key)
				return key;			
			else if(A[mid] < key)
			{
				floor = A[mid];
				start = mid + 1;
			}
			else if(A[mid] > key)
			{
				 ceil = A[mid];
				 end = mid - 1;
			}
		}
		
		if(floor != -1 && ceil != -1)
		{
			int floorDif = Math.abs(floor - key);
            int ceilDiff  = Math.abs(ceil - key);
			return floorDif < ceilDiff ? floor : ceil;		
		}
		 
		return floor == -1 ? ceil : floor;
	}
	
	public static void main(String [] args)
	{
		int A[] = {15,20,25,63,95,100,102,115,140};
		int key = 98;
				
		out.println(getMinDiffElement(A, key));
	}
}