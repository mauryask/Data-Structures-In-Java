//==> creating complete binary tree using linked list
//==> if level order traversal of 
//==> the tree is given in the form of linked list
//==> In our case level order traversal: 10, 12, 15, 25, 30, 36

import java.util.*;
class Node 
{
	int data;
	Node next;
	Node (int data)
	{
		this.data = data;
		next = null;
	}
}

class BinaryTreeNode 
{
	int data;
	BinaryTreeNode left, right;
	BinaryTreeNode(int data)
	{
		this.data = data;
		left = right = null;
	}
}

public class CompleteBinaryTree 
{
	Node head = null;
	BinaryTreeNode root = null;
	
	// this is best way to insert the nodes
	// if we already know the last node 
	// time Complexiy : O(n)
	void createList(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	BinaryTreeNode convertListtoBinaryTree()
	{
		Queue<BinaryTreeNode> q = new ArrayDeque<>();
				
		if(head == null) //if there are no nodes in the list
			return null;
		
		BinaryTreeNode node  = new BinaryTreeNode(head.data);//root node
		q.add(node); //adding root to the queue
		head = head.next;
		
		while(head != null)
		{
			BinaryTreeNode parent = q.remove();
			BinaryTreeNode leftChild=null, rightChild=null;
			leftChild = new BinaryTreeNode(head.data);
			q.add(leftChild);
			head = head.next;
			if(head != null)
			{
				rightChild = new BinaryTreeNode(head.data);
				q.add(rightChild);
				head = head.next;
			}
			
			parent.left = leftChild;
			parent.right = rightChild;
		}
		return node;
	}
	
	void inorder(BinaryTreeNode root)
	{
		if(root != null)
		{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	public static void main(String [] args)
	{
	    CompleteBinaryTree tree = new CompleteBinaryTree();
		tree.createList(36); //last node
		tree.createList(30);
		tree.createList(25);
		tree.createList(15);
		tree.createList(12);
		tree.createList(10); //first node
		
		BinaryTreeNode root = tree.convertListtoBinaryTree();
		
		tree.inorder(root);
	}
}