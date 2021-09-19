/**
Time compexity : O(n)
Space compexity: O(n)
Note : Clever solution (Using Post order traversal)
*/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

public class DeleteBinaryTree
 {
	static void deleteTree(Node root)
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
				if(root.right == null || root.right == prev)
				{
					prev = root;
					root.right  = null;
					root.left = null;
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

/*
* Deleting tree usisng level order 
* traversal
*/
static void deleteTree2(Node root)
{
	Queue<Node> q = new ArrayDeque<>();
	q.add(root);
	
	while(!q.isEmpty())
	{
	    root = q.poll();
		
		if(root.left != null)
			q.add(root.left);
		if(root.right != null)
			q.add(root.right);
		root.left = null;
		root.right = null;
	}
}
	
	static void printTree(Node root)
	{
		if(root != null)
		{
			out.print(root.data+" ");
			printTree(root.left);
			printTree(root.right);
		}
	}
	
    public static void main(String args[] ) throws Exception
	{
		Node root = new Node(1);
		Node r2 = new Node(2);
		Node r3 = new Node(3);
		Node r4 = new Node(4);
		Node r5 = new Node(5);
		Node r6 = new Node(6);
		Node r7 = new Node(7);
		
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		
		deleteTree2(root);
		root = null;
		printTree(root);
		
    }
}
