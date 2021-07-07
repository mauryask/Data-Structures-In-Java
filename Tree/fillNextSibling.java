/**
Time complexity   : O(n)
Spasce complexity : O(n) 
Next sibling of each node should point to the 
next node in the horizontal
*/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node left, right, nextSibling;
	Node(int data)
	{
		this.data = data;
		left = right = nextSibling = null;
	}
}

public class fillNextSibling
{

   static void fillNextSibling(Node root)
   {
	   LinkedList<Node> q = new LinkedList<>();
	   
	   q.add(root);
	   q.add(null);
	   
	   while(!q.isEmpty())
	   {
		   root = q.remove(0);
		   
		   if(root == null)
		   {
			   if(!q.isEmpty())
				   q.add(null);
			   continue;
		   }
		   
		   if(root.left != null)
			   q.add(root.left);
		   
		   if(root.right != null)
			   q.add(root.right);
		   
		   root.nextSibling = q.element();
	   }
   }


   static void levelOrder(Node root)
   {
	   Queue<Node> q = new ArrayDeque<>();
	   q.add(root);
	   while(!q.isEmpty())
	   {
		   root = q.remove();
		   out.println(root.nextSibling != null ?
		   root.data+" => "+root.nextSibling.data:
		   root.data+" => "+root.nextSibling);
		   
		   if(root.left != null)
			   q.add(root.left);
		   
		   if(root.right != null)
			   q.add(root.right);
	   }
   }

   // Time complexity  : O(n)
   // Space complexity : O(n)

	static void fillNextSiblingRecursive(Node root)
	{
		if(root == null)
		 return;

		if(root.left != null)
			root.left.nextSibling = root.right;
			
		if(root.right != null)
		{
			if(root.nextSibling != null)
				root.right.nextSibling = root.nextSibling.left;
		}
			
		fillNextSiblingRecursive(root.left);
		fillNextSiblingRecursive(root.right);
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
		 /* r4.left = r8;
		  r4.right = r9;
		  r5.left = r10;
		  r5.right = r11;
		  r6.left = r12;
		  r6.right = r13;
		  r7.left = r14;
		  r7.right = r15;*/
		  
		  fillNextSiblingRecursive(root);
		  levelOrder(root);
	}
}