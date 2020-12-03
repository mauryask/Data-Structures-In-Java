import static java.lang.System.*;
import java.util.*;
class Node 
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

public class PrintAllTheRootToLeaPath
{
	int path[] = new int[100];
	int pathLen = 0;
	static void printPath(int path[], int pathLen)
	{
		for(int i=0;i<=pathLen;i++)
			out.print(path[i]+" ");
		out.println();
	}
	
	
	//print the path recursively using preorder traversal
	static void printRootToLeafPaths(Node root, int path[], int pathLen)
	{
		if(root == null)
			return;
		
		path[pathLen] = root.data;
		pathLen++;
		
		if(root.left == null && root.right == null)
		  printPath(path, pathLen);
	    else
		{
			printRootToLeafPaths(root.left, path, pathLen);
			printRootToLeafPaths(root.right, path, pathLen);
		}   
	}
	
	public static void main(String [] args)
	{
	      Node root = new Node(1);
		  Node r2 = new Node(2);
		  Node r3 = new Node(3);
		  Node r4 = new Node(4);
		  Node r5 = new Node(5);
		  Node r6 = new Node(6);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r4.left = r6;
		   
		  int pathLen = -1;
		  int path[] = new int[100];
		  printRootToLeafPaths(root, path, pathLen);
	}
}

