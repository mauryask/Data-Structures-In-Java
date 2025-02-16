/*
* Time complexity  : O(log n)
* Space complexity : O(1)
 */
import static java.lang.System.*;

public class SearchInBitonoicArray {

    static int getElement(int A[], int target) {
        if (A.length == 0) {
            return -1;
        }

        int peekIndex = getPeekElementIndex(A);

        int lSub = binarySearch(A, 0, peekIndex, target, true);
        return lSub == -1 ? binarySearch(A, peekIndex + 1, A.length - 1, target, false) : lSub;
    }

    static int binarySearch(int A[], int start,
            int end, int target, boolean flag) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] > target) {
                if (flag) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (A[mid] < target) {
                if (flag) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    static int getPeekElementIndex(int A[]) {
        int n = A.length;

        if (n == 1) {
            return 0;
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < n - 1) {
                if (A[mid + 1] < A[mid] && A[mid] > A[mid - 1]) {
                    return mid;
                } else if (A[mid + 1] > A[mid]) {
                    start = mid + 1;
                } else {
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
        int A[] = {8, 10, 100, 200, 400, 500, 3, 2, 1};//{1, 3, 8, 12, 14, 16, 18, 24, 26, 10, 9, 7, 6, 5};
        int target = 100;
        out.println(getElement(A, target));
    }
}
