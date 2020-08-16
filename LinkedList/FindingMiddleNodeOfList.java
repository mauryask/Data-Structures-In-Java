// Here i have used two different approch to 
// find the middle element in the list
// the first one is using HashMap(Intenally uses HashTable)
// the second one is is using two 
// pointers which is the best approach to do this

import java.util.HashMap;

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

public class FindingMiddleNodeOfList
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
	

  static void findMiddleNode()
  {
	 Node ptr1 = head, ptr2 = head;
	
	 while(ptr2.next != null)
	 {
		 ptr1 = ptr1.next;
		 ptr2 = ptr2.next.next;
	 }
	 
	 // when ptr2 will point last node
	 // ptr1 will point first node
	 
	 System.out.println(ptr1.value);
  }

	 static void findMiddleNodeUsingHashTable()
	 {
		HashMap<Integer, Node> map = new HashMap<>();
		//put all the nodes in the set abd count the number of nodes as well
		int count = 0;
		Node ptr = head;
		while(ptr != null)
		{
			count++;
			map.put(count, ptr);
			ptr = ptr.next;
		}
		
		if(count % 2 != 0)
		   System.out.println(map.get((int)Math.ceil(count/2.0)).value);
                else
		   System.out.println(map.get((int)Math.floor(count/2.0)).value);
	 }

	public static void main(String [] args)
	{
		// if there is even number of elements then 
		// middle node will be : floor(n)
		
		insertNode(10);
		insertNode(20);
		insertNode(30);
		insertNode(40);
		insertNode(50);
		insertNode(60);   
		insertNode(78);    
		
		findMiddleNodeUsingHashTable();
	}
	
}

