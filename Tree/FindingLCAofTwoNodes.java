// finding least commom ancestor of two 
// nodes in a given binary tree
// Baically it is the first common node in
// the ancestors of the both given nodes

// https://www.youtube.com/watch?v=F-_1sbnPbWQ

import static java.lang.System.*;

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
public class FindingLCAofTwoNodes
{
   static Node LCA(Node root, int d1, int d2)
   {
	  if(root == null)
		  return null;
	  if(root.data == d1 || root.data == d2)
		  return root;
	  
	  
	  Node l_sub = LCA(root.left, d1, d2);
	  Node r_sub = LCA(root.right, d1, d2);
	  
	  
	  if(l_sub != null && r_sub != null) //case : 1
		  return root;
	  else // case :  2, 3
		  return l_sub == null ? r_sub : l_sub;
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
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
     	r3.right = r7;
		r4.left = r8;
		r8.left = r9;
		
		Node deepNode = LCA(root, 9, 7);
		System.out.println(deepNode.data);
	}
}