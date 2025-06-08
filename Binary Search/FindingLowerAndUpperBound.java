/*
Lower bound: The smallest index for which A[index] >= x
Upper bound: The smllest index for which A[index] > x
*/

import static java.lang.System.*;

public class FindingLowerAndUpperBound{
    static int findLowerBound(int[] A, int x){
		int start = 0;
		int end = A.length-1;
		//If there is no such element then the Array length will be the lower bound
		int result = A.length; 

		while(start <= end){
			int mid = start + (end - start) / 2;
			//For upper bound
			/*
			  if(A[mid] > x){
			    result = x;
				end = mid - 1;
			  }
			*/
			if(A[mid] >= x){
				result = mid;
				end = mid  -1;
			}else{
				start = mid + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		int x = 1;
		int[] A = {1,2,3,3,5,8,8,10,10,11};
		out.println(findLowerBound(A, x));
	}
}