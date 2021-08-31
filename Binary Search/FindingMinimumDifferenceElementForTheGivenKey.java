import static java.lang.System.*;

public class FindingMinimumDifferenceElementForTheGivenKey
{
	static int findMinDiffElement(int A[], int n,int key)
	{
		int start = 0;
		int end = n-1;
		
		while(start <= end)
		{
			int mid = start + (end - start) / 2;
			
			if(A[mid] == key)
				return key;
			
			if(A[mid] < key)
				start = mid + 1;
			else if(A[mid] > key)
			   end = mid - 1;
		}
		
		int floorEle = end >= 0 ? A[end] : Integer.MAX_VALUE;
		int ceilEle = 	start < n ? A[start]: Integer.MAX_VALUE;		
	  
	    return Math.abs(floorEle-key) < Math.abs(ceilEle-key)
		? floorEle : ceilEle;
	}
	
	public static void main(String [] args)
	{
		int A[] = {15,20,25,63,95,100,102,115,140};
		int key = 500;
		int n = A.length;
		
		out.println(findMinDiffElement(A, n, key));
	}
}