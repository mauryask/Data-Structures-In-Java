// T(n) : O(n * log(max - min))
// S(n) : O(1)
import static java.lang.System.*;
import java.util.*;

public class AggresiveCows{
	static boolean canPlaceCows(int[] A, int minAllowedDist, int k){
	   //Placing first cow on the first position
	   int cow = 1;
	   //Last cow position
       int lastPosition = A[0]; 	   
	   
	   for(int i=1; i<A.length; i++){
		   //Check for valid distances: if found, Place the current cow overthere and move to the next
		   if(A[i] - lastPosition >= minAllowedDist){
			   cow++;
			   lastPosition = A[i];
			   //If all the cows placed successfully return true
			   if(cow >= k)
				  return true;
		   }
	   }	   
	   return false;
	} 
	
	static int aggressiveCows(int[] A, int k){
		//Sinces distances might be unsorted so sort it
		Arrays.sort(A);
		//Define the seaech space
		int start = 1; //Smallest possible distance between 2 cows
		int end = A[A.length-1] - A[0]; //Largest possible distances between 2 cows 
		int ans = 0;
		
		while(start <= end){
			int mid = start + (end - start)/2;
			//If cows can be places with minAllowedDist (mid): Store it as potential answer But we need to maximize the minDist move start pointer to right as below
			if(canPlaceCows(A, mid, k)){
				ans = mid;
				start = mid +1;
			}else{ //If all cows can not be places move to left in the search space
				end = mid-1 ;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		int[] A = {6, 7,  9, 11, 13, 15};
		int k = 4;
		int minDist = aggressiveCows(A, k);
		out.println(minDist);
	}
}