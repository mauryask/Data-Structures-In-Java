/**
Time complexity  : O(n)
Space complexity : O(height) : stack as extra space
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

public class ValidateBST
{
	static Node createTree(Node root, int data)
	{
		Node temp = new Node(data);
		Node currentNode = null, parentNode = null;
		
		if(root == null)
			root = temp;
		else
		{
		  currentNode = root;
		  while(currentNode != null)
		  {
			  parentNode = currentNode;
			  
			  if(currentNode.data < data)
				  currentNode = currentNode.right;
			  else 
				  currentNode = currentNode.left;
		  }
		  
		  if(parentNode.data > data)
			  parentNode.left = temp;
		  else
			  parentNode.right = temp;
		}
		
		return root;
	}
	
	static void inorder(Node root)
	{
		if(root != null)
		{
			inorder(root.left);
			out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
		static boolean validateBST(Node root)
		{
			Stack<Node> stack = new Stack<>();
		    int prev = Integer.MIN_VALUE;
			
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
				
				if(prev >= root.data)
					return false;
				
				prev = root.data;				
				root = root.right;	
			}
			
			return true;
		}
	
	public static void main(String [] args)
	{
		Node root = null;
		/*root = new Node(1);
		Node r2 = new Node(2);
		Node r3 = new Node(3);
		Node r4 = new Node(4);
		Node r5 = new Node(5);
		Node r6 = new Node(6);
		Node r7 = new Node(7);
		Node r8 = new Node(8);
		Node r9 = new Node(9);
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		r4.left = r8;
		r7.right = r9;
		
		inorder(root);
		out.println();
		out.println(validateBST(root));*/
		
		root = createTree(root, 89);
		createTree(root,36);
		createTree(root,78);
		createTree(root,120);
		createTree(root,100);
		createTree(root,45);
		createTree(root,145);
		createTree(root,79);
		createTree(root,44);
		createTree(root,48);
		createTree(root,80);
		
		inorder(root);
		out.println();
		out.println(validateBST(root));
	}
}