// return index of the min diff element

import static java.lang.System.*;

public class FindingMinimumDifferenceElementForTheGivenKey {

    static int getMinDiffElement(int A[], int key) {
        int n = A.length;

        if (n == 0) {
            return -1;
        }

        int start = 0;
        int end = n - 1;
        int ceil = -1;
        int floor = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == key) {
                return key;
            } else if (A[mid] < key) {
                floor = A[mid];
                start = mid + 1;
            } else if (A[mid] > key) {
                ceil = A[mid];
                end = mid - 1;
            }
        }

        if (floor == -1 && ceil != -1) {
            return ceil;
        } else if (floor != -1 && ceil == -1) {
            return floor;
        } else {
            return (Math.abs(floor - key) < Math.abs(ceil - key)) ? floor : ceil;
        }
    }

    public static void main(String[] args) {
        int A[] = {15, 20, 25, 63, 95, 100, 102, 115, 140};
        int key = 98;
        out.println(getMinDiffElement(A, key));
    }
}
