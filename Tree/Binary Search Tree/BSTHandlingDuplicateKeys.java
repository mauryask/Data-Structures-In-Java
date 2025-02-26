
public class BSTHandlingDuplicateKeys {
	static class Node
	{
		int value;
		Node left, right;
		int count;
		
		Node(int value)
		{
			this.value = value;
			left = right = null;
			count = 1;
		}
		
	}
	
	static Node createNode(int value)
	{
		BSTHandlingDuplicateKeys.Node new_node = new BSTHandlingDuplicateKeys.Node(value);
		return new_node;
	}
	
	//Resuse it to create BST
	static Node insert(Node root, int value)
	{
		if(root == null)
			return createNode(value);
		
		if(value == root.value)
		{
			root.count++;
			return root;
		}
		
		if(value < root.value)
			root.left = insert(root.left, value);
		else
			root.right = insert(root.right, value);
		
		return root;
	}
	
	static void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.value+"("+root.count+")"+" ");
			inorder(root.right);
		}
	}
	
	
	public static void main(String [] args) 
	{
		 Node  root =  null;
		 root = insert(root, 12);
		 root = insert(root, 15);
		 root = insert(root, 10);
		 root = insert(root,10);
		 root = insert(root, 20);
		 root = insert(root, 20);
		 
		 inorder(root);
	}
}
