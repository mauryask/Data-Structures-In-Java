//T(n) : O(nk)
//S(n) : O(1)

public class MergekSortedLinkedLists 
{
	Node mergeSortedList(Node head1, Node head2)
    {
        if(head1 == null)
           return head2;
        if(head2 == null)
           return head1;
           
        Node p1 = null;
        Node p2= null;   
           
        if(head1.data < head2.data)
        {
           p1 = head1;
           p2 = head2;
        }
        else
        {
            p1 = head2;
            p2 = head1;
        }
           
        Node ptr = p1;
        Node head = p1;
        p1 = p1.next;
        
        while(p1 != null && p2 != null)
        {
            if(p1.data < p2.data)
            {
                ptr.next = p1;
                ptr = p1;
                p1 = p1.next;
            }
            else
            {
                ptr.next = p2;
                ptr = p2;
                p2 = p2.next;
            }
        }
        
        if(p1 == null)
           ptr.next = p2;
        else 
          ptr.next = p1;
          
          return head;
    }
    
    Node mergeKList(Node[]arr,int k)
    {
       if(k == 1)
          return arr[0];
          
       Node head1 = arr[0];
       Node head2 = null;
       
       for(int i=1; i<arr.length; i++)
       {
           head2 = arr[i];
           head1 = mergeSortedList(head1, head2);
       }
       
       return head1;
    }
}