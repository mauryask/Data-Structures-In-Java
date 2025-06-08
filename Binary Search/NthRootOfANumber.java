import static java.lang.System.*;
import java.util.*;

public class NthRootOfANumber{
	static long findNthRootHelper(int num, int n){
	   	long res = 1L;
		//Multiplying num n times
		while(n-->0)
		  res *= num;
		return res;  
	}
	
	//T(n) : O(x*n)
	static long findNthRoot(int x, int n){
	  if(n == 0 /*Divide by 0 error*/ || x < 0/*nth root will be imaginary number*/)
		  return -1;
	  //If x is negative y = X^+n number
	  if(n < 0) return findNthRootHelper(x, -1*n);
	  
	  if(x == 0) return 0;
		  
	  //Checking for each 'i' : if i^n == x
	  for(int i=1; i<=x; i++){
		  long result = findNthRootHelper(i, n);		  		  
		  if(result == x)
			  return i;
		  // If below condition met then no nth root exists for the x
		  else if(result > x)
			break;
	  }
	  return -1;
	}
	
	public static void main(String[] arg){
		int x = 27;
		int n = 3;
		long result = findNthRoot(x, n);
		out.println(result);
	}
}