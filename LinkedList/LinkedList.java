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

public class LinkedList 
{
	
	//default value of the object in  java is null
	//hence head will be initialized to null
	
	static Node head, tail; 
	
	public static void insertNode(int value)
	{
		Node newNode = new Node(value);
		
		if(head == null)
			head = newNode;
		else
		    tail.next = newNode;
		
		tail = newNode;
	}
	
	//===================> diaply nodes
	
	public static void displayNode()
	{
		Node p = head;
		while(p != null)
		{
			System.out.print(p.value+" ");
			p = p.next;
		}
	}
	
	//deleting a node
	static void delete()
	{
		if(head == null) // no node
			return;
		if(head.next == null) // one node
		{
			head = null;
			return;
		}
			
		Node temp,ptr;
		ptr=head;
		temp = head.next;
		while(temp.next!=null)
		{
			ptr= ptr.next;
			temp = temp.next;
		}
		
		ptr.next=null;
	}
	
	
	//insert node at the begining
	public static void insertNodeAtStart(int value)
	{
		Node newNode = createNode(value);
		newNode.next = head;
		head = newNode;
	}
	
		
	public static void main(String [] args)
	{
	
		LinkedList.insertNode(10);
		LinkedList.insertNode(20);
		LinkedList.insertNode(30);
		LinkedList.insertNode(40);
		LinkedList.insertNode(50);
		LinkedList.insertNode(60);
		LinkedList.insertNodeAtStart(5);
		LinkedList.reverseLinkedlist();
		
		LinkedList.displayNode();
	}
	
}