// T(n) : O(log n)
// S(n) : O(1)
import static java.lang.System.*;

public class FindMinInRotatedSortedArrayWithDuplicateElements{
	
	static int findMin(int[] A) {
        int left = 0;
        int right = A.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] > A[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else if (A[mid] < A[right]) {
                // Minimum is in the left half or at mid
                right = mid;
            } else {
                // A[mid] == A[right], exclude right and continue
                right--;
            }
        }
        
        return A[left];
    }
	
	public static void main(String[] args){
		int[] A = {2, 2, 2, 0, 1};
		out.println(findMin(A));
	}
}