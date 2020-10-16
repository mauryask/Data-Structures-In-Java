// Time complexity : O(√n)
// Prerequisite : Array must already be sorted 
// Optimal Number of jumps : √n
// It is not better than binary search

public class JumpSerach
{
	static int linearSerach(int A[], int i, int j, int item) //O(√n)
	{
		for(int x = i; x<=j; x++)
			if(A[x] == item)
				return x;
		return -1;	
	}
	
	static int jumpSerach(int A[], int n, int item)
	{
		int jump = (int)Math.sqrt(n);
		int i,j;
		for(i=0,j=jump; j<n ; i=j,j+=jump) 
		{
			if(A[i] == item)
				return i;
			else if(A[j] == item)
				return j;
			else if(item>A[i] && item <A[j])
				return linearSerach(A,i,j, item);
		}
		
		return linearSerach(A, i, n-1, item);
	}
	
	public static void main(String [] args)
	{
		   //for jump serach the array must be already in sorted order
           int A[] = {1,3,4,7,8,9,12,14,48,56,69,70};	
           System.out.println(jumpSerach(A,A.length,14));		   
	}
}