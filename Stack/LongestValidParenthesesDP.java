/*
* T(n) : O(n)
* S(n) : O(n)
* Dynamic programming
*/
import static java.lang.System.*;

public class LongestValidParenthesesDP
{
    //O(n) and O(1) solution

	/*
	* Here the reason to traverse fro left to right and then from right to left is 
	* Conside this case (() : Here left will never be equal to right
	* Even if the a valid parenthese of length 2 is already there 
	* Hence to get the correct answer we have to traverse from right to left as well
	*/

    static int longestValidParentheses(String s) {
        int lLeft  = 0;
        int lRight = 0;
        int rLeft  = 0;
        int rRight = 0;
        int l2rMax = 0;
        int r2lMax = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            //Left to right
            if(s.charAt(i) == '(') 
              lLeft++;              
            else 
              lRight++;

            if(lLeft == lRight){
                l2rMax = Math.max(l2rMax, lLeft * 2);
            }else if(lRight > lLeft){
                lLeft = lRight = 0;
            } 

            //Right to left 
            if(s.charAt(n-i-1) == ')')
               rRight++;
            else 
               rLeft++;   

            if(rLeft == rRight){
                r2lMax = Math.max(r2lMax, rRight * 2);
            }else if(rLeft > rRight){
                rLeft = rRight = 0;
            }    
        }

        return Math.max(l2rMax, r2lMax);
    }
	
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
