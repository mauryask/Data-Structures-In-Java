/**
Time complexity  : O(n)
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

public class FindKthSmallestElement
{
	static Node root = null, head = null, prev = null;
	
	static void insertNode(int data)
	{
		Node temp = new Node(data);
		Node currentNode = null, parentNode = null;
		
		if(root == null)
			root = temp;
		else
		{
			currentNode = root;
			while(currentNode!= null)
			{
				parentNode = currentNode;
				if(currentNode.data < temp.data)
					currentNode = currentNode.right;
				else if(currentNode.data > temp.data)
					currentNode = currentNode.left;
			}
			
			if(parentNode.data > temp.data)
				parentNode.left = temp;
			else if(parentNode.data < temp.data)
				parentNode.right = temp;
		}
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
		
	static void findKthSmallest(Node root, int k)
	{
		Stack<Node> stack = new Stack<>();
		int count = 0;
		Node myNode = null;
		
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
			count++;
			
			if(count == k)
			{
				myNode = root;
				out.println(myNode.data);
				return;
			}
			
			root = root.right;
		}
	}
	
	// instead of declaring a class
	// declare the required variables as static
	// it will work same as the class vars work	
	static int count = 0;
	static boolean flag = false;
	static Node node  = null;
		
	static void findKthSmallestRecusrsive(Node root, int k)
	{
	      if(root == null)
			  return;
		  
		  findKthSmallestRecusrsive(root.left, k);
		  
		  //if required node found don't make unneccessary calls
		  if(flag)
			  return;
		  
		  count++;
		  
		  if(count == k)
		  {
			  node = root; 
			  flag = true;
			  return; // if node found then don't go further
		  } 
		  
		  findKthSmallestRecusrsive(root.right, k);
	}
		
	public static void main(String [] args)
	{
		insertNode(89);
		insertNode(36);
		insertNode(78);
		insertNode(120);
		insertNode(100);
		insertNode(45);
		insertNode(145);
		insertNode(79);
		insertNode(44);
		insertNode(48);
		insertNode(80);
		
		findKthSmallest(root, 5);
	}
}