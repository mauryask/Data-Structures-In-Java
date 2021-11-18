/**
Time complexity  : O(n)
Space complexity : O(n)
*/

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

public class LevelOrderTreeTraversal 
{
	static Node root = null;
    
	static Node createNode(int value)
	{
		Node newNode = new Node(value);
		return newNode; 
	}
	
	static void insertNode(int value)
	{
		Node temp, parent_node, current_node;
		temp = createNode(value);
		parent_node = null;
		
		if(root == null)
		{
			root = temp;
		}
		else
		{
			current_node = root;
			while(current_node != null)
			{
				parent_node = current_node;
				if(temp.data >= current_node.data)
				{
				  current_node = current_node.right;	
				}
				else
				{
					current_node = current_node.left;
				}
			}
			
			if(temp.data > parent_node.data)
				parent_node.right = temp;
			else
				parent_node.left = temp; //less or equal to then in left subtree
		}		
	} 

	
	
static void levelOrderTraverse()
{
		Queue<Node> q = new ArrayDeque<>();
		
		if(root == null)
			return;
		
		q.add(root); 
		
		while(!q.isEmpty())
		{
			Node root = q.poll(); 
			System.out.print(root.data+" ");
			
			if(root.left != null)
				q.add(root.left);
			
			if(root.right != null)
				q.add(root.right);
		}
	}

	  public static void main(String [] args)
		{
		  insertNode(8);
		  insertNode(5);
		  insertNode(3);
		  insertNode(7);
		  insertNode(9);
		  insertNode(2);
		  
		  levelOrderTraverse();	  
		}

}

