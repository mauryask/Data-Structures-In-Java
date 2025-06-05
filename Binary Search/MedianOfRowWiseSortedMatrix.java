import static java.lang.System.*;
import java.util.*;

public class MedianOfRwoWiseSortedMatrix {
	static int bestApproach(int[][] A){
		int m = A.length;
		int n = A[0].length;
		//Handle base case
		if(m*n == 1) return A[0][0];
		
	}
	
	//Approach-01: Brute force approach O(mn * log (m*n)) & O(m*n)
	
	//Approach-02: Using min headp
	// T(n) : O((m*n/2) * log m): Since we are pushing half of the elements only
	// S(n) : O(m): At any time we are goinf to have 'm' elements only in the min-heap
	static int findMedian2(int[][] A){
       int m = A.length;
	   int n = A[0].length;
       //Handle edge case : else below will not work
       if(m*n == 1) return A[0][0];
       //The position of median element
	   int count = (m*n+1)/2;
	   int m2=-1, m1=-1;
	   Queue<int[]> q = new PriorityQueue<>((a, b)->a[0]-b[0]);
	   //Push all the elements of the first column into min-heap
	   for(int i=0; i<m; i++)
		   q.add(new int[]{A[i][0],i,0});
	   
	   while(!q.isEmpty() && count-->=0){
		   int[] top = q.poll();
		   int num = top[0];
		   int row = top[1];
		   int col = top[2];
		   
		   m2 = m1;
		   m1 = num;		   
		   //Push next smallest element into min-heap
		   if(col+1 < n)
		    q.add(new int[]{A[row][col+1], row, col+1});
	   }
	   
	   if((m*n)%2==0) return (m1+m2)/2;	   
	   return m2;
	}
	
    public static void main(String[] args) {
	   int[][] A = {{9}};
	   // {{1, 3, 5, 8},
				  // {2, 6, 9, 10},
				  // {3, 6, 9, 11}};
	   out.println("\n"+findMedian(A));
    }
}