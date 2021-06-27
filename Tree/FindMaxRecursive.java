/**
Time complexity: O(n)
Space complexity: O(n)
*/
import static java.lang.System.*;
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

public class FindMaxRecursive
 {
	static int getMax(Node root)
	{	
		if(root == null)
			return 0;
		int left = findMax(root.left);
		int right = findMax(root.right);
		int max = Math.max(root.data, Math.max(left, right));
		return max;
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
		
		out.println(getMax(root));	
    }

}
