/*
* T(n) : O(n) 
* Without using auxilary space
** https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/

import static java.lang.System.*;
import java.util.*;

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

public class FlattenBinaryTreeToLinkedList
{
    static Node prev = null;

    static void flattenBinaryTree(Node root){
        if(root == null) return;

        flattenBinaryTree(root.right);
        flattenBinaryTree(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
	
	static void printLinkedList(Node root)
	{
		while(root != null)
		{
			out.print(root.data+" ");
			root = root.right;
		}
	}
	
    public static void main(String [] args)
	{		
		Node root = new Node(1);
		Node r2 = new Node(2);
		Node r3 = new Node(3);
		Node r4 = new Node(4);
		Node r5 = new Node(-5);
		Node r6 = new Node(6);
		Node r7 = new Node(7);
		Node r8 = new Node(-8);
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		r4.right = r8;
		
		flattenBinaryTree(root);
		printLinkedList(root);
	} 
}
