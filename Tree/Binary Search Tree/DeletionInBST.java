/**
Time complexity  : O(n)
Space complexity : O(1)
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

public class Test 
{
	static Node root = null;
	
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
		
  static void deleteElement(Node root, int target)
  { 
	 Node parentNode = null;	
	 while(root != null && root.data != target)
	 {		 			   			 
 		parentNode = root;
		 if(root.data < target)
			 root = root.right;
		 else if(root.data > target)
			 root = root.left;
	 }
       
	   // what if node is not found
	   if(root == null)
	   {
		   out.println("Node not found");
		   return;
	   }

	// if node has 0 child
	 if(root.left == null && root.right == null) 
	 {
		 if(parentNode.data  > target)
			parentNode.left = null;
		 else
			parentNode.right = null; 
	 } // if node has nly one children
	 else if((root.left == null && root.right != null) ||
	 (root.left != null && root.right == null)) 
	 {
		 Node childPtr = null;
		 
		 if(root.left == null)
			 childPtr = root.right;
		 else
			 childPtr = root.left;
		 
		 root.data = childPtr.data;
		 root.left = childPtr.left;
		 root.right = childPtr.right;
	 }
	 else  //if node has both children
	 {
		 // the node value will be replaced with the inorder
		 // predecessor or inorder successor
		 // inorder prdecessor will be
		 // max-value node in left subtree
		 
		 // code to find max value in the left subtree
		 //	of the current root node
	 	 Node temp = root.left;
		 Node prevNode = null;
		 while(temp.right != null)
		 {
			 prevNode = temp;
			 temp = temp.right;
		 }
		 
		 root.data = temp.data;
		 
		 // handling case when both children are leaf nodes
		 if(prevNode == null)
			 root.left = temp.left;
		 else // both chilren further contains children
			 prevNode.right = null; 
	 }
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
		
		inorder(root);
		out.println();
		deleteElement(root,12015);
		}
}