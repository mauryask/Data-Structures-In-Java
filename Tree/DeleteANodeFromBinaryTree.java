// how to delete a node from a binary tree

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
public class DeleteANodeFromBinaryTree
{
	static Node findNode(Node root, int data)
	{
		List<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			root = q.remove(0);
			if(root.data == data)
				return root;
			
			if(root.left != null)
				q.add(root.left);
			
			if(root.right != null)
				q.add(root.right);
		}
		return null;
	}
	
   static void deleteNode(int data, Node root)
   {
	   //now find the node to be deleted
	   Node node = findNode(root, data);
	   if(node == null)
		   System.out.println("The node is not present in the tree");
	   else //if node is present in the tree
	   {
		  
		   //first find the deep node and the parent of that node
		   //replace the node to be delted with deepest node
		   //delete the deep node of the tree
		   
		   List<Node> q = new LinkedList<>();
		   Node parent = null;
		   q.add(root);
		   while(!q.isEmpty())
		   {
			   root = q.remove(0);
			   
			   if(root.left != null)
			   {
					parent = root;
					q.add(root.left);
			   }
			   if(root.right != null)
			   {
					parent = root;
					q.add(root.right);
			   }
		   }
		   
		   utilDeleteNode(root, parent, node);
	   }
   }
	
	//here node, the node to be deleted
	static void utilDeleteNode(Node deepNode, Node parent, Node node) 
	{
	   node.data = deepNode.data;
	   
	   //remove the deep node
	   if(parent.left == deepNode)
		   parent.left = null;
	   else
		   parent.right = null;
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
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
     	r3.right = r7;
		r4.left = r8;
		r8.left = r9;
		
		preOrder(root);
		System.out.println();
		deleteNode(7, root);
		preOrder(root);
	}
}