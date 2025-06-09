//T(n): O(n * log(max))
//S(n) : O(1)

import static java.lang.System.*;

public class KoKoEatingBananas{
	static int getMaxElement(int[] piles){
	   int max = 0;
	   for(int x : piles){
		   if(max < x) max = x;
	   }
	   return max;
	}
	
	static long getTimeToEatAllThePiles(int[] piles, int k){
		long time = 0;
		for(int x : piles){
			//Below approach is significantly slower due to floating point arithmetic
			//total += Math.ceil((x/(double)k))
			
			//This approach uses integer arithmetic to find ceil divison efficiently: makes program significantly faster
			//See the prrof at the end
			time += (x+k-1)/k; 
		}
		
		return time;
	}
	
	static int minEatingSpeed(int[] piles, int h){
	  	//Define search space
		int start = 1;		
		int end = getMaxElement(piles);
		int ans = -1;
		
		while(start <= end){
			int mid = start + (end - start) / 2;			
	        //Calculting total time take to eat all the bananas if eaten woth an speed of mid bananas per hour	
    		long time = getTimeToEatAllThePiles(piles, mid);
			// If time is less means the speed is higher shift the end pointer as below
			// Cause we are intrested in finding the minimum possible speed (number of bananas to be eatne per hour)
			if(time <= h){				
				ans = mid;
				end = mid - 1;
			}else{
				//If time is greater means speed is significanly slow: shif the start pointer as below
				start = mid +1;
			}
		}		
		return ans;
	}
	
	public static void main(String[] args){
		int[] piles = {30,11,23,4,20};
		int h = 5;
		int minSpeed = minEatingSpeed(piles, h);
		out.println(minSpeed);
	}
}

/*
** Integer Arithmetic behind ceil division
***************
https://chat.deepseek.com/a/chat/s/2cc84c87-e38b-4574-a79e-9d559473712b
*/