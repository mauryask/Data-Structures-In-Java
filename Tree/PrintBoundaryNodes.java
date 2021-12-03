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
	static void printLeftBoundary(Node root)
	{
		Stack<Node> stack = new Stack<>();
		Node prev = null;
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				root = root.left;
			}
			
			while(root == null && !stack.isEmpty())
			{
				root = stack.peek();
				if(root.left == null && root.right == null)
				{
					stack.pop(); //remove leaf node
					for(Node x: stack)
						out.print(x.data+" ");
					return;
				}
				
				if(root.right == null || root.right == prev)
				{
					prev = root;
					root = null;
					stack.pop();
				}
				else
					root = root.right;
			}
			
			if(stack.isEmpty())
				break;
		}
	}
	
    static void printLeafNodes(Node root)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			root = q.poll();
			
			if(root.left == null && root.right == null)
				out.print(root.data+" ");
			else
			{
				if(root.left != null)
					q.add(root.left);
				if(root.right != null)
					q.add(root.right);
			}
		}
	}
	
	// Reverse post order traversal
	// R->L->D
	static void printRightBoundary(Node root)
	{
		Stack<Node> stack = new Stack<>();
		Node prev = null;
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				root = root.right;
			}
			
			while(root == null && !stack.isEmpty())
			{
				root = stack.peek();
				if(root.right == null && root.left == null)
				{
					stack.pop(); //remove leaf node 
					// since we dont wanrt to print 
					// the root again
					while(stack.size() != 1)
					{
						out.print(stack.pop().data+" ");
					}
					return;
				}
				
				if(root.left == null || root.left == prev)
				{
					prev = root;
					root = null;
					stack.pop();
				}
				else
					root = root.left;
				
				if(stack.isEmpty())
					break;
			}
		}
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
		  Node r9 = new Node(23);
		  Node r10 = new Node(52);
		  Node r11 = new Node(7);

		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r4.right = r8;
		  r8.right = r10;
		  r7.left = r9;
		  r9.left = r11;

         printLeftBoundary(root);
		 printLeafNodes(root);
		 printRightBoundary(root);
	}
}
