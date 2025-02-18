
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

        Node nextNode1 = null;
        Node nextNode2 = null;

        if (head1 != null) {
            nextNode1 = head1.next;
        }

        if (head2 != null) {
            nextNode2 = head2.next;
        }

        Node prev = substract(nextNode1, nextNode2);

        int val1 = (head1 == null ? 0 : head1.data) - borrow;
        int val2 = head2 == null ? 0 : head2.data;

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
}
