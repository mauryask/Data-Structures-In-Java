import static java.lang.System.*;

public class Test 
{
	public static void main(String [] args)
	{
		out.println(solve("hello","ll"));
	}
	
	static int solve(String x, String y)
	{
		int m = x.length();
		int n = y.length();
		
		if(m < n)
			return -1;
		
		if((m==0 && n==0) || (m != 0 && n==0))
			return 0;
		
	    for(int i=0; i<m ; i++)
		{
			if(m-i < n)
				return -1;
			
			if(x.charAt(i) == y.charAt(0))
			{
			   if(check(x,y,m,n,i))
				   return i;
			}
		}			
	}
	
	static boolean check(String x, String y, int m, int n, int k)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=k; j<m; j++)
			{
				if(x.charAt(i) != y.charAt(j))
					return false;
			}
		}
		
		return true;
	}
}