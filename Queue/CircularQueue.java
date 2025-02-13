
import static java.lang.System.*;

public class CircularQueue {

    static int rear = -1;
    static int front = 0;
    static int max = 4;
    static int size = 0;

    static boolean isFull() {
        return max == size;
    }

    static boolean isEmpty() {
        return size == 0;
    }

    static void enque(int[] A, int key) {
        if (isFull()) {
            out.println("Overflow!!");
            return;
        }

        rear = (rear +1 ) % max;
        A[rear] = key;
        size++;
    }

    static int deque(int[] A) {
        if (isEmpty()) {
            out.println("Underflow!!");
            return -1;
        }

        int key = A[front];
        front = (front + 1) % max;
        size--;
        return key;
    }

    public static void main(String[] args) {
        int[] A = new int[max];
        enque(A, 12);
        enque(A, 21);
        enque(A, 33);
        enque(A, 89);
        // enque(A, 89);
        out.println(deque(A));
        out.println(deque(A));
        out.println(deque(A));
        enque(A, 15);
        enque(A, 56);
        enque(A, 7);
        // enque(A, 2);        
    }
}
