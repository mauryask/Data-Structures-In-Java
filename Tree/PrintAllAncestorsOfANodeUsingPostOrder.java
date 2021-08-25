/**
* Printing all the ancestors of a given node 
* Using Post Order Traversal
* Time Complexity: O(n)
* Space Complexity: O(n)
*/

import java.util.*;
import static java.lang.System.*;

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

public class PrintAllAncestorsOfANodeUsingPostOrder
{
	static void printAncesstros(Node root, int target)
	{
		Stack<Node> stack = new Stack<>();
		Node prev = null;
		
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				root = root.left;
			}
			
			while(root == null && !stack.isEmpty())
			{
			  root = stack.peek();
			  
			  // printing ancestors
			  if(root.data == target)
			  {
				   printStack(stack);
				   return;
			  }
			  
			  if(root.right  == null || root.right == prev)
			  {
				 prev = root;
				 stack.pop();
				 root = null;				 
			  }
			  else
				  root = root.right;
			}
			
			if(stack.isEmpty())
				break;
		}
	}
	
	static void printStack(Stack<Node> stack)
	{
		stack.pop(); // remove the first the target
		for(Node root : stack)
			out.print(root.data+" ");
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
		  Node r11 = new Node(11);
		  Node r16 = new Node(16);
		  Node r18 = new Node(18);
		  Node r20 = new Node(20);
		  Node r22 = new Node(22);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r4.left = r6;
		  r4.right = r7;
		  r3.left = r10;
		  r3.right = r11;
		  r5.left = r8;
		  r5.right = r9;
		  r10.left = r16;
		  r10.right = r18;
		  r11.left = r20;
		  r11.right = r22;
		  
		  printAncesstros(root, 10);
		}
}
