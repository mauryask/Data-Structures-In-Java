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
