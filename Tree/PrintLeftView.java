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

public class PrintLeftView
{
		static void rightView(Node root)
		{
			List<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			
			out.print(root.data+" ");
			
			while(!q.isEmpty())
			{
				root = q.remove(0);
				
				if(root == null)
				{
					if(!q.isEmpty())
					{
						out.print(q.get(0).data+" ");
						q.add(null);
					}
					
					continue;    
				}
				
				if(root.left != null)
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