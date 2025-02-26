//finding the sum of all nodes of the n-ary tree
class Node{
	
	int value;
	Node next;
	Node child;
	Node(int value)
	{
		this.value = value;
		next = null;
		child = null;
	}
}

public class FindingSumOfAllTheNodesInNAryTree {

	static Node createNode(int value)
	{
		Node new_node  = new Node(value);
		return new_node;
	}
	
	  static Node addSibling(Node root, int value)
	  {
		  if(root == null)
			  return null;
		  else
		  {
			  while(root.next != null)
			  {
				  root = root.next;
			  }
			  return (root.next = createNode(value));
		  }
	  }
	 
	  static Node addChild(Node root, int value)
	  {
		  if(root==null)
			  return null;
		  else
		  {
			  if(root.child == null)
			  {
				  return(root.child = createNode(value));
			  }
			  else
			  {
				return addSibling(root.child, value);  
			  }
		  }
	  }
	  
	  
	  static int findSum(Node root)
	  {
		  if(root == null)
			  return 0;
		  
		  return root.value + findSum(root.child) +findSum(root.next);
	  }
	  
	 
	  
	public static void main(String[] args)
	{
	  Node root = new Node(1);
	  Node r1 = addChild(root,3);
	  Node r2 = addChild(root,2);
	  Node r3 = addChild(root, 1);
	  Node r4 = addChild(r2, 9);
	  Node r5 = addChild(r2,8);
	  
	  System.out.println(findSum(root));
	}

}
