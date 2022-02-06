/*
** https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
** T(n) : O(n) 
** S(n) : O(n)
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

public class CheckIfTwoNodesAreCousins
{
	static boolean isCousin(Node root, int a, int b)
	{		
		LinkedList<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
	    Node aParent = null;
		Node bParent = null;
		int aLevel = 0;
		int bLevel = 0;
		int level = 0;

		while(!q.isEmpty())
		{	
			// check if both nodes are found
			// no more traversal required
            if(aParent != null && bParent != null)
				break;
         	
			root = q.removeFirst();
		     
            if(root == null)
			{
               if(!q.isEmpty())
					q.add(null);	
			   level++;				
			   
			   continue;
			}	
			
	   	    if(root.left != null)
			{
			   if(aParent == null && root.left.data == a)
			   {
				   aParent = root;
				   aLevel = level+1;
			   }
			   else if(bParent == null && root.left.data == b)
			   {
				   bParent = root;
				   bLevel = level+1;
			   }
			   
			   q.add(root.left);
			}
			if(root.right != null)
			{
			   if(aParent == null && root.right.data == a)
			   {
				   aParent = root;
				   aLevel = level+1;
			   }
			   else if(bParent == null && root.right.data == b)
			   {
				   bParent = root;
				   bLevel = level+1;
			   }
			   
			   q.add(root.right);
			}				
		}
				
		// check if parents are not null at the same time
		return (aParent != null && bParent != null) 
		&& (aParent != bParent)
		&& (aLevel== bLevel);
	}
	
	public static void main(String[] args)
	{
		  Node root = new Node(20);
		  Node r2 = new Node(8);
		  Node r3 = new Node(22);
		  Node r4 = new Node(4);
		  Node r5 = new Node(12);
		  Node r6 = new Node(25);
		  Node r7 = new Node(10);
		  Node r8 = new Node(14);
		  Node r9 = new Node(23);
		  Node r10 = new Node(52);
		  Node r11 = new Node(7);

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
          
		  out.println(isCousin(root, 22,8));
 	}
}
