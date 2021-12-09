/*
** https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
** T(n) : O(n) 
** S(n) : O(1)
*/

import static java.lang.System.*;
import java.util.*;

class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
	   right = left = null;
	}
}

public class FixTheBSTIfTwoNodesAreSwapped
{
	static void fixBST(Node root)
	{		
		 List<Node> q = new LinkedList<>();
		 q.add(root);		 
         Node aNode = null;
		 Node bNode = null;
		
		while(!q.isEmpty())
		{	
	        // if both nodes found no more 
			// traversal required
	        if(aNode != null && bNode != null)
				break;
	 
			root = q.remove(0);
				    
	   	    if(root.left != null)
			{
				// if this condition is true
				// it means something wrong with 
				// the root
				if(root.data < root.left.data)
					aNode = root;
				q.add(root.left);
			}
			
			if(root.right != null)
			{
				if(root.data > root.right.data)
					bNode = root;
				q.add(root.right);
			}		
		}
		
		// if nodes are not present
		 if(aNode == null || bNode == null)
			return;
		
		 int temp = aNode.data;
		 aNode.data = bNode.data;
		 bNode.data = temp;
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
	
	public static void main(String[] args)
	{
		  Node root = new Node(50);
		  Node r2 = new Node(45);
		  Node r3 = new Node(90);
		  Node r4 = new Node(40);
		  Node r5 = new Node(46);
		  Node r6 = new Node(85);
		  Node r7 = new Node(95);
		  Node r8 = new Node(93);
		  Node r9 = new Node(42);
		  Node r10 = new Node(43);
		  Node r11 = new Node(92);

		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r4.right = r8;
		  r8.right = r10;
		  r7.left = r9;
		  r9.left = r11;
          
		  inorder(root);
		  out.println();
		  fixBST(root);
		  inorder(root);
 	}
}
