//Getting the height of the tree
//---> recursively
//---> using Level order traversal (it gives totoal levels in the tree)

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

public class FindTreeHeight
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
		else
		{
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			if(leftHeight > rightHeight)
				return leftHeight+1;
			else
				return rightHeight+1;
		}
	}
	
	static int getLevel(Node root)
	{
	   //dont use array deque
	   //because it can not have NULL vaues
	   //use linked list instead
       //which behaves like queue as well
	   
		List<Node> q = new LinkedList<>();
		int level = 0;
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			root = q.remove(0); //remove the first element
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
		 
		  //preOrder(root);
          
         //	here u can find height of any node
		 /*System.out.println("\n"+(getHeight(root) - 1)); //height of the tree
		 System.out.println((getHeight(r2) - 1)); //height of r2
		 System.out.println((getHeight(r3) - 1)); // height of the r3
		 */
		 
		 //getting total number of level and hwence height
		 int level = getLevel(root);
		 System.out.println("Level: "+level);
		 System.out.println("Height: "+(level-1));
		}

}
