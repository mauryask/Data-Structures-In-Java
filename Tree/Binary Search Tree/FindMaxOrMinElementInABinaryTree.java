//Finding maximum or minimum element in 
//a binary tree (or binary search tree)
//works for all type tress
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

public class FindMaxOrMinElementInABinaryTree {

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

	

//finding max element using recursion
//https://www.youtube.com/watch?v=vpMe2aZM6Kg
//this video explains this approach better	
	
	
static int recursiveFindMax(Node root)
{
    	int root_val, left, right, max = Integer.MIN_VALUE;
    	
    	if(root!=null)
    	{
    		root_val = root.data;
    		left = recursiveFindMax(root.left);
    		right = recursiveFindMax(root.right);
    		
    		//finding the largest of the three
    		
    		if(left > right)
    			max = left;
    		else
    			max = right;
    		
    		if(max < root_val)
    			max = root_val;
    	}
    		
    	return max;
}


//finding max element using level order tree traversal
static void findMaxElementUsingLevelOrderTraversal(Node root)
{
	int max = Integer.MIN_VALUE;
	
	Queue<Node> q = new ArrayDeque<>();
	Node temp ;
	
	if(root==null)
		return;
		
	q.add(root);
	
	while(!q.isEmpty())
	{
		temp =  q.remove();
	    
		if(temp.data > max) //check if this element is max or not
			max = temp.data;
		
		if(temp.left != null)
			q.add(temp.left);
		if(temp.right != null)
			q.add(temp.right);
	}
	
	
	System.out.println(max);
	
}



static int findMaxUsingRecursion(Node root)
{
	int root_val, left, right, max = Integer.MIN_VALUE;
	if(root!=null)
	{
	    root_val = root.data;
	    left = findMaxUsingRecursion(root.left);
	    right = findMaxUsingRecursion(root.right);
	    //finding largest of the three
	    
	    if(left > right)
	    	max = left;
	    else
	    	max = right;
	    if(root_val > max)
	    	max = root_val;
	    
	}
	
	return max;
}

	  public static void main(String [] args)
		{
		
		  insertNode(8);
		  insertNode(5);
		  insertNode(3);
		  insertNode(7);
		  insertNode(9);
		  insertNode(2);

		// findMaxElementUsingLevelOrderTraversal(root);
		  
		  System.out.println(recursiveFindMax(root));
		  
		}

}

