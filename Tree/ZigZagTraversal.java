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


public class ZigZagTraversal
{
	static void zizagTraversal(Node root)
	{
		List<Node> q = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		q.add(root);
		q.add(null);
		System.out.print(root.data+" ");
		boolean flag = false;
		
		while(!q.isEmpty())
		{
			root = q.remove(0);
			if(root == null)
			{
				while(!stack.isEmpty())
					System.out.print(stack.pop().data+" ");
				
				flag  = flag ? false : true;
				
				if(!q.isEmpty())
					q.add(null);
			}
			else
			{
				if(flag == true)
				{
					//adding into the queue
					if(root.right != null)
					   q.add(root.right);
				    if(root.left != null)
						q.add(root.left);
					
				   //adding into stack
					if(root.right != null)
						stack.push(root.right);	
					if(root.left != null)
						 stack.push(root.left);  
				}
				else
				{
					//adding into queue
					if(root.left != null)
						q.add(root.left);
					if(root.right != null)
					   q.add(root.right);
				   
				   //adding into stack
					if(root.left != null)
						stack.push(root.left);	
					if(root.right != null)
					    stack.push(root.right);					   
				}
			}
		}
	}
	
	static void preOrder(Node root) 
	{
		if(root != null)
		{
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
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
		  Node r9 = new Node(9);
		  Node r10 = new Node(10);
		  Node r11 = new Node(11);
		  Node r16 = new Node(16);
		  Node r18 = new Node(18);
		  Node r20 = new Node(20);
		  Node r22 = new Node(22);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r4.left = r6;
		  r4.right = r7;
		  r3.left = r10;
		  r3.right = r11;
		  r5.left = r8;
		  r5.right = r9;
		  r10.left = r16;
		  r10.right = r18;
		  r11.left = r20;
		  r11.right = r22;
		  
		  zizagTraversal(root);
		}
}
