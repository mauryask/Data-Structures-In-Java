/*
* Same as the max sum BST in Bimary Tree
* T(n) : O(n) 
* S(n) : O(n)
*/
import static java.lang.System.*;

class Node 
{
	Node left;
	Node right;
	int data;
	
	Node(int data)
	{
		left = right = null;
		this.data = data;
	}
}

public class LargestBSTInBinaryTree 
{
	static class NodeInfo
	{
		int max;
		int min;
		int currSize;
		boolean isBst;
		
		NodeInfo(int max, int min, boolean isBst, int currSize)
		{
			this.max = max;
			this.min = min;
			this.isBst = isBst;
			this.currSize = currSize;
		}
		NodeInfo(){};
	}
	
	static int maxSizeSoFar = 0;
	
	static NodeInfo getMaxSize(Node root)
	{
		if(root == null)
			return new NodeInfo(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0);
		
		if(root.left == null && root.right == null)
		{
			maxSizeSoFar = Math.max(maxSizeSoFar, 1);
			return new NodeInfo(root.data, root.data, true, 1);
		}
		
		NodeInfo left = getMaxSize(root.left);
		NodeInfo right = getMaxSize(root.right);
		
		int size = 1 + left.currSize + right.currSize;
		NodeInfo nodeInfo = new NodeInfo();
		nodeInfo.currSize = size;
		
		if(left.isBst && right.isBst && root.data < right.min && root.data > left.max)
		{
			nodeInfo.max  =  Math.max(root.data, Math.max(left.max, right.max));

            nodeInfo.min = Math.min(root.data, Math.min(left.min, right.min));
			 
			maxSizeSoFar = Math.max(maxSizeSoFar, size);
			 
			nodeInfo.isBst = true;
		}
		else
			nodeInfo.isBst = false;
		
		return nodeInfo;
	}
	
	public static void main(String [] args)
	{
		  /* 
		  Node root = new Node(5);
		  Node r2 = new Node(9);
		  Node r3 = new Node(2);
		  Node r4 = new Node(6);
		  Node r5 = new Node(3);
		  Node r6 = new Node(8);
		  Node r7 = new Node(7);
		  		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;		  		 
		  r3.right = r5;
		  r4.left = r6;
		  r4.right = r7; */  
		  
		  Node root = new Node(7);
		  Node r2 = new Node(12);
		  Node r3 = new Node(2);
		  Node r4 = new Node(11);
		  Node r5 = new Node(13);
		  Node r6 = new Node(5);
		  Node r7 = new Node(2);
		  Node r8 = new Node(1);
		  Node r9 = new Node(38);
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;		  
		  r3.right = r6;
		  r4.left = r7;
		  r6.right = r9;
		  r6.left = r8;
		 				  
		  getMaxSize(root);
		  out.println(maxSizeSoFar);
	}
}