/* https://leetcode.com/problems/copy-list-with-random-pointer/
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
T(n) : O(n)
S(n) : O(1)
*/

//Best way without using the Map

class Solution 
{
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
       Node temp = head; 
       
       while(temp != null)
       {
           System.out.print(temp.val+" ");
           temp = temp.next;
       }
        
        temp = head;
        
      while(temp != null)
       {
           Node node =  new Node(temp.val);
           Node x = temp.next;
           temp.next = node;
           node.next = x;
           temp = x;
       }
        
        
        
       temp = head;
       head = temp.next;
        
       while(temp != null)
       {
           Node node = temp.next;
           node.random = temp.random;
           temp.next = null;
           temp.random = null;
           temp = node.next;

           node.next = temp == null ? null : temp.next;
       }
       System.out.println();
        while(head != null)
        {
            System.out.print("("+head.val+", "+head.random.val+")");
            head = head.next;
        }
        
       return head;
    }
}