
import java.util.*;

/* https://leetcode.com/problems/copy-list-with-random-pointer/*/
public class CloneLinkedListWithRandomPointer {

    class Node {

        int val;
        Node random, next;

        Node(int val) {
            this.val = val;
        }
    }

    // O(n) space approah
    Node copyLinkedList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        // Create a new node for each node
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        // Link next and random pointers 
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
        }

        return map.get(head);
    }

    // O(1) space approach 
    Node copyLinkedList2(Node head) {
        Node curr = head;
        // Insert a deep copy of every node between two nodes
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Link random pointers
        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;

        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;

        while (curr != null) {
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummyHead.next;
    }
}
