import static java.lang.System.*;
import java.util.*;

class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
	   right = left = null;
	}
}

public class ConvertBinaryTreeToBST
{
	static void convertToBST(Node root)
	{
		List<Integer> list = new ArrayList<>();
		inorderToCollectNode(root, list);
		// get inorder traversal and sort it 
		// since inorder traversal of BST is going 
		// to be always in sorting order
		Collections.sort(list);
		// replace corresponding node values
		// to convert tree into BST
		inorderToReplaceNode(root, list);
		printTree(root);
	}
	
	static int i = 0;
	
	static void inorderToReplaceNode(Node root, List<Integer> list)
	{
		if(root != null)
		{
			inorderToReplaceNode(root.left, list);
			root.data = list.get(i++);
			inorderToReplaceNode(root.right, list);
		}
	}
		
	static void inorderToCollectNode(Node root, List<Integer> list)
	{
		if(root != null)
		{
			inorderToCollectNode(root.left, list);
			list.add(root.data);
			inorderToCollectNode(root.right, list);
		}
	}
	
	
	static void printTree(Node root)
	{
		if(root != null)
		{
			out.print(root.data+" ");
			printTree(root.left);
			printTree(root.right);
		}
	}
	
	public static void main(String[] args)
	{
		  Node root = new Node(3);
		  Node r2 = new Node(12);
		  Node r3 = new Node(2);
		  Node r4 = new Node(4);
		  Node r5 = new Node(33);
		  Node r6 = new Node(25);
		  Node r7 = new Node(10);
		  Node r8 = new Node(14);
		  Node r9 = new Node(23);
		  Node r10 = new Node(52);
		  Node r11 = new Node(7);

		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r4.right = r8;
		  r8.right = r10;
		  r7.left = r9;
		  r9.left = r11;
		  
		  convertToBST(root);
	}
}
