//given post-fix expression print infix and prefix expressions

package com.pnstech;

class Node
{
	char value;  
	Node left;
	Node right;
	
	Node(char value)
	{
		this.value = value;
		left = right = null;
	}
}

public class ExpressionTree {
	
	static Node createNode(char value)
	{
		Node new_node = new Node(value);
		return new_node;
	}
	
	
	static boolean isOperator(char o)
	{
		if(o=='+' || o=='-' || o=='*' || o=='/' || o=='^' || o=='%')
			return true;
		else
			return false;
	}
	
	
	static Node constructTree(char ch[])
	{
		
		java.util.Stack<Node> stack = new java.util.Stack<>();
		
		Node t, t1, t2;
		
		for(int i=0; i<ch.length; i++)
		{
			if(!isOperator(ch[i]))
			{
				stack.push(createNode(ch[i]));
			}
			else
			{
				t = createNode(ch[i]);
				t1 = stack.pop();
				t2 = stack.pop();
				
				t.right = t1;
				t.left = t2;
				
				stack.push(t);
			}
		}

		return stack.pop();
	}
	
	
	//printing infix expression from post-fix expression
	static void infix(Node root)
	{
		if(root != null)
		{
			infix(root.left);
			System.out.print(root.value);
			infix(root.right);
		}
	}
	
	
	//printing prefix expression using post-fix expression
	static void prefix(Node root)
	{
		if(root!= null)
		{
			System.out.print(root.value);
			prefix(root.left);
			prefix(root.right);
		}
	}
	
	public static void main(String[] args)
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		//Enter post-fix expression
		 char ch[] = sc.next().toCharArray();
		 Node root = constructTree(ch);
         prefix(root);
         sc.close();
	}

}
