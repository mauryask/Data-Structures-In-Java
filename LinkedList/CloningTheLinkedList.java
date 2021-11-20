/**
Time complexity  : O(n)
Space complexity : O(1)
*/
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
public class CloningTheLinkedList
{
	static Node insertNode(Node head,int data)
	{
		Node ptr = null;
		Node temp = null;
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
		return temp;
	}
	
	static void printList(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	
 static  Node cloneList(Node head)
  {
	  Node head2= null,temp = null,nextNode = null;
	  
	  while(head!=null)
	  {
		 temp = new Node(head.data);
		 if(head2 == null)
			 head2 = temp;
		 else
		  nextNode.next = temp;
	  
		 head = head.next;
		 nextNode = temp;
	  }	

   return head2;	  
  }
	
  public static void main(String [] args)
  {
	 Node head = null;  
	 head = insertNode(head,1);
	 insertNode(head,2);
	 insertNode(head,3);
	 Node xp = insertNode(head,4);
	 insertNode(head,5);
	 insertNode(head,6);
	 Node end = insertNode(head,7);

     Node clonedHead =	cloneList(head);
	 printList(head);
	 System.out.println();	 
	 printList(clonedHead);

  }  
}