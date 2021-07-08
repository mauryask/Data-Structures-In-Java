/**
Time complexity : O(n)
Space complexity : O(n)
since inorder traversal of BST gives
elements in ascending order
so we are checking the previous value with
the current value if it is less then ok else not ok
*/

import java.util.*;
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

public class ValidateBSTBestSolution
{	
  static Node createBST(Node root, int data)
  {
	 Node temp = new Node(data);
	 Node currentNode = null, parentNode = null;
	 
	 if(root == null)
		 root = temp;
	 else
	 {
		 currentNode = root;
		 while(currentNode != null)
		 {
			 parentNode = currentNode;
			 if(currentNode.data < data)
				 currentNode = currentNode.right;
			 else if(currentNode.data > data)
				 currentNode = currentNode.left;
		 }
		 
		 if(parentNode.data < data)
			 parentNode.right = temp;
		 else
			 parentNode.left = temp;
	 }
	 
	  return temp;
  }
  
	 static boolean isBST(Node root)
	 {
		 if(root == null)
			 return true;
		 
		 Stack<Node> stack = new Stack<>();
		 // we are using (int_min-1) because
		 // a node can have  a node with value int_min as well 
		 long prev  = (long)Integer.MIN_VALUE - 1;
		 long curr = 0;
		 while(true)
		 {
			 while(root != null)
			 {
				 stack.push(root);
				 root = root.left;
			 }
			 
			 if(stack.isEmpty())
			 	break;
		 
			 root = stack.pop();
			 curr = root.data;
			 
			 if(curr < prev)
				 return false;
			 
			 prev = curr; // it stores the previous node
			 root = root.right;
		 }
		 
		 return true;		 
	 }

	public static void main(String [] args)
	{
        Node root = null;
		root = createBST(root, 44);
		createBST(root, 35);
		createBST(root,20);
		createBST(root, 10);
		createBST(root, 58);
		createBST(root, 36);
		createBST(root, 78);
		createBST(root, 12);
		createBST(root, 8);
		createBST(root, 23);
		createBST(root, 37);
		createBST(root, 38);
		Node last = createBST(root, 39);
		
		//root.right = last;
	   out.println(isBST(root));
	}
}