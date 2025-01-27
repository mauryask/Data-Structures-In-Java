
import java.util.*;

//T(n) : O(nk)
//S(n) : O(1)
public class MergekSortedLinkedLists {

    Node mergeSortedList(Node head1, Node head2) {
        // Hnadle edge cases
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node prev = null;
        Node head = null;

        if (head1.data < head2.data) {
            prev = head1;
            head1 = head1.next;
        } else {
            prev = head2;
            head2 = head2.next;
        }

        head = prev;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                prev.next = head1;
                prev = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                prev = head2;
                head2 = head2.next;
            }
        }

        prev.next = head1 == null ? head2 : head1;

        return head;
    }

    Node mergeKList(Node[] arr, int k) {
        if (k == 1) {
            return arr[0];
        }

        Node head1 = arr[0];
        Node head2 = null;

        for (int i = 1; i < arr.length; i++) {
            head2 = arr[i];
            //Very important consideration 
            head1 = mergeSortedList(head1, head2);
        }

        return head1;
    }

// Optimized solution using Priority Queue 
// T(n) : O(n * log k) : As we are adding n elements to the priority queue and each insertion will take log k time
// S(n) : O(k) : As at any time there will be at most k elements in the priority queue
    Node mergerKSortedLinkedLists(List<Node> arr) {
        Queue<Node> q = new PriorityQueue<>((a, b) -> a.data - b.data);
        Node dummy = new Node(0);
        Node head = dummy;

        for (Node node : arr) {
            if (node != null) //Some lists can have null as head
            {
                q.add(node);
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            dummy.next = node;
            dummy = node; // This is kind of a pointer to the last node of the merged list

            if (node.next != null) {
                q.add(node.next);
            }
        }

        return head.next;
    }
}
