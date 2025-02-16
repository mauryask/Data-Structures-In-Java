/*
* Time complexity  : O(log n)
* Space compelxity : O(1)
 */

import static java.lang.System.*;

public class FindPeakElement {

    static int getPeakElement(int A[]) {
        int n = A.length;

        if (n == 0) {
            return -1;
        }

        if (n == 1) {
            return A[0];
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < n - 1) {
                if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                    return A[mid];
                } else if (A[mid] < A[mid + 1]) {
                    start = mid + 1;
                } else if (A[mid - 1] > A[mid]) {
                    end = mid - 1;
                }
            } else if (mid == 0) { //The conditions below handle this case very well {1,2}
                if (A[mid] > A[mid + 1]) {
                    return A[mid];
                } else {
                    start = mid + 1;
                }
            } else if (mid == n - 1) {
                if (A[mid] > A[mid - 1]) {
                    return A[mid];
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {1, 2};//{1,2,4,5,7,8,3};//{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        out.println(getPeakElement(A));
    }
}
