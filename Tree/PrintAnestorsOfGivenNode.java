/**
  Time complexity: O(n)
  Space complexity: O(height) + O(height) = O(h) 
  : recursion stack + path stack
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
		right = left = null;
	}
}

class Ancestor 
{
	boolean flag = false;
}

public class PrintAnestorsOfGivenNode
{
	// In this solution extra stack is needed to store the path
	// but no extra function calls once the required node is found
   static void findAncestor(Node root, int value,
   Stack<Node> stack, Ancestor ancestor)
   {
	   if(root == null)
		   return;
	   stack.push(root);
	   
	   findAncestor(root.left, value, stack, ancestor);
	   if(root.left == null && root.right == null)
	   {
		   if(root.data == value)
		   {
			   ancestor.flag = true;
			   stack.pop();
			   printStack(stack);
		   }
	   }
	   
	   if(ancestor.flag)
		   return;
	   else
		   findAncestor(root.right, value, stack, ancestor);
	   stack.pop();
   }
   
  static void printStack(Stack<Node> stack)
  {
	  for(Node node : stack)
		  out.print(node.data+" ");
	  out.println();
  }
	
	// No extra space needed except the recursion stack
	// T(n) = O(n)
	// S(n) = O(n) : recursion stack
	
	static boolean findAncestor2(Node root, int value)
	{
		if(root == null)
			return false;
		if(root.data == value)
			return true;
		boolean left = findAncestor2(root.left, value);
		boolean right = findAncestor2(root.right, value);
	     
		if(left || right)
		{
			out.print(root.data+" ");
			return true;
		}
		
		return false;
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
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		r5.left = r8;
		r5.right = r9;
		r4.right = r10;
		
		/*Ancestor ancestor = new Ancestor();
		Stack<Node> stack = new Stack<>();
		findAncestor(root,9, stack, ancestor);*/
		findAncestor2(root, 9);
	}
}