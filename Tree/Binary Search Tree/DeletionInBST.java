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

public class DeletionInBST
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
     boolean flag = false;
	 
	 while(root != null)
	 {		 			   			 
 		parentNode = root;
		if(root.data == target)
		{
			flag = true;
			break;
		}
		else if(root.data < target)
			 root = root.right;
		else if(root.data > target)
			 root = root.left;
	 }
       
	   // what if node is not found
	   if(!flag)
	   {
		   out.println("Target node not found!!!");
		   return;
	   }

	// if node has no child
	 if(root.left == null && root.right == null) 
	 {
		 if(parentNode.left == root)
			parentNode.left = null;
		 else
			parentNode.right = null; 
	 } // if node has only one children
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
		 
		 childPtr.left  = null;
		 childPtr.right = null;
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
		 {
			  root.left = temp.left;
			  temp.left = null;
		 }
		 else // both chilren further contains children
		 {
			 prevNode.right = temp.left!=null ? temp.left :
			 temp.right;
		 }
			 
			 // handles all the cases
			 
/*			      50
			    /     \
	delete ->  19      80 <-- delete 
			   / \    / \  
	          17  20 70 85  
			  /       \
			 16       75 
			           / 
			          74 
			  
			  */
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
		deleteElement(root,36);
		inorder(root);
		}
}

