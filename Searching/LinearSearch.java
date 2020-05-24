import static java.lang.System.*;

public class LinearSearch 
{
	public static void main(String [] args)
	{
		int A[]  = new int []{7,8,96,5,4,7,2};
		int target = 5;

		LinearSearch.linear_search(A,target);
	}


	static void  linear_search(int A[], int target)
	{
		
	  for(int i=0;i<A.length; i++)
	  {
		if(target== A[i])
		{
			out.println("The element is found at index: "+ i);
			break;
		}
					
	  }

	}
}
