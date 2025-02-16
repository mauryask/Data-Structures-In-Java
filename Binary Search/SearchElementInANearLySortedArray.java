/*
* Time complexity  : O(log n)
* Space complexity : O(1)
 */

import static java.lang.System.*;

public class SearchElementInANearLySortedArray {

    static int search(int A[], int target) {
        int n = A.length;

        if (n == 0) {
            return -1;
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //The target could be found at below three possibvle positions
            if (A[mid] == target) {
                return mid;
            } else if (mid > 0 && A[mid - 1] == target) {
                return mid - 1;
            } else if (mid < n - 1 && A[mid + 1] == target) {
                return mid + 1;
            }
            // Here why we are goinf mid + 2
			// Cause the element is at mid position its position real position could have bee
			// At mid + 1 thats why it came at mid ot mid - 1 thats why it came at mid
			// in all three case mid, mid+1, mid-1 going to be less than the target
			// Hence start = mid + 2 is right choice
            if (target > A[mid]) {
                start = mid + 2; //Cause you already have looked at (mid + 1)
            } else if (target < A[mid]) {
                end = mid - 2; //Cause you already have lokked at (mid - 1)
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {2, 8, 4, 12, 10, 16, 14, 18};
        int target = 14;
        out.println(search(A, target));
    }
}
