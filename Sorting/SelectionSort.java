import static java.lang.System.*;

public class SelectionSort 
{
   public static void main(String [] args)
    {
	int A[] = new int[]{8,5,4,7,9,2,0,4,6};
	out.print("The array beforee sorting: ");
	SelectionSort.printArray(A);
	SelectionSort.selection_sort(A);
	out.print("The array after sorting: ");
	SelectionSort.printArray(A);
    }



   	static void selection_sort(int A[])
	{

		int i,j,min_index, temp;

		for(i=0; i<A.length-1; i++)
		{
			min_index = SelectionSort.getMin(A,i);
			temp = A[min_index];
			A[min_index] = A[i];
			A[i]=  temp;
		}

	}


	static int getMin(int A[], int i)
	{
	  int min_value = A[i];
  	  int min_index = i;
		for(int j=i+1; j<A.length; j++)
		{
			if(min_value>A[j])
			{
				min_value = A[j];
				min_index = j;
			}
		}
		return min_index;		
	}
	

   	static void printArray(int A[])
	{
		for(int i=0; i< A.length; i++)
			out.print(A[i]+" ");
		out.println();
	}
}
