class Node 
{
 int value;
 Node left;
 Node right;
 
 Node(int value)
 {
	 this.value = value;
	 left = right = null;
 }
 
}

public class TreeSort 
{
	static Node root = null;
	static int arr[];
	static int index = 0;
	
	static Node createNode(int value)
	{
		Node new_node = new Node(value);
		return new_node;
	}
	
	static void insertNode(int value)
	{
		Node temp, parent_node, current_node;
		parent_node = current_node = null;
		temp = createNode(value);
		
		if(root == null)
			root = temp;
		else
		{
			current_node = root;
			while(current_node != null)
			{
				parent_node = current_node;
				if(temp.value > current_node.value)
					current_node = current_node.right;
				else if(temp.value < current_node.value)
					current_node = current_node.left;
			}
			
			if(temp.value < parent_node.value)
				parent_node.left = temp;
			else
				parent_node.right = temp;
		}
	}
	
	//now perform inorder traversal it will sort the array in ascending order
	static void inorder(Node root)
	{
	    if(root != null)
		{
		   inorder(root.left);
	       arr[index++] = root.value;
		   inorder(root.right);
		}			
	}
		
   public static void main(String [] args)
   {
		 arr = new int []{45,10,2,30,12,78,44,36,21};
		 
		 for(int i=0; i<arr.length; i++)
			insertNode(arr[i]);
		
		inorder(root);
		
		//printing sorted array
		for(int x : arr)
			System.out.print(x+" ");
   }	   
}
