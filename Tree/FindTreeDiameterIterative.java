/**
Time complexity  : O(n^2)
Space complexity : O(n)
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

	class Dia 
	{
		int ans = Integer.MIN_VALUE;
	}

public class FindTreeDiameterIterative
{
	// for each node this function is being called
	// that is hearting us most
	// it causes time complexity : O(n^2)
	static int getHeight(Node root)
	{
		if(root == null)
			return 0;
		
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		int height = Math.max(left, right) + 1;
		return height;
	}
   	
	
	static int findDiameterIterative(Node root)
	{
		Stack<Node> stack = new Stack<>();
		int dia = 0;
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				root = root.left;
			}
			
			if(stack.isEmpty())
				break;
			
			root = stack.pop();
			int lh = getHeight(root.left);
			int rh = getHeight(root.right);
			if(lh + rh +1 > dia)
				dia = lh+rh+1;
			root = root.right;
		}
		
		return dia;
	}
	
	static int findDiaBestWay(Node root, Dia dia)
	{
		if(root == null)
			return 0;
		int lh = findDiaBestWay(root.left, dia);
		int rh = findDiaBestWay(root.right, dia);
		dia.ans = Math.max(dia.ans, lh+rh+1);
		return Math.max(lh, rh) + 1;
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
			  
			  root.left = r2;
			  root.right = r3;
			  r2.left = r4;
			  r2.right = r5;
			  r3.left = r6;
			  r3.right = r7;
			  r4.right = r8;
			  
			  Dia dia = new Dia();
			  out.println(findDiaBestWay(root, dia));
			  out.println(dia.ans);
		}
}
