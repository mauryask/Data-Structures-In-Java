/**
Time complexity : O(n)
Space complexity: O(n)
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

public class Test
{
	static int getLevel(Node root)
	{   
		// Don't use ArrayDeque as it can't have null value
		List<Node> q = new LinkedList<>();
		int level = 0;
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			root = q.remove(0); 
			// Add null at the end of each level
			if(root == null)
			{
				if(!q.isEmpty())
					q.add(null);
				level++;
			}
			else
			{
				if(root.right != null)
					q.add(root.right);
				if(root.left != null)
					q.add(root.left);
			}
		}
		return level;
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

		 int level = getLevel(root);
		 System.out.println("Level: "+level); // level
		 System.out.println("Height: "+(level-1)); //height
		}
}
