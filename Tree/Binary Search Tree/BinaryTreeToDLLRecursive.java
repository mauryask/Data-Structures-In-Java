/**
Time complexity  : O(n)
Space complexity : O(n)
*/

import static java.lang.System.*;

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

// DLL head and tail
// because we want to persist head and tail
// between diferent function calls
class List 
{
	Node listHead = null;
    Node prev = null;
}

public class BinaryTreeToDLLRecursive
{
	static Node root = null;
	
	static void insertNode(int data)
	{
		Node temp = new Node(data);
		Node currentNode = null, parentNode = null;
		
		if(root == null)
			root = temp;
		else
		{
			currentNode = root;
			while(currentNode!= null)
			{
				parentNode = currentNode;
				if(currentNode.data < temp.data)
					currentNode = currentNode.right;
				else if(currentNode.data > temp.data)
					currentNode = currentNode.left;
			}
			
			if(parentNode.data > temp.data)
				parentNode.left = temp;
			else if(parentNode.data < temp.data)
				parentNode.right = temp;
		}
	}
	
	static void inorder(Node root)
	{
		if(root != null)
		{
			inorder(root.left);
			out.print(root.data+" ");
			inorder(root.right);
		}
	}
		
    static Node prev = null;
    // Head of the DLL (to be returned)
    static Node head = null;

    // Function to convert Binary Tree to DLL
    static Node convertToDLL(Node root) {
        if (root == null) return null;

        // Recursively convert the left subtree
        convertToDLL(root.left);

        // Process the current node
        if (prev == null) {
            // This is the first node (leftmost node in in-order traversal)
            head = root;
        } else {
            // Adjust pointers to form the DLL
            prev.right = root;
            root.left = prev;
        }

        // Update the previous node to the current node
        prev = root;

        // Recursively convert the right subtree
        convertToDLL(root.right);

        return head;
    }

	
	static void printList(Node head)
	{
		while(head != null)
		{
			out.print(head.data+" ");
			head  = head.right;
		}
		out.println();
	}
	
	
	public static void main(String [] args)
	{
		insertNode(89);
		insertNode(36);
		insertNode(78);
		insertNode(120);
		insertNode(100);
		insertNode(45);
		insertNode(145);
		insertNode(79);
		insertNode(44);
		insertNode(48);
		insertNode(80);
		
		List list = new List();
		inorder(root);
		out.println();
		convertToDLL(root);
		printList(list.listHead);
	}
}