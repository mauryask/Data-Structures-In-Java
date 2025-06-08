import static java.lang.System.*;
import java.util.*;

public class NthRootOfANumber{
	//T(n) : O(log n) on base 2
	static int bestApproachtofindThePower(int num, int n){
		if(n == 0)
		  return 1;
	     
		if(n%2==0)
			return bestApproachtofindThePower(num*num, n/2);
		else 
			return num * bestApproachtofindThePower(num*num, (n-1)/2);
	}
	
	//T(n): O(n)
	static long findNthRootHelper(int num, int n){
		long res = 1L;
		//Multiplying num n times
		while(n-->0)
		  res *= num;
		return res;  
	}
	
	//T(n) : O(x * log n)
	static long findNthRoot(int x, int n){
	  if(n == 0 /*Divide by 0 error*/ || x < 0/*nth root will be imaginary number*/)
		  return -1;
	  //If x is negative y = X^+n number
	  if(n < 0) return findNthRootHelper(x, -1*n);
	  
	  if(x == 0) return 0;
		  
	  //Checking for each 'i' : if i^n == x
	  for(int i=1; i<=x; i++){
		  long result = bestApproachtofindThePower(i, n);		  		  
		  if(result == x)
			  return i;
		  // If below condition met then no nth root exists for the x
		  else if(result > x)
			break;
	  }
	  return -1;
	}
	
	//Using binary search
	static int bestApproach(int x, int n){
	  if(n == 0 /*Divide by 0 error*/ || x < 0/*nth root will be imaginary number*/)
		  return -1;
	  //If x is negative y = X^+n number
	  if(n < 0) return bestApproachtofindThePower(x, -1*n);
	  
	  if(x == 0) return 0;
	  
		//Define the search space
		int start = 1;
		int end = x;
		
		while(start <= end){
			int mid = start + (end - start) / 2;
			int power = bestApproachtofindThePower(mid, n);
			
			if(power == x)
				return mid;
			else if(power > x)
				end = mid - 1;
			else 
				start = mid + 1;
		}
		
		return -1;
	}

	public static void main(String[] arg){
		int x = 27;
		int n = 3;
	    long result = bestApproach(x, n);
		out.println(result);
	}
}