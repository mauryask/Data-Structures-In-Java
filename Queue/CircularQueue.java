
import static java.lang.System.*;

public class CircularQueue {

    static int rear = -1;
    static int front = -1;

    static void enque(int[] A, int n, int key) {
        rear = (rear + 1) % n;

        if (front == -1) {
            front++;
        } else if (rear == front) {
            out.println("Overflow");
            return;
        }

        A[rear] = key;
    }

    static int deque(int[] A, int n) {
        if (front == -1) {
            out.println("Underflow!!");
            return -1;
        }

        int key = A[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % n;
        }

        return key;
    }

    public static void main(String[] args) {
        int[] A = new int[4];
        int n = A.length;
        enque(A, n, 12);
        enque(A, n, 34);
        enque(A, n, 7);
        enque(A, n, 32);
        // enque(A, n, 9); => Overflow
        // out.println(front + ", " + rear);
		out.println(deque(A, n));
		out.println(deque(A, n));
		// out.println(deque(A, n));
		// out.println(deque(A, n));
		// out.println(deque(A, n)); => Underflow
		out.println(front + ", " + rear);
		enque(A, n, 32);
		enque(A, n, 45);
		enque(A, n, 90);
		out.println(front + ", " + rear);
    }
}
