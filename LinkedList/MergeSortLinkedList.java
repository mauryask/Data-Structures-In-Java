import static java.lang.System.*;

public class MergeSortLinkedList 
{
//Merging to sorted Linkedlists
	
   static Node merge(Node p, Node q)
   {
	   if(p == null)
		   return q;
	   if(q == null)
		   return p;
	   
	   Node head = null, s = null;
	   
	   if(p.data < q.data)
	   {
		  s = p;
          p = s.next;		  
	   }
	   else
	   {
		   s = q;
		   q = s.next;
	   }
	   
	   head = s;
	   
	   while(p!=null && q!=null)
	   {
		   if(p.data < q.data)
		   {
			   s.next = p;
			   s = p;
			   p = s.next;
		   }
		   else
		   {
			   s.next = q;
			   s = q;
			   q = s.next;
		   }
	   }
	   
	   if(p == null)
		   s.next = q;
	   else if(q == null)
		   s.next = p;
	   return head;
   }
   
// Method to find Mid Node	
  static Node findMidNode(Node head)
  {
	  if(head ==  null)
		  return head;
	  Node slow = head, fast = head;  
	  while(fast.next !=  null && fast.next.next != null)
	  {
		  fast = fast.next.next;
		  slow = slow.next;
	  }
	  return slow;
  }  
  
// Merge Sort Method	
  static Node mergeSort(Node head)
  {
	  if(head == null || head.next == null)
	    return head;
	  
	  Node mid = findMidNode(head);
	  Node next_mid = mid.next;
	  mid.next = null;
	  Node left_list = mergeSort(head);
	  Node right_list = mergeSort(next_mid);
	  Node sorted_list  = merge(left_list, right_list);
	  return sorted_list;
  }  
	
// Main Method	
   public static void main(String args[])
   {
	    Node head = null;
		
		head = insertNode(head,9);			   
		insertNode(head, 8);			   
		insertNode(head, 7);			   
		insertNode(head, 6);			   
		insertNode(head, 5);
		insertNode(head, 4);
		
		printList(head);
		out.println();
		printList(mergeSort(head));
   }

//Insert Node method

static Node insertNode(Node head, int data)
   {
	   Node ptr = null, temp = null;
	   temp = new Node(data);
	   if(head == null)
		   head = temp;
	   else
	   {
		   ptr = head;
		   while(ptr.next != null)
			   ptr = ptr.next;
		   ptr.next = temp;
	   }
	   
	   return temp;
   }   
	
   static void printList(Node head)
   {
	   Node ptr = head;
	   while(ptr != null)
	   {
		   out.print(ptr.data+" ");
		   ptr = ptr.next;
	   }
   }    
}

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
