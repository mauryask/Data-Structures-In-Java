
class Node {

    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

public class ReverseListTillKPositions {

    static Node insertNode(int value, Node head) {
        Node temp, ptr = null;
        temp = new Node(value);
        if (head == null) {
            head = temp; 
        }else {
            ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
        return temp;
    }

    static Node reverse(Node head, int k) {
        Node nextPtr = null, prevPtr = null, ptr = head;

        while (ptr != null && k-- > 0) {
            nextPtr = ptr.next;
            ptr.next = prevPtr;
            prevPtr = ptr;
            ptr = nextPtr;
            System.out.print(k+" ");
        }

        head.next = ptr;
        head = prevPtr;

        return head;
    }

    static void displayList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = insertNode(78, head);
        insertNode(56, head);
        insertNode(60, head);
        insertNode(40, head);
        insertNode(23, head);
        insertNode(89, head);
        insertNode(55, head);
        insertNode(47, head);
        displayList(head);
		System.out.println();
        head = reverse(head, 4);
		System.out.println();
		displayList(head);
    }
}
