import static java.lang.System.*;

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

public class CheckForPathHavingGivenSum
{
	static boolean printRootToLeafPaths(Node root, int sum, int target)
	{
		if(root == null)
			return false;
		
		sum += root.data; 
		
		if(root.left == null && root.right == null)
		{
			if(sum == target)
				return true;
			return false;
		}
	    else
			return !printRootToLeafPaths(root.left, sum , target) ?
			 printRootToLeafPaths(root.right, sum, target) : true;   
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
		   
           int sum = 0;
		   int target = 8;
		  out.print(printRootToLeafPaths(root, sum,target));
	}
}

