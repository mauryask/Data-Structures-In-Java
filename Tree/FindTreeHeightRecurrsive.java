/**
Time complexity: O(n)
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

public class FindTreeHeightRecurrsive
{
	static void preOrder(Node root) 
	{
		if(root != null)
		{
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	static int getHeight(Node root)
	{
		if(root == null)
			return 0;

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
	    return Math.max(leftHeight, rightHeight) + 1;
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
          // we are getting height+1 from get height function
		  // /so need to subtract 1 from the height obtained
		  out.println(getHeight(root)-1);
		}

}
