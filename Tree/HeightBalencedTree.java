//https://www.youtube.com/watch?v=qIdVVH1tKM4
//https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
//checking whether tree is height balanced or not
//but this is not a good algorithm for this
//since rime complexity is :  O(n^2) 
//there is a better algorithm for this
//see HeightBalancedTree2
package com.pnstech;

class Node
{
	int value;
	Node left;
	Node right;
	
	Node(int value)
	{
		this.value = value;
		left = right = null;
	}
	
}

public class HeightBalencedTree1 {

	static boolean isBalenced(Node root)
	{
	   if(root == null)
		   return true;
	   
	   int lh = height(root.left);
	   int rh = height(root.right);
	   
	   if(Math.abs(lh-rh) <=1 && isBalenced(root.left) && isBalenced(root.right))
	      return true; 
	   
	   return false;
	}
	
	static int height(Node root)
	{
		if(root == null)
			return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(8);
		
		if(isBalenced(root))
			System.out.println("Tree is balenced!");
		else
			System.out.println("Tree is not balenced!");
		
	}

}
