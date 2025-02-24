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
	   right = left = null;
	}
}

public class IsGivenTreeIsSumTree
{
    static int isSumTree(Node root){
       if(root == null) return 0;
       if(root.left == null && root.right == null) return root.data;
       int ls = isSumTree(root.left);
       if(ls == -1) return -1;
       int rs = isSumTree(root.right);
       if(rs == -1) return -1; 
       int sum = ls + rs;
       if(sum != root.data) return -1;
       return root.data + ls + rs;
    }
	public static void main(String[] args)
	{
		  Node root = new Node(3);
		  Node r2 = new Node(1);
		  Node r3 = new Node(2);
		  Node r4 = new Node(4);
		  Node r5 = new Node(12);
		  Node r6 = new Node(25);
		  Node r7 = new Node(10);
		  Node r8 = new Node(14);
		  Node r9 = new Node(23);
		  Node r10 = new Node(52);
		  Node r11 = new Node(7);

		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r4.right = r8;
		  r8.right = r10;
		  r7.left = r9;
		  r9.left = r11;
		  
		 int sum = isSumTree(root);
		 out.println(sum == -1 ? "Not a sum tree" : "Sum tree");
	}
}
