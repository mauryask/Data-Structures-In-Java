/**
Time complexity  : O(n)
Space complexity : O(n)
*/
import java.util.*;
class Node 
{
	int data;
	Node next;
	Node(int value)
	{
		data = value;
		next = null;
	}
}

public class CloneListUsingHashTable
{
	static Node insertNode(int value, Node head)
	{
		Node temp, ptr = null;
		temp = new Node(value);
		if(head == null)
			head = temp;
		else
		{
			ptr = head;
			while(ptr.next != null)
			{
				ptr = ptr.next;
			}
			ptr.next = temp;
		}
		return temp;
	}
		

  static void displayList(Node head)
  {
	   while(head !=null)
	   {
		   System.out.print(head.data+" ");
		   head = head.next;
	   }
  }	  
		
	public static void main(String [] args)
	{
		Node head = null;
	    head = insertNode(1, head);
		insertNode(2, head);
		insertNode(3, head);
		insertNode(4, head);
		insertNode(5, head);
		insertNode(6, head);   
		insertNode(7, head);   
		insertNode(8, head); 
      
	   MainLogic ml = new MainLogic();
	   displayList(head);
	   System.out.println();
	   Node newHead = ml.clone(head);
	   displayList(newHead);
	}
}

class MainLogic 
{
	public Node clone(Node head)
	{	
	   Node x = head;
	   Node  y = null;
	   Map<Node,Node> map = new HashMap<>();
	  
	  while(x!=null)
	   {
		    y = new Node(x.data);
			map.put(x,y);
			x = x.next;
	   }
	   
	   x = head;
	   while(x!=null)
	   {
		   y = map.get(x);
		   y.next = map.get(x.next);
		   x = x.next;
	   }
	   return map.get(head);
	}
}