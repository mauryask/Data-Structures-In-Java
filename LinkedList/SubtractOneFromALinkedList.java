/*
* T(n) : O(n)
* S(n) : O(1)
** Subtract one from a positive integer 
** given as a linkelist
** https://www.geeksforgeeks.org/subtract-1-from-a-number-represented-as-linked-list/
 */
import static java.lang.System.*;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class SubtractOneFromALinkedList {

    // Approach : 01
	// Good approach works for all integers from 0 to 9 (to be substracted)

    // static int borrow = 0;
    // static int data = 1;

    // static void subtractOne(Node head) {
    //     if (head == null) {
    //         return;
    //     }
    //     subtractOne(head.next);

    //     head.data -= borrow;

    //     if (head.data < data) {
    //         head.data = (10 + head.data) - data;
    //         borrow = 1;
    //     } else {
    //         head.data -= data;
    //         borrow = 0;
    //     }

    //     data = 0;
    // }

    
	// Approcah : 02 (Best aproach for substracting 1)    
	// Data to be substracted
    static int sub = 1;

    static void subOne(Node head) {
        if (head == null) {
            return;
        }

        Node nextHead = head.next;
        subOne(nextHead);

        if (head.data == 0 && sub == 1) {
            head.data = 9;
        } else {
            head.data = head.data - sub;
            sub = 0;
        }
    }

    static void printList(Node head) {
        while (head != null) {
            out.print(head.data + " ");
            head = head.next;
        }

        out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node a = new Node(0);
        Node b = new Node(0);
        Node c = new Node(4);
        Node d = new Node(0);
        Node e = new Node(0);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        printList(head);

        subOne(head);

        // if head of the list is zero 
        // since it is meaning less remove it
        if (head != null && head.data == 0) {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }

        printList(head);
    }
}
