//iterative traversal of tree pre, in and post order traversals
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

public class IteartiveTreeTraversal 
{	
	static Node insertNode(int value, Node root)
	{
		Node temp, parent_node, current_node;
		temp = new Node(value);
		parent_node = null;
		
		if(root == null)
		{
			root = temp;
		}
		else
		{
			current_node = root;
			while(current_node != null)
			{
				parent_node = current_node;
				if(temp.data >= current_node.data)
				{
				  current_node = current_node.right;	
				}
				else
				{
					current_node = current_node.left;
				}
			}
			
			if(temp.data > parent_node.data)
				parent_node.right = temp;
			else
				parent_node.left = temp; //less or equal to then in left subtree
		}		
		return temp;
	} 


//here we are going to use stack to store info of the previous node	 	
	static void iterativePreorder(Node root) //this is not the global 'root' variable
	{
		Stack<Node> stack = new Stack<>();
		
		while(true)
		{
			while(root!=null)
			{
				System.out.print(root.data+" ");
				
				stack.push(root);
				
				root = root.left;
			}
			
			if(stack.isEmpty())
				break;
			
			root = stack.pop();
			
			root = root.right;			
		}
	}

	
	static void iterativeInorder(Node root)
	{
	  Stack<Node>	 stack = new Stack<>();
	  while(true)
	  {
		  while(root!=null)
		  {
			  stack.push(root);
			  root = root.left;
		  }
		  
		  if(stack.isEmpty())
			  break;
		  root = stack.pop();
		  System.out.print(root.data+" ");
		  root = root.right;
	  }
	}
	
	
	static void iterativePostorder(Node root)
	{
		Stack<Node> stack =  new Stack<>();
		Node prev = null;
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				root = root.left;
				
			}
			
			while(root==null && !stack.isEmpty())
			{
				root = stack.peek(); //get top element
				if(root.right == null || root.right == prev)
				{
					System.out.print(root.data+" ");
					stack.pop();
					prev = root;
					root = null;
				}
				else
					root = root.right;
			}

			if(stack.isEmpty())
			  break;

		}
	}
	
	static void postOrderRecursive(Node root)
	{
		if(root != null)
		{
			postOrderRecursive(root.left);
			postOrderRecursive(root.right);
			root.left = null;
			root.right = null;
		}
	}
	
	
	
	  public static void main(String [] args)
		{
		
		  Node root = null;
		  root = insertNode(8, root);
		  insertNode(5, root);
		  insertNode(3, root);
		  insertNode(7, root);
		  insertNode(9, root);
		  insertNode(2, root);
		  
		  //iterativePreorder(root);
		  //iterativeInorder(root);
		  //iterativePostorder(root);
		  
		  //++++================================++++
		  // here we are delting the tree
		  // post order traversal
		  // we can do it by iterative postorder travesal also
		  
		  postOrderRecursive(root);
		  
		  // tree after deletion
		  root = null;
		  iterativePostorder(root);
		  
		}

}
