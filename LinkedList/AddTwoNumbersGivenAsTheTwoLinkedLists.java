
/**
 * Time complexity: O(n)
 * Space complexity : O(n)
 */

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class AddTwoNumbersGivenAsTheTwoLinkedLists {

    static Node sum(Node head1, Node head2) {
        int carry = 0;
        Node head = null, tail = null;

        while (head1 != null || head2 != null) 
		{
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;

            int sum = val1 + val2 + carry;
            Node temp = new Node(sum % 10);
            carry = sum / 10;

            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
				tail = temp;
            }

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        if (carry > 0) {
            tail.next = new Node(carry);
        }

        return head;
    }

    static void displayList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        head1.next = node1;
        node1.next = node2;

        Node head2 = new Node(9);
        Node node3 = new Node(7);
        Node node4 = new Node(8);
        head2.next = node3;
        node3.next = node4;

        Node head = sum(head1, head2);
		displayList(head);
    }
}
