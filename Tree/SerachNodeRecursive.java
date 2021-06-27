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
	static Node insertNode(int data, Node root)
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

	static void preorder(Node root)
	{
		Stack<Node> stack = new Stack<>();
		while(true)
		{
		   	while(root != null)
			{
				out.print(root.data+" ");
				stack.push(root);
				root = root.left;
			}

			if(stack.isEmpty())
				break;

			root = stack.pop();
			root = root.right;
		}
	}

	static boolean isExist(Node root, int value)
	{
		if(root == null)
			return false;
		if(root.data == value)
		{
			return true;
		}
		else
		{
			boolean left =  isExist(root.left, value);
			if(left) m    
				return true;
			else
			{
				boolean right = isExist(root.right, value);
				return right;
			}
		}
	}

	public static void main(String [] args)
	{
		Node root = null;
		root = insertNode(58, root);
		insertNode(45, root);
		insertNode(62, root);
		insertNode(59, root);
		insertNode(42, root);
		insertNode(75, root);
		insertNode(20, root);

		out.println(isExist(root, 59));
	}
}