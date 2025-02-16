/*
* Time complexity  : O(log n)
* Space complexity : O(1)
 */
import static java.lang.System.*;

public class CountRotationsInRotatedSortedArray {

    static int getRotationCount(int A[]) {
        int n = A.length;
        int start = 0;
        int end = n - 1;

        // If the array is not rotated 
        // This handles the case when there is only one element e.g. {12}
        if (A[start] <= A[end]) {
            return 0;
        }

        while (start <= end) {

            int mid = start + (end - start) / 2;

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
            if (A[mid] >= A[start]) {
                start = mid + 1;
            }/*
			* If right subarray is already sorted
			* take left subarray
			* since the min element 
			* might be present there
             */ else if (A[mid] < A[end]) {
                end = mid - 1;
            }
        }

        return 0;
    }

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
        int A[] = {-2, -1, -5, -4, -3};//{20,22,24,26,28,30,32,34,36,10,12,14,16,18};    
        out.println(getRotationCount(A));
        // out.println(bruteForce(A));
    }
}
