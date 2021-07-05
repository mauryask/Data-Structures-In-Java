/**
Time complexity  : O(n)
Space complexity : O(n)(stack) + O(n) (path stack) = O(n)
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

public class PrintAllTheRootToLeafPathIterative
{
	static void levelOrder(Node root)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			root = q.remove();
			out.print(root.data+" ");
			if(root.left != null)
				q.add(root.left);
			if(root.right != null)
				q.add(root.right);
		}
		out.println();
	}
    	
	static void printPath(Node root, Stack<Node> path)
	{
		Stack<Node> stack = new Stack<>();
		Node prev = null;
		
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				path.push(root);
				root = root.left;
			}
			
			while(root == null && !stack.isEmpty())
			{
				root = stack.peek();
				if(root.left == null && root.right == null)
					printStack(path);
				if(root.right == null || root.right == prev)
				{
					// once done with a node 
					// pop it from path stack
					path.pop();
			     	stack.pop();
					prev = root;
					root = null;
				}
				else
					root = root.right;
			}
			
			if(stack.isEmpty())
				break;
		}
	}
	
	static void printStack(Stack<Node> path)
	{
	   for(Node x: path)
		out.print(x.data+" ");
	   out.println();	
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
			  
			  //path stack
			  Stack<Node> path = new Stack<>();
			  printPath(root, path);
		}
}
