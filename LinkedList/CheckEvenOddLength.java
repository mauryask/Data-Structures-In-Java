// concept : take a 2x pointer
// when it will point to last node then length is odd
// when it will point to null the length is even

class Node  
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
		next = null;
	}	
}

public class CheckEvenOddLength
{
	static Node head = null;
	static void insertNode(int data)
	{
		Node temp, ptr;
		temp = new Node(data);
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
	}
	
	static boolean isEven()
	{
		Node ptr;
		ptr = head;
		
		while(true)
		{
			if(ptr == null)
				return true;
			if(ptr.next == null)
				return false;
			
			  ptr = ptr.next.next;
		}
	}
	
	public static void main(String [] args)
	{
	    insertNode(12);
		insertNode(15);
		insertNode(45);
		insertNode(85);
		insertNode(89);
		insertNode(56);
		insertNode(23);
		
		boolean status  = isEven();
		if(status)
		System.out.print("even length");
	    else
		System.out.print("odd length");
	}
}