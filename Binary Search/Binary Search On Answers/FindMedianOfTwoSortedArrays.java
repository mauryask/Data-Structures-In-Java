// T(n) : O(log(min(m, n))), T(n) = O(log n) : in case of arrays of same length
// S(n) : O(1)

import static java.lang.System.*;
import java.util.*;

public class FindMedianOfTwoSortedArrays{
	//Best approach
	static int findMedian(int[] A, int[] B){
		int m = A.length;
		int n = B.length;
		
		if(m > n) return findMedianApproach1(B, A);
		
		int left = 0;
		int right = m;
		
		while(left <= right){
			int mid1 = left+(right-left)/2;
			int mid2 = (m+n+1)/2-mid1;
            
			int l1 = (mid1 == 0) ? Integer.MIN_VALUE : A[mid1-1];
			int r1 = (mid1 == m) ? Integer.MAX_VALUE : A[mid1];
			int l2 = (mid2 == 0) ? Integer.MIN_VALUE : B[mid2-1];
			int r2 = (mid2 == n) ? Integer.MAX_VALUE : B[mid2];
			
			
            if(l1<=r2 && l2<=r1){
				boolean isEven = (m+n)%2 == 0;
				if(isEven)
					return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
				else
					return Math.max(l1, l2);
			}			
			
			//The idea is to maintain the first of the sorted array and second half of the sorted array			
			if(l1 > r2){
                right = mid1 - 1;				
			}else{ //l2 > r1
				left = mid1 + 1;
			}
		}
		
		return -1;
	}
	
	//T(n) : O(m+n)
	//S(n) : O(1)
	static int findMedianApproach1(int[] A, int[ ] B){
		int m = A.length;
		int n = B.length;		
		boolean isEven = (m+n)%2==0;
		int m1 = -1;
		int m2 = -1;
		int i=0, j=0;
		
        //this handles both odd and even length cases		
		for(int count=1; count<=(m+n+1)/2; count++){
		   m2 = m1;
           
           if(i != m && j != n)
			   m1 = A[i] > B[j] ? B[j++] : A[i++];
           else if(i < m)
               m1  = A[i++];
		   else 
               m1 = B[j++];			   
		}
		
		if(isEven) return (m1+m2) / 2;
		
		return m1;
	}
	
	// T(n) : O((m+n)log(m+n))
	// S(n) : O(m+n)
	static int findMedianApproach2(int[] A, int[] B){
		int m = A.length;
		int n = B.length;
		int k = m+n;
		int[] C = new int[k];
		int index = 0;
		
		for(int i=0; i<m; i++)
			C[index++] = A[i];
		
		for(int j=0; j<n; j++)
			C[index++] = B[j];
		
		Arrays.sort(C);
		
		boolean isEven = k%2==0;
		//for even: (n/2) + (n/2)+1 / 2 > for n sorted elements
		//for odd: (n+1)/2
		if(isEven)
			return (C[k/2-1] + C[k/2])/2;
		else
			return C[(k-1)/2];
	}
	
    public static void main(String[] args) {
	   int[] A = {-5, 3, 6, 12, 15};
	   int[] B = {-12, -10, -6, -3, 4, 10};
	   //Since we will be applying the binary search on array with smaller length (hence pass like below findMedian(smaller_array, larger_array))
	   // int median = findMedian(A, B);
	   int median = findMedianApproach1(A, B);
	   out.println(median);
    }
}