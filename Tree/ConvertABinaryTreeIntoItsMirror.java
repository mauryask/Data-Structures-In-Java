/**
Time complexity  : O(n)
Space complexity : O(n)
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
		left = null;
		right = null;
	}
}

public class ConvertABinaryTreeIntoItsMirror
{
    static void levelOrder(Node root)
	{
		if(root == null)
			return;
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			root = q.remove();
			out.print(root.data+" ");
			
			if(root.left != null)
				q.add(root.left);
			if(root.right != null)
				q.add(root.right);
		}
		out.println();
	}
	
	static void getMirror(Node root)
	{
	    Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		while(!q.isEmpty())
		{
			root = q.poll();
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			
			if(root.left !=null)
				q.add(root.left);
			if(root.right != null)
				q.add(root.right);
		}
	}
	
	public static void main(String [] args)
	{
	      Node root = new Node(1);
		  Node r2 = new Node(2);
		  Node r3 = new Node(3);
		  Node r4 = new Node(4);
		  Node r5 = new Node(5);
		  Node r6 = new Node(6);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r4.left = r6;
		  levelOrder(root);
		  getMirror(root);
		  levelOrder(root);
	}
}

