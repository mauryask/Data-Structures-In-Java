/**
Time complexity  : O(n)
Space complexity : O(n)(stack) = O(n)
* This solution cobers two problems
* Check path with given sum
* print all the root to leaf paths
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
    	
	static void printPath(Node root)
	{
		Stack<Node> stack = new Stack<>();
		Node prev = null;
		int sum = 0;
		
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				sum += root.data;
				root = root.left;
			}
			
			while(root == null && !stack.isEmpty())
			{
				root = stack.peek();
				// add only the below code in 
				// postorder traversal
				// very important queation
				if(root.left == null && root.right == null)
				{
						printStack(stack);
						out.println("Path sum: "+sum);
				}
				if(root.right == null || root.right == prev)
				{
					// once done with a node 
					// pop it from stack
			     	stack.pop();
					sum -= root.data;
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
			  Node r9 = new Node(9);
			  Node r10 = new Node(10);
			  Node r11 = new Node(11);
			  Node r12 = new Node(12);
			  
			  root.left = r2;
			  root.right = r3;
			  r2.left = r4;
			  r2.right = r5;
			  r3.left = r6;
			  r3.right = r7;
			  r4.right = r8;
			  r4.left = r9;
			  r5.right = r10;
			  r7.right = r11;
			  r8.left = r12;
			  
			  printPath(root);
		}
}
