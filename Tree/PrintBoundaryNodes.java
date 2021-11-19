// boundary traversal of the binary tree

import static java.lang.System.*;
import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
	   right = left = null;
	}
}

public class PrintBoundaryNodes
{
	
	/* Consider thios case
	            20
		  8         22
	  4      12         25
	    9  10  14     5
		 
	*/
	static void printLeftNodes(Node root)
	{
		if(root == null)
			return;
		
		while(root.left != null)
		{
			out.print(root.data+" ");
			root  = root.left;
		}
		
		if(root.left == null && root.right != null)
			out.print(root.data+" ");
	}
		
	static void printLeafNodes(Node root)
	{
		if(root == null)
			return;
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		if(root.left == null && root.right == null)
			out.print(root.data+" ");
	}
	
	static void printRightNodes(Node root)
	{
		Stack<Integer> stack = new Stack<>();
        root = root.right;
		
		while(root.right != null)
		{  
			stack.push(root.data);
			root = root.right;
		}
		
		if(root.right == null && root.left != null)
			stack.push(root.left.data);
	    
		while(!stack.isEmpty())
			out.print(stack.pop()+" ");
	}
	
	public static void main(String[] args)
	{
		  Node root = new Node(20);
		  Node r2 = new Node(8);
		  Node r3 = new Node(22);
		  Node r4 = new Node(4);
		  Node r5 = new Node(12);
		  Node r6 = new Node(25);
		  Node r7 = new Node(10);
		  Node r8 = new Node(14);

		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.right = r6;
		  r5.left = r7;
		  r5.right = r8;
		  
		  printLeftNodes(root);
		  printLeafNodes(root);
		  printRightNodes(root);
	}
}
