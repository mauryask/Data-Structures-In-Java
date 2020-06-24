//Time Complexity: 
// Best Case: O(n*logn) : this case occurs when array is already sorted
// Worst case : O(n^2)
public class ShellSort
{
	static void shellSort(int A[], int n)
	{
		int j;
		
		for(int gap = n/2; gap>=1; gap/=2)
		{
			for(int i=gap; i<n; i++)
			{
				int temp = A[i];
				for(j=i; j>=gap && A[j-gap] > temp; j-=gap)
					A[j] = A[j-gap];
				
				A[j] = temp;
			}				
		}
	}
	
	public static void main(String args [])
	{
		int arr[] = {45,74,10,4,2,56,30,12};
		shellSort(arr, arr.length);
		
		//print the sorted array
		for(int x : arr)
			System.out.print(x+" ");
	}
}