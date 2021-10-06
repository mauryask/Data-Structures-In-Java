import static java.lang.System.*;
import java.util.*;

public class MinJumpToReachArrayEnd
{
    static int minJumps(int A[], int n)
    {
        /*
        * This array holds the minimum number 
        * of jumps needed to reach i from 0
        */
        int minJump[] = new int[n];
        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0;
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(i <= j+ A[j])
                {
                    minJump[i] = Math.min(minJump[i], minJump[j] + 1);
                }
            }
        }
        
        return minJump[n-1];
    }
    
  	public static void main(String [] args)
    {
        int A[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = A.length;
        
        out.println(minJumps(A, n));
    }
}