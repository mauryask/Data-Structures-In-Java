//iterative traversal of tree pre, in and post order traversals
package com.pnstech;

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

public class IteartiveTreeTraversal {

	static Node root = null;
    static Node createNode(int value)
	{
		Node newNode = new Node(value);
		return newNode; 
	}
	
	static void insertNode(int value)
	{
		Node temp, parent_node, current_node;
		temp = createNode(value);
		parent_node = null;
		
		if(root == null)
		{
			root = temp;
		}
		else
		{
			current_node = root;
			while(current_node != null)
			{
				parent_node = current_node;
				if(temp.data >= current_node.data)
				{
				  current_node = current_node.right;	
				}
				else
				{
					current_node = current_node.left;
				}
			}
			
			if(temp.data > parent_node.data)
				parent_node.right = temp;
			else
				parent_node.left = temp; //less or equal to then in left subtree
		}		
	} 


//here we are going to use stack to store info of the previous node	 	
	static void iterativePreorder(Node root) //this is not the global 'root' variable
	{
		Stack<Node> stack = new Stack<>();
		
		while(true)
		{
			while(root!=null)
			{
				System.out.print(root.data+" ");
				
				stack.push(root);
				
				root = root.left;
			}
			
			if(stack.isEmpty())
				break;
			
			root = stack.pop();
			
			root = root.right;
				
		}
	}

	
	static void iterativeInorder(Node root)
	{
	  Stack<Node>	 stack = new Stack<>();
	  while(true)
	  {
		  while(root!=null)
		  {
			  stack.push(root);
			  root = root.left;
		  }
		  
		  if(stack.isEmpty())
			  break;
		  root = stack.pop();
		  System.out.print(root.data+" ");
		  root = root.right;
	  }
	}
	
	
	static void iterativePostorder(Node root)
	{
		Stack<Node> stack =  new Stack<>();
		Node prev = null;
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				root = root.left;
				
			}
			
			while(root==null && !stack.isEmpty())
			{
				root = stack.peek(); //get top element
				if(root.right == null || root.right == prev)
				{
					System.out.print(root.data+" ");
					stack.pop();
					prev = root;
					root = null;
				}
				else
					root = root.right;
			}

				if(!stack.isEmpty())
					break;

		}
	}
	
	  public static void main(String [] args)
		{
		
		  insertNode(8);
		  insertNode(5);
		  insertNode(3);
		  insertNode(7);
		  insertNode(9);
		  insertNode(2);
		  
		 //iterativePreorder(root);
		  //iterativeInorder(root);
		  iterativePostorder(root);
		}

}
