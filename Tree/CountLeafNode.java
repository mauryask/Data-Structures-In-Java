/**
Time complexity  : O(n)
Space complexity : O(n)
*/
import static java.lang.System.*;
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

public class CountLeafNode
{
	static void levelOrder(Node root)
	{
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
	
	//Iterative
	static int countLeafNode(Node root)
	{
        int count = 0;	
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			root = q.remove();
		
			
			if(root.left != null)
				q.add(root.left);
			if(root.right != null)
				q.add(root.right);
			if(root.left == null && root.right == null)
				count++;				
		}
		return count;
	}
		
	//Recursive	
    static int count(Node root){
		if(root == null) return 0;

		if(root.left == null && root.right == null){
			return 1;
		}

		return count(root.left) + count(root.right);
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
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
          levelOrder(root);
		  out.println(count(root));
		}
}
