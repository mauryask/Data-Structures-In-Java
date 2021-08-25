/*
* Time complexity: O(n)
* Space complexity: O(n) + O(n) = O(n)
**/

import java.util.*;
import static java.lang.System.*;

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

public class ZigZagTraversal
{
	static void zizagTraversal(Node root)
	{
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
	    s1.push(root);
		boolean lr = true;
		
		while(!s1.isEmpty() || !s2.isEmpty())
		{
		    if(lr)
		    {
			   while(!s1.isEmpty())
			   {
				   root = s1.pop();
				   out.print(root.data+" ");
				   
				   if(root.left != null)
					   s2.push(root.left);
				   if(root.right != null)
					   s2.push(root.right);
			   }
			   
			   lr = false;
		    }	
			else
			{
				while(!s2.isEmpty())
				{
					root = s2.pop();
					out.print(root.data+" ");
					
					if(root.right != null)
						s1.push(root.right);
					if(root.left != null)
						s1.push(root.left);
				}
				lr = true;
			}				
		}
	}
	
	static void preOrder(Node root) 
	{
		if(root != null)
		{
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	  public static void main(String [] args)
		{
		
		  Node root = new Node(1);
		  Node r2 = new Node(2);
		  Node r3 = new Node(3);
		  Node r4 = new Node(4);
		  Node r5 = new Node(5);
		  Node r6 = new Node(6);
		  Node r7 = new Node(7);
		  Node r8 = new Node(8);
		  Node r9 = new Node(9);
		  Node r10 = new Node(10);
		  Node r11 = new Node(11);
		  Node r12 = new Node(12);
		  Node r13 = new Node(13);
		  Node r14 = new Node(14);
		  Node r15 = new Node(15);

		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r4.left = r8;
		  r4.right = r9;
		  r5.left = r10;
		  r5.right = r11;
		  r6.left = r12;
		  r6.right = r13;
		  r7.left = r14;
		  r7.right = r15;
		
		  zizagTraversal(root);
		}
}
