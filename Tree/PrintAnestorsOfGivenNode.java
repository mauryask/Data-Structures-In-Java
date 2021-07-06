import static java.lang.System.*;
import java.util.*;


class Node 
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		right = left = null;;
	}
}

class Ancestor 
{
	boolean flag = false;
}

public class PrintAnestorsOfGivenNode
{
	static void findAncestor(Node root, int value,
	Stack<Node> path, Ancestor ancestor)
	{
		if(root == null)
			return;
		
		path.push(root);
		
		findAncestor(root.left, value, path, ancestor);
		if(root.left == null && root.right == null)
		{
			if(root.data == value)
			{
				ancestor.flag = true;
				path.pop(); // remove the current node
				printStack(path);
			}
		}
		
		if(ancestor.flag)
			return;
		else
			findAncestor(root.right, value, path,ancestor);
		path.pop();
	}
	
	
	static void printStack(Stack<Node> path)
	{
		for(Node node : path)
			out.print(node.data+" ");
		out.println();
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
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		
		Ancestor ancestor = new Ancestor();
		Stack<Node> path = new Stack<>();
		findAncestor(root,7, path, ancestor);
	}
}