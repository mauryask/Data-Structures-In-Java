// return index of the min diff element

import static java.lang.System.*;

public class FindingMinimumDifferenceElementForTheGivenKey
{
	static int findMinDiffElement(int A[], int n,int key)
	{
		int start = 0;
		int end = n-1;
		int ceil = -1;
		int floor = -1;
		
		while(start <= end)
		{
			int mid = start + (end - start) / 2;
			
			if(A[mid] == key)
				return key;
			
			if(A[mid] < key)
			{
				floor = mid;
				start = mid + 1;
			}
			else if(A[mid] > key)
			{
				 ceil = mid;
				 end = mid - 1;
			}
		}
		
		if(floor != -1 && ceil != -1)
		{
			int floorDif = Math.abs(A[floor] - key);
            int ceilDiff  = Math.abs(A[ceil] - key);
			return floorDif < ceilDiff ? floor : ceil;		
		}
		 
		return floor == -1 ? ceil : floor;
	}
	
	public static void main(String [] args)
	{
		int A[] = {15,20,25,63,95,100,102,115,140};
		int key = 98;
		int n = A.length;
		
		out.println(findMinDiffElement(A, n, key));
	}
}