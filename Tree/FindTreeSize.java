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

public class FindTreeSize
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
	}

  	static int getSize(Node root)
	{
		if(root == null)
			return 0;
		
		int left = getSize(root.left);
		int right = getSize(root.right);
		int size = left + right + 1;
		return size;
	}

	public static void main(String [] args)
	{
		Node root = new Node(58);
		Node r1 = new Node(32);
		Node r2 = new Node(78);
		Node r3 = new Node(36);
		Node r4 = new Node(65);
		Node r5 = new Node(20);
		root.left = r1;
		root.right= r2;
		r1.left = r3;
		r1.right = r4;
		r4.right = r5;
		
		levelOrder(root);
		out.println();
		out.println(getSize(root));
	}
}