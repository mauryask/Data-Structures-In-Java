import static java.lang.System.*;

public class BubbleSort 
{
    static void bubbleSort(int A[])
	{		
        for(int i=0; i<A.length-1; i++)
		{			
			boolean flag = false;
			
			for(int j=0; j<A.length-i-1; j++)
			{
				if(A[j] > A[j+1])
				{
					int temp = A[j];
					A[j] =  A[j+1];
					A[j+1]  = temp;									
					flag = true; 
				}
				
				if(!flag)
					break;
			}
		}
		
		for(int x : A)
			out.print(x+" ");
	}

	public static void main(String [] args)
	{
		int A[] = {10,8,5,4,1,2,74,63,20};
		bubbleSort(A);
	}
}
