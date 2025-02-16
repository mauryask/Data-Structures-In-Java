/*
* Time complexity  : O(log n)
* Space complexity : O(1)
 */

import static java.lang.System.*;

public class FindFirstAndLastOcuuranceOfAnElement {

    static int getFirstOccurrance(int A[], int target) {
        int start = 0;
        int end = A.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                result = mid; //This could be the possible candidate
                end = mid - 1;
            } else if(A[mid] < target){
                start = mid + 1;
            }else{
				end = mid - 1;
			}
        }

        return result;
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 5, 10, 10, 10, 10, 12, 13, 14, 15, 16};
        out.println(getFirstOccurrance(A, 10));
    }
}
