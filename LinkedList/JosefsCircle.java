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

public class JosefsCircle
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
	  Node temp = head;
	  do
	  {
		  System.out.print(temp.data+" ");
		  temp = temp.next;
	  }while(temp!=head);
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
		Node end = insertNode(7, head); 
       
	   end.next = head;
	   
	   int m = 4; //eleminate every mth person
	   
	   MainLogic ml = new MainLogic();
	   //displayList(head);
	   //System.out.println();
	   Node newHead = ml.electLeader(head, 7, m);
	   System.out.println(newHead.data);
	}
}

class MainLogic 
{
	public Node electLeader(Node head, int n,int m)
	{	
		for(int count = n; count>1; --count)
		{
		  for(int i=1; i<m; i++)
			 head = head.next;	
		  head.next = head.next.next;
		}
		
		return head;
	}
}