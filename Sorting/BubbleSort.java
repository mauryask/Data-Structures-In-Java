import static java.lang.System.*;

public class BubbleSort 
{
	public static void main(String [] args)
	{
		int A[] = {10,8,5,4,1,2,74,63,20};
		out.print("The array before sorting: ");
		printArray(A);
		bubble_sort(A);
		out.print("The array after sorting: ");
		printArray(A);
	}

    static void bubble_sort(int A[])
	{

		int i, j, temp;
        boolean flag = false;
		
		for(i=0; i<A.length; i++)
		{
			// this checks if array is sorted 
			// or not
			
			flag = false;
			
			for(j=0; j<A.length-i-1; j++)
			{
				if(A[j] > A[j+1])
				{
					temp = A[j];
					A[j] =  A[j+1];
					A[j+1]  = temp;
					
					/*
					* set it to true if swapping occurs 
					*/
					flag = true; 
				}
				
				// if flag is still false
				// means array is sorted
				// no needs to execute the algo further
				
				if(!flag)
					break;
			}
		}
	}

	static void printArray(int A[])
	{
		for(int i=0; i<A.length; i++)
	          out.print(A[i]+" ");
		out.println();
	}	
}
