// time complexity : O(n)
class Node  
{
	int value;
	Node next;
	
	public Node (int value)
	{
		this.value = value;
		next = null;
	}	
}

public class ReverseListInPairs
{
	static Node head; 
    static Node createNode(int value)
	{
		Node newNode = new Node(value);
		return newNode;
	}


	static void insertNode(int value)
	{
		Node newNode = createNode(value);
		if(head == null)
			head = newNode;
		else
		{
			Node p = head;
			while(p.next != null)
				p = p.next;
			
			p.next = newNode;
		}
	}
	
	 static void reverseListInPairs()
	 {
		 Node p1 = head;
		 Node p2 = head.next;
		 Node temp = null;
		 head = p2;
		 
		 while(true)
		 {
			temp = p2.next;
			p2.next = p1;
			
			if(temp == null || temp.next == null)
			{
				p1.next = temp;
				return;
			}
			
			p1.next = temp.next;
			p1 = temp;
			p2 = temp.next;
		 } 
	 }

   public static void displayNode()
	{
		Node p = head;
		while(p != null)
		{
			System.out.print(p.value+" ");
			p = p.next;
		}
	}

	public static void main(String [] args)
	{
		insertNode(20);
		insertNode(30);
		insertNode(40);
		insertNode(50);
		insertNode(60);   
		insertNode(78);    
		insertNode(25);    
		
		reverseListInPairs();
		displayNode();
	}
	
}

