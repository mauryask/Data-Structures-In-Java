// Queation Number : #6

import java.io.*;
import java.util.stream.*;
import java.util.*;
public class PairsWithGivenSum
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A[] =  Stream.of(br.readLine().split(" "))
		.mapToInt(Integer::parseInt)
		.toArray();
		
		int num =  Integer.parseInt(br.readLine());
		
		Arrays.sort(A);
			
		System.out.println();
	    solve(A, num);
	
	}
	
	static void solve(int A[], int num)
	{
		int l = 0;
		int r = A.length -1;
		
		while(l < r)
		{
			int sum = A[l] + A[r];
			if(sum == num)
			{
				System.out.println(l+" "+r);
				l++;
				r--;
			}
			else if(sum < num)
			{
				l++;
			}
            else if(sum > num)
			{
				r--;
			}				
		}
	}
}