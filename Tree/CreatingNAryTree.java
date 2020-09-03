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
	
	static Node addSiblings(Node root, int data)
	{
		if(root==null)
			return null;
		else
		{
			while(root.next!=null)
				root = root.next;
			
			return(root.next = createNode(data));
		}		
	}
	
	static Node addChild(Node root,int data)
	{
				
		if(root ==  null)
			return null;
		if(root.child != null)
		    return addSiblings(root.child, data);
		else
		    return (root.child = createNode(data));
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
	   Node root = createNode(10);
	   Node n1 = addChild(root,2); 
       Node n2 = addChild(root,3);  
       Node n3 = addChild(root,4);
       Node n4 = addChild(root,14);
       Node n5 = addChild(root,12);
       Node n6 = addChild(n3,6);
       Node n7 = addChild(n3,7); 
       Node n8 = addChild(n3,8); 
       Node n9 = addChild(n3,9);
       Node n10 = addChild(n4,23);
       
       //traversal(root);
  
       levelOrderTraversal(root);
	}

}
