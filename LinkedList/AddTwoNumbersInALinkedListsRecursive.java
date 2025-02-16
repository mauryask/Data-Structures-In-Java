public class AddTwoNumbersInALinkedListsRecursive {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static int carry = 0;
    static int count1 = 0;
    static int count2 = 0;

    static void sum(Node head1, Node head2) {
        if (head1 != null || head2 != null) {

            Node nextHead1 = null;

            if (head1 != null) {
                count1++;
                nextHead1 = head1.next;
            }

            Node nextHead2 = null;

            if (head2 != null) {
                count2++;
                nextHead2 = head2.next;
            }

            sum(nextHead1, nextHead2);

            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int sum = val1 + val2 + carry;
            Node head = count1 > count2 ? head1 : head2;
            head.val = sum % 10;
            carry = sum / 10;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        head1.next = node1;
        node1.next = node2;

        Node head2 = new Node(9);
        Node node3 = new Node(7);
        Node node4 = new Node(8);
        head2.next = node3;
        node3.next = node4;

        sum(head1, head2);

        Node head = count1 > count2 ? head1 : head2;

        if (carry > 0) {
            Node temp = new Node(carry);
            temp.next = head;
            head = temp;
        }

        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
