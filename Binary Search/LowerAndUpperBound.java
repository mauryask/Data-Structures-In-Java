/*
** The position is sorted list of number to insert the given 
target value while maintaining the sorted order of the elements
** Lower bound: The smallest index for which A[index] >= x
** Upper bound: The smallest index for which A[index] > x : 
[Generally after the last occurrance of the target (if any)]
*/

import static java.lang.System.*;

public class LowerAndUpperBound{
	static int lowerBound(int[] A, int target){
		int start = 0;
		int end = A.length-1;
		
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(A[mid] < target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		
		return start;
	}
	
	static int upperBound(int[] A, int target){
		int start = 0;
		int end = A.length-1;
		
		while(start <= end){
			int mid = start + (end - start) / 2;
			//Checking equal as well cause we need to skip the elements that are equal to the target
			if(A[mid] <= target){
				start = mid + 1;
			}else{
				end = mid -1;
			}
		}
		
		return start;
	}
	
	public static void main(String[] args){
		int target = 8;
		int[] A = {1,2,3,3,5,8,8,10,10,11};
		out.println(lowerBound(A, target));
		out.println(upperBound(A, target));
	}
}