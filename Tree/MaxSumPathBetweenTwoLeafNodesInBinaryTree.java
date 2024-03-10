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
	static int sum = 0;
	static int max1 = 0;
	static int max2 = 0;
	
	static void calcMax(Node root)
	{
		if(root != null)
		{
			sum += root.data;
			
			calcMax(root.left);
			calcMax(root.right);
			
			if(root.left == null && root.right == null)
			{
				if(sum > max1)
				{
					max2 = Math.max(max1, max2);
					max1 = Math.max(max1, sum);
				}
				else
				{
					max2 = Math.max(max2, sum);
				}
			}
			
			sum -= root.data;
		}
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
			  
			  calcMax(root);			  
			  out.println(max1 + max2);
		}
}
