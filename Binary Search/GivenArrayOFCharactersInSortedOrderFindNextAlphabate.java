/*
* Time complexity  : O(log n)
* Space complexity : O(1)
* The smallest character (ASCII) greater than the given
* character (ASCII) is the next letter 
*****************
* It is same as Ceil problem only diffrence is
* in ceil if the element is present then 
* it is going to be Ceil itself
*************
* But here if element is present still we r going to
* resturn the next characater to it
*/

import static java.lang.System.*;

public class GivenArrayOFCharactersInSortedOrderFindNextAlphabate
{
	static char findNextAlphabate(char A[], int n, char ch)
	{
		int start = 0;
		int end = n-1;
		char result = '\u0000'; // initialize with null character
		
		while(start <= end)
		{
			int mid = (start+end)/2;//start + (end-start)/2;
			
			if(ch < A[mid])
			{
				result = A[mid];
				end = mid - 1;
			}
			
			/*
			* If the element is found
			* still we will continue our search
			* by putting start = mid+1
			*/
			
			else if(ch >= A[mid])
				start = mid + 1;
		}
		
		return result;
	}

	public static void main(String [] args)
	{
		String str = "abdfikmnp";
		char A[] = str.toCharArray();
		int n = A.length;
		char ch = 'f';
		
		out.println(findNextAlphabate(A, n, ch));
	}
}