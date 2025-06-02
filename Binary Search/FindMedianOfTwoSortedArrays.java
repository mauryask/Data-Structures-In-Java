// T(n) : O(log(min(m, n)))
// S(n) : O(1)
import static java.lang.System.*;
import java.util.*;

public class FindMedianOfTwoSortedArrays{
	
	static int findMedian(int[] A, int[] B){
		int m = A.length;
		int n = B.length;
		int left = 0;
		int right = n;
		
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
	
    public static void main(String[] args) {
	   int[] A = {-5, 3, 6, 12, 15};
	   int[] B = {-12, -10, -6, -3, 4, 10};
	   //Since we will be applying the binary search on array with smaller length (hence pass like below findMedian(smaller_array, larger_array))
	   int median = B.length < A.length ? findMedian(B, A) : findMedian(A, B);
	   out.println(median);
    }
}