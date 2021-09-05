// Queation Number : #10

// Triplest Sum Problem 

import static java.lang.System.*;
import java.util.*;

public class TripletSum
{
  public static void main(String [] args)
  {
	  int A[] = {12, 3, 4, 1, 6, 9};
	  int target = 24;
	  out.println(solve2(A, target));//findTriplets(A, target);
  }  
  
    
  // Time Complexity  : O(n^3)
  // Space Complexity : O(1)
  
  static boolean solve2(int A[], int target)
  {
	  int n = A.length;
	  int sum = 0;
	  for(int i=0;i<n;i++)
	  {
		  for(int j=i+1;j<n;j++)
		  {
			  for(int k=j+1;k<n;k++)
			  {
				  int x = A[i]; 
				  int y = A[j];
				  int z = A[k];
				  
				  if(x+y+z == target)
					  return true;
			  }
		  }
	  }
	  return false;
  }
  
  // Time Complexity  : O(n^2)
  // Space Complexity : O(1)
  static boolean solve(int A[], int target)
  {
	  int n = A.length;
	  Arrays.sort(A);
	 
	  int left = 0;
	  int right = 0;
	  int sum = 0;
	  
	  for(int i=n-1; i>=2; i--)
	  {
		  left = 0;
		  right = i-1;
		  while(left < right)
		  {
			 sum =  A[left] + A[right] + A[i];
		     if(sum == target)
			   return true;
		     else if(sum < target)
				 left++;
			 else
				 right--;
		  }
	 }
	 return false;
  }
}
