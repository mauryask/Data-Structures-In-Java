/**
T(n) : O(n)
S(n) : O(n) (In case of iterative solution) and O(1) (In case of recursive solution) 
*/
import java.util.*;

class Node 
{
	int data;
	Node left;
	Node right;
	Node next;

	Node(int data)
	{
		this.data = data;
	}
}

public class fillNextSibling
{
  //Note: The iterative solution is more generic and works for all types of binary trees
    static  Node connectNdoes(Node root) {
        if(root == null)
           return root;

        Node rootNode = root;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);        

        while(!q.isEmpty()){
            int count = q.size();
            Node prev = null;

            while(count-->0){
                root = q.poll();

                if(root.left != null)
                  q.add(root.left);

                if(root.right != null)
                q.add(root.right);

                if(prev != null)
                  prev.next = root;
                
                prev = root;
            }
        }

        return rootNode;

      //Comment the above code and uncomment the below code for recursive solution
      
       /* if(root != null) recursiveSolution(root);
          return root;*/
    }

  //Note: The recursive solution is more specific and works only for perfect binary trees
    static void recursiveSolution(Node root){
        // If it is leaf node : do not make a function call
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
               root.right.next = root.next.left;   

            recursiveSolution(root.left);   
            recursiveSolution(root.right);
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
		  Node r7 = new Node(7);
		  Node r8 = new Node(8);
		  Node r9 = new Node(9);
		  Node r10 = new Node(10);
		  Node r11 = new Node(11);
		  Node r12 = new Node(12);
		  Node r13 = new Node(13);
		  Node r14 = new Node(14);
		  Node r15 = new Node(15);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		 /* r4.left = r8;
		  r4.right = r9;
		  r5.left = r10;
		  r5.right = r11;
		  r6.left = r12;
		  r6.right = r13;
		  r7.left = r14;
		  r7.right = r15;*/

		  connectNdoes(root);
	}
}