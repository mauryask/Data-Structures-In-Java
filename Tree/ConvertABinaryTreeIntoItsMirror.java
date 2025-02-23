/**
Time complexity  : O(n)
Space complexity : O(n)
*/

import java.util.*;

class Node 
{
	int data;
	Node left, right;

	Node(int data)
	{
		this.data = data;
	}
}

public class ConvertABinaryTreeIntoItsMirror
{	
    static Node invertTree(Node root) {
        if(root == null) return null;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            Node node = q.poll();
            Node temp = node.right;
            node.right = node.left;
            node.left = temp;

            if(node.left != null){
                q.add(node.left);
            }

            if(node.right != null){
                q.add(node.right);
            }
        }

        return root;
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
          
		  invertTree(root);
	}
}

