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
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);

		while(!q.isEmpty())
		{	            
			root = q.poll();		     
			boolean aFound = false;
		    boolean bFound = false;
			
	   	    if(root.left != null)
			{
			   if(root.left.data == a)
				   aFound = true;			   
			   else if(root.left.data == b)
				   bFound = true;
			   
			   q.add(root.left);
			}
			if(root.right != null)
			{
			   if(root.right.data == a)
					aFound = true;
			   else if(root.right.data == b)
				   bFound = true;
			
			   q.add(root.right);
			}	

			if(aFound && bFound)
				return true;			
		}
				
        return false;
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
