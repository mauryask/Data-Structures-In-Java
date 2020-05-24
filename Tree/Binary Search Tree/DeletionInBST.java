//iterative method to delete a node
//from a binary search tree

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

public class DeletionInBST
{
	   private static Node root = null;
	   
	   static Node createNode(int value)
	   {
	     Node newNode = new Node(value);
	     return newNode;
	   }
	   
	   
	   
	   //insertion
	   static void insertNode(int value)
	   {
		   Node parent_node, current_node, temp;
		   current_node = parent_node = null;
		   
		   temp = createNode(value);
		   
		   if(root == null)
			   root = temp;
		   else
		   {
			   current_node = root;
			   while(current_node != null)
			   {
				    parent_node  = current_node;
				    
				    if(current_node.value > temp.value)
				    	current_node = current_node.left;
				    else
				    	current_node = current_node.right;
			   }
			   
			   if(parent_node.value > temp.value)
				   parent_node.left = temp;
			   else
				   parent_node.right = temp;
			   
		   }
			   
	   }
	   
	   
	   //deletion
	   static void deleteNode(int value)
	   {
	    
		   Node ptr = root;
		   Node parentNode = null;
		   
		   while(ptr.value != value)
		   {
			   parentNode = ptr;
			   
			   if(value < ptr.value)
				   ptr = ptr.left;
			   else
				   ptr = ptr.right;
		   }
		   
		   
		   //delete node having no child
		   if(ptr.left == null && ptr.right == null)
		   {
			   if(parentNode.value  > value)
				   parentNode.left = null;
			   else
				   parentNode.right = null;
		   }
		   //delete node having one child
		   else if((ptr.left == null && ptr.right!= null) 
	      || (ptr .left != null && ptr.right == null))
		   {
				Node childPtr = null;
				
				if(ptr.left == null)
					childPtr = ptr.right;
				else
				 childPtr = ptr.left;
			
				ptr.value = childPtr.value;
				ptr.left = childPtr.left;
				ptr.right = childPtr.right;
				
		   }
		   //delete node with two children
		   else
		   {
			   Node min_node_parent = findMinNodeParent(ptr.right);
		       ptr.value =  min_node_parent.left.value;
		       min_node_parent.left = null;
		   
		   }
		   
	  }
	     
	   
	   static Node findMinNodeParent(Node root)
	   {
		   Node parent = null;
		   
		   while(root.left != null)
		   {
		     parent = root;
		     root = root.left;
		   }
		   
		   return parent;
	   }
	   
	   
       //traversal
	   static void preorder(Node root)
	   {
		   if(root != null)
		   {
			   System.out.print(root.value+" ");
			   preorder(root.left);
			   preorder(root.right);
		   }
	   }
	   
	   
	   public static void main(String [] args)
	   {
		   insertNode(14);
		   insertNode(11);
		   insertNode(19);
		   insertNode(7);
		   insertNode(17);
		   insertNode(53);
		   insertNode(4);
		   insertNode(8);
		   insertNode(16);
		   insertNode(20);
		   insertNode(60);
		   
		   preorder(root);
		   
		   System.out.println();
		   deleteNode(60);
		   preorder(root);
	   }
	   
	   
}
	   

   
