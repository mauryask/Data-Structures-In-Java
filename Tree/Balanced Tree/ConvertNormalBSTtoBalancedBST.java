/*
* T(n) : O(n)
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

public class ConvertNormalBSTtoBalancedBST 
{
	// creating BST
	static void insertNode(Node root, int data)
	{
		Node curr = root, parent=null;
		Node temp = new Node(data);
		
		while(curr != null)
		{
			parent = curr;
			
			if(curr.data > temp.data)
				curr = curr.left;
			else
				curr = curr.right;
		}
		
		if(parent.data > temp.data)
			parent.left = temp;
		else
			parent.right = temp;
	}
	
	// storing the nodes in nodeList
	static void inorder(Node root, List<Node> list)
	{
		if(root != null)
		{
			inorder(root.left, list);
			list.add(root);
			inorder(root.right, list);
		}
	}
	
	// building balanced tree
	static Node buildBalanceTree(List<Node> nodeList,
	int start, int end)
	{
		if(start > end)
			return null;
		
		int mid = start + (end-start)/2;
		Node node = nodeList.get(mid);
		// optional 
		node.left = null;
		node.right = null;
		
		node.left = buildBalanceTree(nodeList, start, mid-1);
		node.right = buildBalanceTree(nodeList, mid+1, end);
		
		return node;
	}
	
	//dispaly tree 
	static void preorder(Node root)
	{
		if(root != null)
		{
			out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String [] args)
	{
          Node root = new Node(4);
		  insertNode(root, 3);
		  insertNode(root, 2);
		  insertNode(root, 1);
          List<Node> nodeList = new ArrayList<>();
		  //print tree before balancing
		  preorder(root);
		  // stores the nodes in nodeList 
		  // in ascending oder
          inorder(root, nodeList);
		  // build tree
          root = buildBalanceTree(nodeList, 0, nodeList.size()-1);		  
		  //print tree after balancing
		  out.println();
		  preorder(root);
	}
}