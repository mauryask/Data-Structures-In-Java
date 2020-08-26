class Node 
{
  int data;
  Node left, right; 
  Node(int data)
  {
	  this.data = data; 
	  left = right = null;
  }  
}

public class FindTotaolNodeInBInaryTreeRecursively
{
	static Node insertNode(int data, Node root)
	{
		Node temp = null, current = null, parent = null;
		temp = new Node(data);
		if(root == null)
			root = temp;
		else
		{
			current = root;
			while(current != null)
			{
				parent = current;
				if(temp.data >= current.data)
					current = current.right;
				else
					current = current.left;
			}
			
			if(temp.data >= parent.data)
				parent.right = temp;
			else 
				parent.left = temp;
		}
		return temp;
	}
	
	static void printTree(Node root)
	{
		if(root !=  null)
		{
			System.out.print(root.data+" ");
			printTree(root.left);
			printTree(root.right);
		}
	}
	
	// recursive function to count total nodes
	// try to understand it using recurstion tree 
	// not recursion stack
	static int countNode(Node root)
	{
		if(root == null)
			return 0;
		return (countNode(root.left) + 1 + countNode(root.right));
	}
	
	public static void main(String [] args)
	{
		Node root = null;
	    root = insertNode(10, root);
		insertNode(56, root);
		insertNode(60, root);
		insertNode(96, root);
		insertNode(23, root);
		insertNode(14, root);
		insertNode(23, root);
		insertNode(74, root);
		
		printTree(root);
		int totalNode = countNode(root);
		System.out.println("\n"+totalNode);
	}
}