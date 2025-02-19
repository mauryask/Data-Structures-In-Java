
import static java.lang.System.*;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class SubstractTwoLinkedLists {

    // Get the length of the Lists
    static int getLength(Node head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    // Get the List head representing larger number of the two
    static Node getLargerNumberHead(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1.data > temp2.data) {
                return head1;
            } else {
                return head2;
            }
        }

        return null;
    }

    static int borrow = 0;

    // Substract the Lists 
    static Node substract(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        Node prev = substract(head1.next, head2.next);

        int val1 = head1.data - borrow;
        int val2 = head2.data;

        Node head = new Node(0);

        if (val1 < val2) {
            head.data = (10 + val1) - val2;
            borrow = 1;
        } else {
            head.data = val1 - val2;
            borrow = 0;
        }

        head.next = prev;
        return head;
    }

    //Remove the leading 0s in the result
    static Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    static Node subLinkedList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        int l1 = getLength(head1);
        int l2 = getLength(head2);
        int steps = Math.abs(l1 - l2);

        Node larger = head1, smaller = head2;

        // If lengths are same for both: Get the list representing larger number
        if (l1 == l2 && getLargerNumberHead(head1, head2) != head1) {
            larger = head2;
            smaller = head1;
        } else if (l1 < l2) { //Else the list with larger length reprsenting larger number
            larger = head2;
            smaller = head1;
        }

        //Padd steps number of 0s in smaller linked lists
        while (steps-- > 0) {
            Node temp = new Node(0);
            temp.next = smaller;
            smaller = temp;
        }

        Node head = substract(larger, smaller);

        // Remove leading 0s from the result
        if (head.next != null) {
            head = removeLeadingZeros(head);
        }

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node1 = new Node(0);
        Node node2 = new Node(0);
        Node node3 = new Node(4);
        Node node4 = new Node(0);
        Node node5 = new Node(0);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node head2 = new Node(6);
        Node node6 = new Node(5);
        Node node7 = new Node(3);
        Node node8 = new Node(3);
        Node node9 = new Node(5);

        head2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        Node head = subLinkedList(head1, head2);
        printList(head);
    }
}
