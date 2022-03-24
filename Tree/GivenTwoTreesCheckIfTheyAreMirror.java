import java.util.*;
import static java.lang.System.*;

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

public class GivenTwoTreesCheckIfTheyAreMirror
{	
	static boolean isMirror(Node rootx, Node rooty)
	{
	   Queue<Node> qx = new ArrayDeque<>();	
	   Queue<Node> qy = new ArrayDeque<>();	
	   
	   qx.add(rootx);
	   qy.add(rooty);
	   
	   while(!qx.isEmpty() && !qy.isEmpty())
	   {
		   rootx = qx.poll();
		   rooty = qy.poll();
		   
		   if(rootx.data != rooty.data)
		      return false;
		   
		   if(rootx.left != null && rooty.right != null)
		   {
			   qx.add(rootx.left);
			   qy.add(rooty.right);
		   }
		   
		   if(rootx.right != null && rooty.left != null)
		   {
			   qx.add(rootx.right);
			   qy.add(rooty.left);
		   }
	   }
       
	   return true;
	}
	
	static boolean recursive(Node root1, Node root2)
	{
		if(root1 == null && root2 == null)
			return true;
		else if(root1 == null || root2 == null)
			return false;
		
		return (root1.data == root2.data 
		&& recursive(root1.left , root2.right)
		&& recursive(root1.right, root2.left));
	}
	
	  public static void main(String [] args)
		{
		  Node rootx = new Node(1);
		  Node rx2 = new Node(2);
		  Node rx3 = new Node(3);
		  Node rx4 = new Node(4);
		  Node rx5 = new Node(5);
		  Node rx6 = new Node(6);
		  
		  rootx.left = rx2;
		  rootx.right = rx3;
		  rx2.left = rx4;
		  rx2.right = rx5;
		  rx4.left = rx6;
		  
		  //==> mirror of the above tree
		  
		  Node rooty = new Node(1);
		  Node ry2 = new Node(3);
		  Node ry3 = new Node(2);
		  Node ry4 = new Node(4);
		  Node ry5 = new Node(5);
		  Node ry6 = new Node(6);
		  
		  rooty.left = ry3;
		  rooty.right = ry2;
		  ry2.left = ry5;
		  ry2.right = ry4;
		  ry4.right = ry6;
 
          //out.println(isMirror(rootx, rooty));
          out.println(recursive(rootx, rooty));
		}
}
