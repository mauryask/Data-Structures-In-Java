// T(n): O(log n)
// S(n) : O(1)

import static java.lang.System.*;
import java.util.*;

public class FindSquareRootOfAumber{
	static int findSquareRoot(int x){
		int start = 1;
		int end = x;
		int result = -1;
		
		while(start <= end){
			int mid = start + (end - start) / 2;
			int power = mid * mid;
			
			if(power == x){
				return mid;
			}else if(power < x){
				result = mid;
				start = mid +1;
			}else{
				end = mid -1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		int x = 11;
        out.println(findSquareRoot(x));		
	}
}