import java.util.*;
import java.io.*;

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

public class TreeUsingLinkedList
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
				if(temp.data > current_node.data)
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

//traversing 

 static void preorder( Node root) 
 {
    if (root != null) 
	{ 
        System.out.print(root.data+" ");
		preorder(root.left);
        preorder(root.right);
    }
 }
 
 static void inorder(Node root)
 {
	 if(root != null)
	 {
		 inorder(root.left);
		 System.out.print(root.data+" ");
		 inorder(root.right);
	 }
 }
 
 static void postorder(Node root)
 {
	 if(root!= null)
	 {
		 postorder(root.left);
		 postorder(root.right);
		 System.out.print(root.data+" ");
	 }
 }


//inserting the elements recursively
	static Node reInsert(Node rt, int value)
	{
	   if(rt == null)
	   {
           rt = createNode(value);
		   root = rt;
	   }
       else if(value <= rt.data)
	   {
		   rt.left = reInsert(rt.left,value);
	   }
       else
	   {
		 rt.right = reInsert(rt.right, value);  
	   }
	   
      return rt;	   
	}

  public static void main(String [] args)
	{
		
		//creating binary search tree  iterativly
		/*Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		System.out.print("Enter the number of elements: \n");
		int n = sc.nextInt();
		System.out.print("Enter the elements: ");
		for(int i=1; i<=n; i++)
			insertNode(sc.nextInt());*/
	
	//creating binary search tree recursively
		Node rt = null;
		rt  = reInsert(rt,5);
		rt  = reInsert(rt,10);
		rt  = reInsert(rt,20);
		rt  = reInsert(rt,4);
		rt  = reInsert(rt,7);
		rt  = reInsert(rt,12);
		
	   preorder(rt);
	   System.out.println();
	   inorder(rt);
	   System.out.println();
	   postorder(rt);
	}
}