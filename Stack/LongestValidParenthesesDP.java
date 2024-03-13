/*
* T(n) : O(n)
* S(n) : O(n)
* Dynamic programming
*/
import static java.lang.System.*;

public class LongestValidParenthesesDP
{
	static int getLength(String str)
	{
		int n = str.length();
		
		if(n <= 1)
			return 0;
		
		/*
		* Here dp[i+1] represents length valid parentheses till dp[i]
		* j is the position of the open bracket (if any) correspoinding to i 
		*/
		int dp[] = new int[n+1];
		dp[0] = dp[1] = 0;
		
		int max = 0;
		
		for(int i=1; i<n; i++)
		{
			char ch = str.charAt(i);
			
			if(ch == '(')
				dp[i+1] = 0;
			else
			{
			   int j = i - dp[i] - 1;
			   if(j < 0)
			   {
				   dp[i+1] = 0;
				   continue;
			   }
			   
			   ch = str.charAt(j);			   
			   
			   if(ch == '(')
			   {
				   dp[i+1] = dp[i] + dp[j] + 2;
				   max = Math.max(max, dp[i+1]);
			   }
			}
		}
		
		return max;
	}
	
	public static void main(String [] args)
	{
		String str = "()()))()()()()()";
		out.println(getLength(str));
	}
}
