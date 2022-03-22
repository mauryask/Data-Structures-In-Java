/*
* T(n) : O(n) 
* S(n) : O(n) 
*/
import static java.lang.System.*;
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

public class MaxSumPathBetweenAnyTwoNodesInBinaryTree
{
	// overall max sum path value
	static int maxPathSum = 0;
	
	static int findMaxPathSum(Node root)
	{
		if(root == null)
			return 0;
		
		// max path sum from left subtree
		int lSum = findMaxPathSum(root.left);
		// max path sum from right subtree
		int rSum = findMaxPathSum(root.right);
		
		// max path that passes through left or 
		// right sub tree
		int pathSum1 = Math.max(lSum, rSum) + root.data;
		// max path that exists within the subtree itself
		int pathSum2 = lSum+rSum+root.data;
		// pick max of the two to upate the overall max path sum
		int ans  = Math.max(pathSum1, pathSum2);
		// update overall max sum path
		maxPathSum = Math.max(maxPathSum, ans);
		// return max path sum from this sub tree
		return Math.max(Math.max(lSum, rSum) + root.data , root.data);
	}
	
	  public static void main(String [] args)
		{		
			  Node root = new Node(1);
			  Node r2 = new Node(2);
			  Node r3 = new Node(-3);
			  Node r4 = new Node(4);
			  Node r5 = new Node(5);
			  Node r6 = new Node(-12);
			  Node r7 = new Node(-7);
			  Node r8 = new Node(8);
			  
			  root.left = r2;
			  root.right = r3;
			  r2.left = r4;
			  r2.right = r5;
			  r3.left = r6;
			  r3.right = r7;
			  r4.right = r8;
			  
              findMaxPathSum(root);
			  out.println("Max path sum: "+ maxPathSum);
		}
}
