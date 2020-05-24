import static java.lang.System.*;


public class MergeSort 
{
	public static void main(String  [] args)
	{
		int A[] = new int[]{15,7,4,9,2,3,6,5};
		MergeSort.merge_sort(A,0,A.length-1); // p = 0, r = 8-1 = 7
		
		//printing the sorted array
		for(int a : A)
			out.print(a+" ");
	}
	
	static void merge(int A[], int p,int q, int r)
	{
		int n1 = q-p+1; //size of left array
		int n2 = r-q; //size of right array
		int L[] = new int[n1+1];
		int R[] = new int [n2+1];
		
		//splitting the array into two halves
		
		int i,j;
		for(i=0;i<n1; i++)
		{
			L[i] = A[p+i];
		}
		
		for(j=0;j<n2;j++)
		{
			R[j] = A[q+j+1];
		}
		
		//putting the infinite in place of the last element
		// i.e. the largest possible integer value
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		
		//merging and sorting the both arrays into a single sorted array
		//and putting corresponding elements into the original array
		
		i=0;j=0;
		int k;
		for(k=p; k<=r; k++)
		{
		if(L[i]<=R[j])
		{
			A[k] = L[i];
			i++;
		}
		else
		{
			A[k] = R[j];
			j++;
		}
		
		}
		
	}
	
	//merge procedure that breaks the array into two each time
	
	static void merge_sort(int A[], int p, int r)
	{
		int q;
		if(p<r) //let total time taken = T(n)
		{
			q = (p+r)/2;
			merge_sort(A,p,q); // half of the elements will be sorted using this: T(n/2)
			merge_sort(A,q+1,r); //half of the elements will be sorted using this: T(n/2)
			merge(A,p,q,r); // the time complexity of merge procedure: O(n)
		}
	}
}

// hence total time taken will be: T(n) = 2 * T(n/2) + O(n)
// solve it using master method 
// there will be no best or worst case
// for both of the cases time complexity will be same