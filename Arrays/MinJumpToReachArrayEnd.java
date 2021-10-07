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
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(i <= j+ A[j])
                {
                    if(minJump[i] > minJump[j] + 1)
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
        for(int x : list)
            out.print(x+" ");
        out.println();
    }
    
  	public static void main(String [] args)
    {
        int A[] = //{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
         {3,2,1,0,4};// this the case when you can't reach end
        int n = A.length;
        
        out.println("Minimum jumps needed: "+minJumps(A, n));
    }
}