/*
* Time complexity  : O(log n)
* Space complexity : O(1)
 */

import static java.lang.System.*;

public class FindFirst1InInfiniteBinarySortedArray {

    static int getIndexOfFirstOne(int A[]) {
        if (A[0] == 1) {
            return 0;
        }
        int index = 1;
        while (A[index] < 1) {
            index *= 2;
        }

        return binarySearch(A, index / 2, index);
    }

    static int binarySearch(int A[], int index, int end) {
        int result = -1;

        while (index <= end) {
            int mid = index + (end - index) / 2;

            if (A[mid] == 1) {
                result = mid;
                end = mid - 1;
            } else if (A[mid] < 1) {
                index = mid + 1;
            }
            /*
            ** This condition is not required as A[mid] will never be greater than 1
            else{
                index = mid - 1;
            }            
            **/
        }

        return result;
    }

    public static void main(String[] args) {
        int A[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        out.println(getIndexOfFirstOne(A));
    }
}
