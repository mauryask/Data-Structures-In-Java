/*
* Finding shortest distance between two 
* given nodes, idea is to find the LCA first 
* then find total levels in left subtree 
* and total level in right subtree of the LCA 
* add them up and add 1 (level of LCA)
* this is the shortes distance between 
* the two given nodes
*/

import static java.lang.System.*;
import java.util.*;

class Node  
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

public class ShortestDistanceBetweenTwoNodes_LCA
{
   static Node LCA(Node root, int d1, int d2)
   {
	  if(root == null)
		  return null;
	  if(root.data == d1 || root.data == d2)
		  return root;
	  
	  Node l_sub = LCA(root.left, d1, d2);
	  Node r_sub = LCA(root.right, d1, d2);	  
	  
	  if(l_sub != null && r_sub != null) 
		  return root;
	  else 
		  return l_sub == null ? r_sub : l_sub;
   }
   
   static int findLevel(Node root, int d1, int d2)
   {
	   if(root == null)
		   return 0;
	   
	   List<Node> q = new LinkedList<>();
	   q.add(root);
	   q.add(null);
	   int level = 0;
	   
	   while(!q.isEmpty())
	   {
		   root = q.remove(0);
		   
		   if(root == null)
		   {
			   level++;
			   if(!q.isEmpty())
				   q.add(null);
			   continue;
		   }
		   else if(root.data == d1 || root.data == d2)
			   return level+1;
		   
		   if(root.left != null)
			   q.add(root.left);
		   if(root.right != null)
			   q.add(root.right);
	   }
	   return 0;
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
		Node r16 = new Node(16);
		Node r17 = new Node(17);
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
     	r3.right = r7;
		r5.left = r8;
		r5.right = r9;
		r6.right = r10;
		r10.left = r13;
		r7.left = r12;
		r7.right = r11;
		
		Node lca = LCA(root, 11, 13);
		int leftLevel = findLevel(lca.left,11,13);
		int rightLevel = findLevel(lca.right,11,13);
		out.println(leftLevel + rightLevel + 1);
	}
}