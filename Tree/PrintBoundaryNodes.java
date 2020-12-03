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
	static void printLeftNodes(Node root)
	{
		while(root.left !=null)
		{
			out.print(root.data+" ");
			root  = root.left;
		}
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
		int count = 0;
		while(root.right != null)
		{   ++count;
			stack.push(root.data);
			root = root.right;
		}
	    // count is used to prevent printing the root node again
		for(int i=0;i<count-1;i++)
			out.print(stack.pop()+" ");
	}
	
	public static void main(String[] args)
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
		  Node r11 = new Node(11);
		  Node r16 = new Node(16);
		  Node r18 = new Node(18);
		  Node r20 = new Node(20);
		  Node r22 = new Node(22);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r4.left = r6;
		  r4.right = r7;
		  r3.left = r10;
		  r3.right = r11;
		  r5.left = r8;
		  r5.right = r9;
		  r10.left = r16;
		  r10.right = r18;
		  r11.left = r20;
		  r11.right = r22;
		  
		  printLeftNodes(root);
		  printLeafNodes(root);
		  printRightNodes(root);
	}
}
