//n-art tree creation / traversal
//https://www.geeksforgeeks.org/creating-tree-left-child-right-sibling-representation/
import java.util.*;
class Node
{
	int data;
	Node child;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		child = next = null;
	}
}

public class CreatingNAryTree
{
	static Node createNode(int data)
	{
		Node n = new Node(data);
		return n;
	}
	
	static void addSiblings(Node root, Node node)
	{
		if(root==null)
			return;
		else
		{
			while(root.next!=null)
				root = root.next;
			root.next = node;
		}		
	}
	
	static void addChild(Node root,Node node)
	{		
		if(root ==  null)
			return;
		if(root.child != null)
		    addSiblings(root.child, node);
		else
		   root.child = node;
	}
	
  //time complexity O(n)
	static void traversal(Node root) // it is like depth first search
	{
		if(root == null) 
            return; 
        while(root != null) 
        { 
            System.out.print(root.data + " "); 
            if(root.child != null) 
            	traversal(root.child); 
            root = root.next; 
        } 	 
	}
	
	//level order traversal	
	static void levelOrderTraversal(Node root)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		while(!q.isEmpty())
		{
			root = q.poll();
			
			while(root != null)
			{
				System.out.print(root.data+" ");
				if(root.child != null)
					q.add(root.child);
				root = root.next;
			}
		}
	}
	
	public static void main(String[] args) {
	   Node root = new Node(12);
	   Node n1 = new Node(2); 
       Node n2 = new Node(3);  
       Node n3 = new Node(4);
       Node n4 = new Node(14);
       Node n5 = new Node(12);
       Node n6 = new Node(6);
       Node n7 = new Node(7); 
       Node n8 = new Node(8); 
       Node n9 = new Node(9);
       Node n10 = new Node(23);
       
	   addChild(root, n1);
	   addChild(root, n2);
	   addChild(root, n3);
	   addChild(root, n4);
	   addChild(n2,n5);
	   addChild(n2,n6);
	   addChild(n3,n7);
	   addChild(n7,n8);
	   addChild(n7,n9);
	   addChild(n8,n10);
	   
       //traversal(root);
  
       levelOrderTraversal(root);
	}

}
