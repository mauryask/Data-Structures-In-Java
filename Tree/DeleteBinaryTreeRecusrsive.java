/**
Time complexity: O(n)
Space complexity: O(n)
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
		left = right = null;
	}
}

public class DeleteBinaryTreeRecusrsive
{
	static void levelOrder(Node root)
	{
		Queue<Node> q = new ArrayDeque<>();
		
		if(root == null)
		   return;
		
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
    
	static Node deleteTree(Node root)
	{
		if(root == null)
			return null;
		
		deleteTree(root.left);
		root.left = null;
		deleteTree(root.right);
		root.right = null;
		root = null;
		return root;
	}
  
	public static void main(String [] args)
	{
		Node root = new Node(1);
		Node r1 = new Node(63);
		Node r2 = new Node(45);
		Node r3 = new Node(4);
		Node r4 = new Node(62);
		Node r5 = new Node(96);
		Node r6 = new Node(7);
		root.left = r1;
		root.right= r2;
		r1.left = r3;
		r1.right = r4;
		r2.left = r5;
		r2.right = r6;

		levelOrder(root);
		out.println("Tree after deletion!!");
		root =  deleteTree(root);
		levelOrder(root);
	}
}