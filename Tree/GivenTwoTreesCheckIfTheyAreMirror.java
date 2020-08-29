//==> given two binary trees check 
//==> if they are mirror to each other

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

public class GivenTwoTreesCheckIfTheyAreMirror
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
	
	static void isMirror(Node rootx, Node rooty)
	{
	   Queue<Node> qx = new ArrayDeque<>();	
	   Queue<Node> qy = new ArrayDeque<>();	
	   boolean flag = false;
	   qx.add(rootx);
	   qy.add(rooty);
	   
	   while(!qx.isEmpty() && !qy.isEmpty())
	   {
		   rootx = qx.poll();
		   rooty = qy.poll();
		   
		   if(!(rootx.data == rooty.data))
		   {
			flag = false;
            break;			
		   }
		   else
			 flag = true;
		   
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
	   
	   if(flag == true)
		   System.out.println("Mirror");
	   else
		   System.out.println("Not Mirror");
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
 
          isMirror(rootx, rooty);
		}
}
