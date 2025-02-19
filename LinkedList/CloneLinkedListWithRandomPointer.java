
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
 public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;

        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;            
        }

        curr = head;

        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = null, tail = null;

        while(curr != null){
          if(newHead == null){
             newHead = curr.next;
             tail = newHead;
          }else{
            tail.next = curr.next;
            tail = curr.next;
          }

          curr.next = tail.next;
          curr = curr.next;
        }

        return newHead;
    }
}
