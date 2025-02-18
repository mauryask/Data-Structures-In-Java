/*
* T(n) : O(max(m, n))
* S(n) : O(max(m, n)) => m is length of firts list 
** and n is length of second lists :: New linked lists is being created to store the result + recusriob stack
** Note: Check with interviewer if in the given list starting node reprsent LSB or not
** if yes no need to reverse it (else reversing needed)
** Ask if not the LSB as first node (can it have leading 0s)
**/

public class AddTwoNumbersInALinkedListsRecursive {

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // Reverse linked lists recursively
    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    static Node sum(Node head1, Node head2, int carry) {
        if (head1 == null && head2 == null && carry == 0) {
            return null;
        }

        int val1 = head1 == null ? 0 : head1.val;
        int val2 = head2 == null ? 0 : head2.val;

        int sum = val1 + val2 + carry;

        Node head = new Node(sum % 10);
        carry = sum / 10;

        Node nextNode1 = head1 == null ? null : head1.next;
        Node nextNode2 = head2 == null ? null : head2.next;

        head.next = sum(nextNode1, nextNode2, carry);

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + "");
            head = head.next;
        }
    }

    static Node removeLeadingZeros(Node head) {
        while (head != null && head.val == 0) {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(0);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        head1.next = node1;
        node1.next = node2;
        // Remove leading zeros from first list
        head1 = removeLeadingZeros(head1);
        // Reverse it if fisrt node does not reprsent the LSB
        head1 = reverse(head1);

        Node head2 = new Node(9);
        Node node3 = new Node(7);
        Node node4 = new Node(8);
        head2.next = node3;
        node3.next = node4;

        // Remove leading zeros from first list
        head2 = removeLeadingZeros(head2);
        // Reverse it if fisrt node does not reprsent the LSB
        head2 = reverse(head2);

        // Get the sum of the linkedlit 		  
        Node head = sum(head1, head2, 0);

        // Reverse it to get the original result
        head = reverse(head);
        // Print the new list
        printList(head);
    }
}



/*

// Another good approch without reversing the lists

class Solution {
    static int carry = 0;
    
    static Node sum(Node head1, Node head2){
        if(head1 == null && head2 == null)
          return null;
          
        Node nextNode1 = head1 == null ? null : head1.next;
        Node nextNode2 = head2 == null ? null : head2.next;
        
        Node prev = sum(nextNode1, nextNode2);
        
        int val1 = head1 == null ? 0 : head1.data;
        int val2 = head2 == null ? 0 : head2.data;
        
        int sum = val1 + val2 + carry;
        carry = sum / 10;
        
        Node head = new Node(sum % 10);
        head.next = prev;
        
        return head;
    }
    
    static int getLength(Node head){
        int count = 0;
        
        while(head != null){
            count++;
            head = head.next;
        }
        
        return count;
    }
    
    static Node removeLeadingZeros(Node head){
        while(head != null && head.data == 0){
            head = head.next;
        }
        
        return head;
    }
    
    static Node addTwoLists(Node head1, Node head2) {
           if(head1 == null) return head2;
           if(head2 == null) return head1;
           
           head1 = removeLeadingZeros(head1);
           head2 = removeLeadingZeros(head2);
           
           int l1 = getLength(head1);
           int l2 = getLength(head2);
           int steps = Math.abs(l1 - l2); 
          
           if(l2 > l1){
               Node temp = head2;
               head2 = head1;
               head1 = temp;
           }
           
           while(steps-->0){
               Node temp = new Node(0);
               temp.next = head2;
               head2 = temp;
           }
           
           carry =  0;
           
           Node head = sum(head1, head2);
           
           if(carry > 0){
               Node temp =  new Node(carry);
               temp.next = head;
               head = temp;
           }
           
           return head;
    }
}

**/