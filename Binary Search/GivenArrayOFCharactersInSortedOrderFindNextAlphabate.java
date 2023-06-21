/*
* Time complexity  : O(log n)
* Space complexity : O(1)
*/

import static java.lang.System.*;

public class GivenArrayOFCharactersInSortedOrderFindNextAlphabate
{
	static char getNextAlphabate(String str, char target)
	{
		int start = 0;
		int end = str.length()-1;
		char result = '\u0000';
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			char ch = str.charAt(mid);
			
			if(ch > target)
			{
				result = ch;
				end = mid - 1;
			}
			else if(ch <= target)
				start = mid + 1;
		}
		
		return result;
	}

	public static void main(String [] args)
	{
		String str = "abdfikmnp";				
		char target = 'f';		
		out.println(getNextAlphabate(str, target));
	}
}