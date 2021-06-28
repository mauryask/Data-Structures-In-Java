/**
Time complexity: O(n)
Space complexity: O(n)
*/

import java.util.*;

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
	static int findLevelOfMaxSum(Node root)
	{
		int level = 0;
		int maxLevel = 0;
		int maxSum = 0;
		int currentSum = 0;
		
		List<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			root = q.remove(0);
			if(root == null)
			{
				if(!q.isEmpty())
				 q.add(null);
			   				
				if(currentSum > maxSum)
				{
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
			}
			else
			{
				currentSum += root.data;
				if(root.left != null)
					q.add(root.left);
				if(root.right != null)
					q.add(root.right);
			}
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
		  
		  System.out.println(findLevelOfMaxSum(root));
		}
}
