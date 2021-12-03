/*
* T(n) : O(n*n)
* S(n) : O(n)
********
// element at each index reprseents the 
// length of the jump you can take
https://leetcode.com/problems/jump-game/
*/

import static java.lang.System.*;
import java.util.*;

public class MinJumpToReachArrayEnd
{
   
  // Bruteforce Solution
  // T(n): O(n*n)
  // S(n) : O(1)
  // consider all the position where we can reach from 
  // the current position
  
   static int minJump = Integer.MAX_VALUE;
  
   static int solve(int[]  A, int n,int start)
   {
       if(start >= n)
           return Integer.MAX_VALUE;
       
       if(start == n-1)
           return 0;

      int jumpSize = start + A[start];
           
      for(int j = start+1; j<= jumpSize ; j++)
        minJump = Math.min(minJump, solve(A, n, j));
    
       return minJump == Integer.MAX_VALUE ? minJump : minJump+1;
   }
    
    // Dp solution
    static int minJumps(int A[], int n)
    {
        /*
        * This array holds the minimum number 
        * of jumps needed to reach location 'i' from '0'
        */
        int minJump[] = new int[n];
        int jumpPath[] = new int[n];
        
        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0;
        jumpPath[0] = -1;
        
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                // j+A[j], is nothing but the
                // farthest index that can be reached
                // from j
                if(i <= j+ A[j])
                {
                    if(minJump[i] >= minJump[j] + 1)
                    {
                         minJump[i] = minJump[j] + 1;
                         jumpPath[i] = j;
                    }
                }
            }
        }
        
        // if end is not reachable
        if(minJump[n-1] == Integer.MAX_VALUE)
            return -1;
        else // if end is reachable
        {
            printPath(jumpPath, n);
            return minJump[n-1];
        }
    }
    
    static void printPath(int[] jumpPath, int n)
    {
        int temp = n-1;
        List<Integer> list = new LinkedList<>();
        
        while(jumpPath[temp] != -1)
        {
            list.add(0, temp);
            temp = jumpPath[temp];
        }
        out.println("Path followed to reach the end: ");
        list.add(0,0);
        for(int x : list)
            out.print(x+" ");
        out.println();
    }
    
  	public static void main(String [] args)
    {
        int A[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
            //{2,3,1,1,4};
        //{3,2,1,0,4};// this the case when you can't reach end
        int n = A.length;
        
        out.println("Minimum jumps needed: "+minJumps(A, n));
        //out.println(solve(A, n, 0));
    }
}