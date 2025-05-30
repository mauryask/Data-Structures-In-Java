/*
* Time complexity  : O(log n)
* Space complexity : O(1)
* Note: Here array has distinct elements
 */
import static java.lang.System.*;

public class CountRotationsInRotatedSortedArrayWithDistinctElements {
    
	static int bestSoution(int[] A){
		int n = A.length;
		
		if(n == 1)
			return 0;
		
		int left = 0;
		int right = n-1;
		
		if(A[left] < A[right])
			return 0;
		
		while(left < right){
			int mid = left + (right - left) / 2;
			// In this case the min element will be at the right of the mid
			if(A[mid] > A[right])
				left = mid + 1;
/*
Why Not right = mid - 1?
When nums[mid] <= nums[right], it indicates that the right half of the array (from mid to right) is sorted in ascending order. This means the minimum element cannot be in the range (mid, right] (i.e., after mid up to right), because all elements in that range are greater than or equal to nums[mid]. However, nums[mid] itself could be the minimum, so we must include the mid index in the next iteration of the search. Setting right = mid - 1 would exclude nums[mid], which could lead to missing the minimum element.
*/
			else //A[mid] <= A[rigth]
				right = mid;
		}
		
		return left;
	}
	
	//Good but not the best solution
    static int getRotationCount(int A[]) {
        int n = A.length;
        int left = 0;
        int right = n - 1;

        // If the array is not rotated 
        // This handles the case when there is only one element e.g. {12}
        if (A[left] <= A[right]) {
            return 0;
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // check if (mid+1) is min element
            if (mid < n - 1 && A[mid + 1] < A[mid]) {
                return mid + 1;
            }// check if mid itself is min element

            if (mid > 0 && A[mid] < A[mid - 1]) {
                return mid;
            }

            /*
			* Deciding which subarray to 
			* take either left or right
             */
 /*
			* If left subarray is already sorted
			* take right subarray
			* since the min element 
			* might be present there
             */
            if (A[mid] > A[left]) {
                left = mid + 1;
            }/*
			* If right subarray is already sorted
			* take left subarray
			* since the min element 
			* might be present there*/
            else{
                right = mid - 1;
            }
        }

        return 0;
    }

    //O(n)
    static int bruteForce(int A[]) {
        int n = A.length;
        if (n == 0 || n == 1) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                result = i + 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int A[] = {-2, -1, -5, -4, -3};
		// {20,22,24,26,28,30,32,34,36,10,12,14,16,18};    
        // out.println(getRotationCount(A));
        out.println(bestSoution(A));
        // out.println(bruteForce(A));
    }
}
