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

public class MaxSumPathBetweenTwoLeafNodesInBinaryTree
{
	// overall max sum path value
	static int maxPathSum = 0;
	
	static int findMaxPathSum(Node root)
	{
		if(root == null)
			return 0;
		
		int lSum = findMaxPathSum(root.left);
		int rSum = findMaxPathSum(root.right);

		// because here we are interested in max 
		// sum path between any two leaf nodes
		// not between any two nodes
		maxPathSum =  Math.max(maxPathSum, lSum+rSum+root.data);
        // return max sum path from this sub tree
		return Math.max(lSum, rSum) + root.data;
	}
	
	  public static void main(String [] args)
		{		
			  Node root = new Node(1);
			  Node r2 = new Node(2);
			  Node r3 = new Node(3);
			  Node r4 = new Node(4);
			  Node r5 = new Node(5);
			  Node r6 = new Node(12);
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
