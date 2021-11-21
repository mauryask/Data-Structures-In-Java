/*
* T(n) : O(n) 
* S(n) : O(n)
** https://www.youtube.com/watch?v=tDx3PPwgSxs
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

public class NodeWithMaxSubTreeSum
{
	static int maxSum = 0;
	static Node maxSumNode = null;
	
	static int nodeWithMaxSum(Node root)
	{
		if(root == null)
			return 0;
		
		int lSum = nodeWithMaxSum(root.left);
		int rSum = nodeWithMaxSum(root.right);
		int sum = lSum + rSum + root.data;
		
		if(sum > maxSum)
		{
			maxSum = sum;
			maxSumNode = root;
		}
		
		 return sum;
	}
	
    public static void main(String [] args)
	{		
		Node root = new Node(1);
		Node r2 = new Node(2);
		Node r3 = new Node(3);
		Node r4 = new Node(4);
		Node r5 = new Node(-5);
		Node r6 = new Node(6);
		Node r7 = new Node(7);
		Node r8 = new Node(-8);
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		r4.right = r8;
		
		nodeWithMaxSum(root);
		out.println("Max sum node: "+ maxSumNode.data);
		out.println("Max sum: "+ maxSum);
	} 
}
