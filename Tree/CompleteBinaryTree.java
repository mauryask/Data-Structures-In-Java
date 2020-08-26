//==> creating complete binary tree using linked list
//==> if level order traversal of 
//==> the tree is given in the form of linked list
//==> In our case level order traversal: 10, 12, 15, 25, 30, 36

import java.util.*;
class Node 
{
	int data;
	Node next;
	Node(int data)
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
		left = right=  null;
	}
}

public class BinaryTree 
{
	BinaryTreeNode root = null;
	Node head = null;
    
	void push(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	BinaryTreeNode convertList2Tree()
	{
		if(head == null)
			return null;
		
		Queue<BinaryTreeNode> q = new ArrayDeque<>();
		
		root = new BinaryTreeNode(head.data);
		q.add(root);
		head = head.next;
		
		while(head != null)
		{
			BinaryTreeNode parent = q.remove();
			BinaryTreeNode leftChild = null, rightChild = null;
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
	  return root;	
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
		BinaryTree tree = new BinaryTree();
		tree.push(36); //last node
		tree.push(30);
		tree.push(25);
		tree.push(15);
		tree.push(12);
		tree.push(10); //first null
		
		BinaryTreeNode root = tree.convertList2Tree();
		tree.inorder(root);
	}
}