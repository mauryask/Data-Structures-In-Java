import static java.lang.System.*;
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

public class SerachNodeRecursive
{
	static Node root = null;
	
	static Node insertNode(int data)
	{
		Node parentNode = null, currentNode = null;
		Node temp = new Node(data);
		if(root == null)
			root = temp;
		else
		{
			currentNode = root;
			while(currentNode != null)
			{
				parentNode = currentNode;
				if(temp.data < currentNode.data)
					currentNode = currentNode.left;
				else
					currentNode = currentNode.right;
			}

			if(temp.data < parentNode.data)
				parentNode.left = temp;
			else
				parentNode.right = temp;
		}

		return temp;
	}	

   
   static void levelOrder()
   {
	   Stack<Integer> stack = new Stack<>();
	   Queue<Node> q = new ArrayDeque<>();
	   
	   q.add(root);
	   stack.push(root.data);

		while(!q.isEmpty())
		{
			Node root = q.poll();
			stack.push(root.data);
			
			if(root.right != null)
				q.add(root.right);
			
			if(root.left != null)
				q.add(root.left);
		}			
		
		for(;!stack.isEmpty();)
			out.print(stack.pop()+" ");
   }
   
   
   static void postOrder()
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
			   
			   if(root.right == null || root.right == prev)
			   {
				   root.left = null;
				   root.right = null;
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

  static void printTree(Node root)
  {
	  if(root != null)
	  {
		  printTree(root.left);
		  printTree(root.right);
		  out.print(root.data+" ");
		  root.left = null;
		  root.right = null;
	  }
  }

	public static void main(String [] args)
	{
		insertNode(58);
		insertNode(45);
		insertNode(62);
		insertNode(59);
		insertNode(42);
		insertNode(75);
		insertNode(20);

        printTree(root);
		out.println("\n===============");
		//postOrder();
		out.println("\n===============");
		printTree(root);
	}
}