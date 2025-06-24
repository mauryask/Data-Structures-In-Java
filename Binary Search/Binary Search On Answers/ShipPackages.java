//https://www.geeksforgeeks.org/dsa/capacity-to-ship-packages-within-d-days/
import static java.lang.System.*;
import java.util.*;

public class ShipPackages{
	//Bruteforce approach
	//T(n): O((sum-max) * n)
	//S(n) : O(1)
	static int getDays(int[] packages, int minCapacity){	  
	   int days = 1;
	   //Initial weight
       int totalWeight = 0;

       for(int weight : packages){		  		   
	       //if the taking next packges does not exceeds the minCapacity then take it on the same day
		   if(totalWeight + weight <= minCapacity){
			   totalWeight += weight;
		   }else{
			   //Else Ship this packages on the next day
			   days++;
			   totalWeight = weight;
		   }
	   }
       //Noe: Max number days could be in worst case number of elements in the packages array (f only one packaes can be accomodated in the ship: and ship capacityb taken as max package weight)      
	   //So there is no case where all the package can not be shifted
       return days;  
	}
	
	
	static int getMinCapacity(int[] packages, int D){
		//The min alowed ship capacity should be te max weight of the packages (So that all the packages can be shiped independently)
		int start = Arrays.stream(packages).max().getAsInt();
		//Max allowed boat capacity is the sum of weights of packages (When all the packges shiped at onece)
		int end = Arrays.stream(packages).sum();
		
		for(int i = start; i <= end; i++){
			//Get the rquired days to ship all the packages if minAllopwed ship capacity is 'i'
			int daysRequired = getDays(packages, i);
			//If all packges can we shift within given number of 'D' 
			if(daysRequired <= D){
				return i;
			}
		}
		//If it is not possible to ship all the packges in D days
		return -1;
	}
	
	//Best approach: Binary Search 
	//T(n): O(N * log(sum - max))
	static int bestSolution(int[] packages, int D){
		//Define search space 
		int start = 0;
		int end = 0;
		int ans = 0;
		
		for(int weight : packages){
			end += weight;
			start = Math.max(start, weight);
		}
		
		while(start <= end){
			int mid = start + (end - start) / 2;
			int requiredDays = getDays(packages, mid);
			//If required days less or equal to 'D': This coould be possible ans: Go for smaller capacity
			if(requiredDays <= D){
				ans = mid;
				end = mid - 1;
			}else{
				//If numbe of days rquired more than the given 'D': Increase the capacity of the ship to accomodate more packages in a single day
				start = mid + 1;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		int[] packages = {17, 20, 2, 17, 10, 4, 20, 15, 1, 3, 9, 15};
		int D = 12;
		// int ans = getMinCapacity(packages, D);
		int ans = bestSolution(packages, D);
		out.println(ans);
	}
}
