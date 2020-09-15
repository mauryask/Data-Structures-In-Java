import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.*;
import java.util.stream.*;
import java.util.*;

class Node 
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

public class SerachNodeRecursive
 {
	static boolean solve(Node root, int data)
	{	
        if(root == null)
			return false;
		if(root.data == data)
			return true;
		
		return solve(root.left, data) || solve(root.right, data);

	}    
	
	static void printTree(Node root)
	{
		if(root != null)
		{
			out.print(root.data+" ");
			printTree(root.left);
			printTree(root.right);
		}
	}
	
    public static void main(String args[] ) throws Exception
	{
		Node root = new Node(1);
		Node r2 = new Node(2);
		Node r3 = new Node(3);
		Node r4 = new Node(4);
		Node r5 = new Node(5);
		Node r6 = new Node(6);
		Node r7 = new Node(7);
		
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		
		out.println(solve(root, 1));
		//printTree(root);
    }

}
