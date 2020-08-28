//finding the deepest ndoe in a tree
//here i have used level order traversal

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
public class FindDeppestNodeInTheBinaryTree
{
   static Node findDeepNode(Node root)
   {
	   List<Node> q = new LinkedList<>();
	   q.add(root);
	   while(!q.isEmpty())
	   {
		   root = q.remove(0);
		   
		   if(root.left != null)
			   q.add(root.left);
		   if(root.right != null)
			   q.add(root.right);
	   }
	   return root;
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
		
		Node deepNode = findDeepNode(root);
		System.out.println(deepNode.data);
		
	}
}