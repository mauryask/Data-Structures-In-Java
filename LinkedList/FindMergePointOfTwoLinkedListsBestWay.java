/**
Time complexity: O(m+n)
Space complexity: O(1)
*/

import static java.lang.System.*;

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
	   this.data = data;   
	   next =  null;
	}
}

public class FindMergePointOfTwoLinkedListsBestWay
{
	 static Node tail = null;
	
	 static Node insertNode(Node head,int data)
	 {
		 Node temp = new Node(data);
		 Node ptr = null;
		 
		if(head.next == null)
			tail = head;
		
        tail.next = temp;
        tail = temp;
		
		return tail;
	 }
	 
	 static void displayList(Node head)
	 {
		 Node ptr = head;
		 
		 while(ptr != null)
		 {
			 out.print(ptr.data+" ");
			 ptr = ptr.next;
		 }
		 
		 out.println();
	 }
	 
	 static void findMergePoint(Node head1, Node head2)
	 {
		int m = getLength(head1); // length of first list
		int n = getLength(head2); // length of second list
		
		int diff = 0;
		Node big = null,small = null;
		
		// check which list is large
		// and which is small in length
		if(m>n)
		{
			diff = m-n;
			big = head1;
			small = head2;
		}
		else
		{
			diff = n-m;
			big = head2;
			small = head1;
		}
		
		int count = 0;
		
		// move big pointer by diff positions
		while(count != diff)
		{
			big = big.next;
			count++;
		}
		
		// now compare corresponding nodes
		while(big != small)
		{
			big = big.next;
			small = small.next;
		}
		
		// print the commona nodes
		out.println(big.data);
	 }
	 
	 
	 static int getLength(Node head)
	 {
		Node ptr = head;
		int count = 0;
		while(ptr != null)
		{
			count++;
			ptr = ptr.next;
		} 
		
		return count;
	 }
		
	public static void main(String [] args) 
	{
		Node head1 = new Node(5);
		Node f1 = insertNode(head1, 10);
		Node f2 = insertNode(head1, 12);
		Node f3 = insertNode(head1, 14);
		Node f4 = insertNode(head1, 28);
		
		Node head2 =  new Node(78);
		Node s1 = insertNode(head2, 55);
		Node s2 = insertNode(head2, 96);
		Node s3 = insertNode(head2, 10);
		Node s4 = insertNode(head2, 23);
		Node s5 = insertNode(head2, 45);
		Node s6 = insertNode(head2, 102);
		Node s7 = insertNode(head2, 56);
		
		f4.next = s4;
		
		displayList(head1);
		displayList(head2);
		out.println();
		findMergePoint(head1, head2);
	}
}