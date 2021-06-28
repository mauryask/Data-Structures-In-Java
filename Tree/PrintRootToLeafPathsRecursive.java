/**
Time complexity  : O(n)
Space complexity : O(n)(recursion stack) + O(n) (path stack) = O(n)
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

public class PrintAllTheRootToLeafPath
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
    
	static void printPaths
	(Node root, Stack<Node> path)
	{
	   if(root != null)
	   {
		   path.push(root);
		   printPaths(root.left, path);
		   if(root.right == null && root.left == null)
			   printStack(path);
		   printPaths(root.right, path);
		   path.pop();
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
			  printPaths(root, path);
		}
}
