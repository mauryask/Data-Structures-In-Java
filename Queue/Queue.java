
import static java.lang.System.*;

public class Queue {

    static int max = 4;
    static int qSize = 0;
    static int rear = -1;
    static int front = -1;

    static void enque(int[] A, int key) {
        if (qSize == max) {
            out.println("Overflow!!");
            return;
        }

        if (front == -1) {
            front++;
        }
        qSize++;
        rear++;
        A[rear] = key;
    }

    static int deque(int[] A) {
        if (qSize == 0) {
            out.println("Underflow!!");
            return -1;
        }

        qSize--;
        int key = A[front];
        front++;

        if (front > rear) {
            front = rear = -1;
        }

        return key;
    }

    public static void main(String[] args) {
        int[] A = new int[max];
        enque(A, 10);
        enque(A, 85);
        enque(A, 23);
        enque(A, 9);
		// enque(A, 56);
		out.println(deque(A));
		out.println(deque(A));
		out.println(deque(A));
		out.println(deque(A));
		out.println(deque(A));
		enque(A, 233);
		out.println(deque(A));
    }
}
