import static java.lang.System.*;

public class BubbleSort 
{
	public static void main(String [] args)
	{
		int A[] =  new int[] {1,2,3,4,5,6,7,8,9,10};
		out.print("The array before sorting: ");
		BubbleSort.printArray(A);
		BubbleSort.bubble_sort(A);
		out.print("The array after sorting: ");
		BubbleSort.printArray(A);
	}

	static void bubble_sort(int A[])
	{

		int i, j, temp;
		int swapped = 0;

		for(i=0; i<A.length; i++)
		{
			for(j=0; j<A.length-i-1; j++)
			{
				if(A[j] > A[j+1])
				{
					temp = A[j];
					A[j] =  A[j+1];
					A[j+1]  = temp;
					swapped=1; //if array is already sorted
				}
			}

			if(swapped==0)
				break;
		}
	}



	static void printArray(int A[])
	{
		for(int i=0; i<A.length; i++)
	          out.print(A[i]+" ");
		out.println();
	}
	
}
