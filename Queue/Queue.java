
import static java.lang.System.*;

public class Queue {

    static int max = 4;
    static int size = 0;
    static int rear = -1;
    static int front = 0;

    /*
  * Drawback here is, you 
  * can add anay more element even if space is available behind the rear
  * and rear is pointing to the last index (So waste of storage)
     */
    /**
     * One solution coud be shifting all the elements to left and also changing
     * the value of rear and front accrodingly for every dequeue 
   *
     */
    static boolean isFull() {
        // Either queue is actually full or rear is pointing to end index
        return size == max || rear == max - 1;
    }

    static boolean isEmpty() {
        // Either size is 0 or front crosses the rear
        return size == 0;
    }

    static void enque(int[] A, int key) {
        if (isFull()) {
            out.println("Overflow!!");
            return;
        }
        size++;
        A[++rear] = key;
    }

    static int deque(int[] A) {
        if (isEmpty()) {
            out.println("Underflow!!");
            return -1;
        }

        size--;
        int key = A[front++];

        // Reset rear and front
        if (size == 0) {
            front = 0;
            rear = -1;
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
        // out.println(deque(A));
        enque(A, 233);
        out.println(deque(A));

    }
}
