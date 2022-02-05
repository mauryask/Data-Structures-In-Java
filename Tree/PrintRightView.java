/**
https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
******
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

public class PrintRightView
{
		static void rightView(Node root)
		{
			LinkedList<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			
			Node prev = null;
			
			while(!q.isEmpty())
			{
				root = q.removeFirst();
				
				if(root == null)
				{
					if(!q.isEmpty())
						q.add(null);
					out.print(prev.data+" ");
					continue;    
				}
				
				if(root.left != null)
					q.add(root.left);
				if(root.right != null)
					q.add(root.right);
				
				prev = root;
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
		  Node r7 = new Node(7);
		  Node r8 = new Node(8);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r7.right = r8;
          
		  rightView(root);
		}
}
