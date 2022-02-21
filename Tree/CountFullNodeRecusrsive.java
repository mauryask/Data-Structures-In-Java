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

public class CountFullNodeRecusrsive
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
	
	static int countFullNode(Node root)
	{
     	if(root == null)
			return 0;
		int res = 0;
		if(root.left != null && root.right != null)
			res++;
		res += countFullNode(root.left) + 
		countFullNode(root.right);
		return res;
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
			  Node r8 = new Node(7);
			  Node r9 = new Node(7);
			  Node r10 = new Node(7);
			  Node r11 = new Node(7);
			  
			  root.left = r2;
			  root.right = r3;
			  r2.left = r4;
			  r2.right = r5;
			  r3.left = r6;
			  r3.right = r7;
			  r4.left = r8;
			  r8.right = r9;
			  r8.left = r10;
			  r7.left = r11;
			  levelOrder(root);
			  out.println(countFullNode(root));
		}
}
