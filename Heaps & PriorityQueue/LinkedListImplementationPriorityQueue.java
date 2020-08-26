//ascending priority queue
//element with highest priority value has has priority

// !!!!!!!!!!!! Flagged ;;; there s error in this program

class Node 
{
	int value;
	int pri;
	Node next;
	
	Node(int value, int pri)
	{
		this.value = value;
		this.pri = pri;
		next = null;
	}
}

public class LinkedListImplementationPriorityQueue 
{
	static Node head = null;
	
	static Node createNode(int value, int pri)
	{
		return new  Node(value, pri);
	}
	
	static void insertNode(int value, int pri)
	{
		Node temp, ptr;
		temp = createNode(value, pri);
		
		if(head == null)
		{
			head = temp;
		}
		else
		{
			//use less thsn symbol here and below
			//(for ascending priority queue)
			if(temp.pri > head.pri) 
			{
				temp.next = head;
				head = temp;
			}
			else //find appropritae position for new node
			{
				ptr = head ;
			  while(ptr.next != null && ptr.next.pri  > temp.pri)
			  {
				  ptr = ptr.next;
			  }	

                                   temp.next = ptr.next;
				   ptr.next = temp;
			}
		}
	}
	
	static void printList()
	{
		while(head != null)
		{
			System.out.println(head.pri+" => "+head.value);
			head = head.next;
		}
	}
	
	public static void main(String [] args)
	{
	   insertNode(15,12);
	   insertNode(22,8);
	   insertNode(35,19);
	   insertNode(10,16);
	   insertNode(78,4);
	   insertNode(89,11);
	   
	   printList();
	}
}