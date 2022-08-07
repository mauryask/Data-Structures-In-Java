/**
Time complexity: O(n)
Space complexity: O(n)
*/

import java.util.*;
import static java.lang.System.*;

class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

public class FindLevelWithMaxSum
{
	//Best method without putting null in the queue
	
	static int getMaxSumLevel(Node root)
	{
		if(root == null)
            return 0;
		
		int maxSum = 0;
		int level = 0;
		int maxLevel = 0;
		
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
         
        while(!q.isEmpty())
		{
			int count = q.size();
			int sum = 0;	

			while(count-->0)
			{				
				root = q.poll();
				
				sum += root.data;
				
				if(root.left != null)
					q.add(root.left);
				if(root.right != null)
					q.add(root.right);							
			}
			
			if(maxSum < sum)
			{
				maxSum = sum;
				maxLevel = level;
			}
			
			level++;
		}

        return maxLevel;		
	}
	
	static int findLevelOfMaxSum(Node root)
	{
		int level = 0;
		int maxLevel = 0;
		int maxSum = 0;
		int currentSum = 0;
		
		LinkedList<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			root = q.removeFirst();
			
			if(root == null)
			{
				if(!q.isEmpty())
				 q.add(null);
			   				
				if(currentSum > maxSum)
				{
					out.println(level);
					maxSum = currentSum;
					maxLevel = level;
				}
				
				// put it here as the level starts with zero
				// you can put it above the condition
				// if u are taking root node at level 0
				// nothin wrong with that
				level++; 
				// you have to make current sum 0 here
				// after the end of each level 
				// there should be a new sum
				currentSum = 0;
				continue;
			}
						
				if(root.left != null)
					q.add(root.left);
				if(root.right != null)
					q.add(root.right);			
			
		  currentSum += root.data;
		}
		return maxLevel;
	}
	
	  public static void main(String [] args)
		{
		
		  Node root = new Node(1);
		  Node r2 = new Node(2);
		  Node r3 = new Node(3);
		  Node r4 = new Node(4);
		  Node r5 = new Node(5);
		  Node r6 = new Node(6);
		  Node r7 = new Node(7);
		  Node r8 = new Node(8);
		  Node r9 = new Node(9);
		  Node r10 = new Node(10);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;	  
		  r4.left = r8;
		  r4.right = r9;
		  r5.left = r10;
		  
		 //System.out.println(findLevelOfMaxSum(root));
		  System.out.println(getMaxSumLevel(root));
		}
}
