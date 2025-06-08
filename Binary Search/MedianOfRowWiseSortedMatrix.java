// T(n) : O(n * log(m) * log(maxVal - minVal))
// S(n) : O(1)
// Note: Here maxVal - minVal  => Total number of elements in the range (search space)
import static java.lang.System.*;
import java.util.*;

public class MedianOfRowWiseSortedMatrix {
    //Finding upperbound of the given taregt: start will give how many elemnts are >= of the given target value
    //T(n) : O(log n)
    static int getCountUtil(int[] mat, int target){
        int start = 0;
        int end = mat.length-1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(mat[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return start;
    }
    
    //T(n) : O(m * log n)
     static int getCount(int[][] mat, int target){
        int count = 0;
        //Applying binary search on each row        
        for(int i=0; i<mat.length; i++){
            count += getCountUtil(mat[i], target);
        }
        
        return count;
    }
    
    static int bestApproach(int mat[][]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int m = mat.length; //Rows
        int n = mat[0].length; //Columns

        //Finding min and max values from first and last columns respectively        
        //T(n) : O(m)
        for(int i=0; i<m; i++){
            min = Math.min(mat[i][0], min);
            max = Math.max(mat[i][n-1], max);
        }
        
        int start = min;
        int end = max;
        
        //reqCount-th: This will be the piossible median
        int reqCount = (m*n)/2;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            //Finding how many elements less than or equal to mid in the matrix
            int count = getCount(mat, mid); 
            //We need count just greater than the reqCount
            if(count <= reqCount){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return start;
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
	   int[][] A =// {{9}};
	    {{1, 3, 5},
		{2, 6, 9},
		{3, 6, 9}};
	   out.println("\n"+bestApproach(A));
    }
}