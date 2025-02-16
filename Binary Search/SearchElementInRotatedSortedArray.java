/*
* Time compelxity  : O(log n)
* Space complexity : O(1)
 */

public class SearchElementInRotatedSortedArray {

    static int search(int[] A, int target) {
        int n = A.length;

        if (n == 0) {
            return -1;
        }

        int pivotIndex = getPivotIndex(A, n);

        if (pivotIndex == 0) {
            return binarySearch(A, 0, n - 1, target); 
        }else {
            int result1 = binarySearch(A, 0, pivotIndex - 1, target);
            if (result1 != -1) {
                return result1;
            }
            return binarySearch(A, pivotIndex, n - 1, target);
        }
    }

    static int getPivotIndex(int[] A, int n) {
        int start = 0;
        int end = n - 1;

        if (A[start] <= A[end]) {
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && A[mid] < A[mid - 1]) {
                return mid;
            }

            if (mid < n - 1 && A[mid + 1] < A[mid]) {
                return mid + 1;
            }

            if (A[mid] >= A[start]) {
                start = mid + 1;
            } else if (A[mid] < A[end]) {
                end = mid - 1;
            }
        }

        return 0;
    }

    static int binarySearch(int[] A, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {20, 22, 24, 26, 28, 30, 32, 34, 36, 10, 12, 14, 16, 18};        
        int target = 14; 
		System.out.println(search(A, target));      
    }
}
