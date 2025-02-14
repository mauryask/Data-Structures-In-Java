
import static java.lang.System.*;

public class FindMidArrayImplementation {

    static int max = 4;
    static int size = 0;
    static int top = max;
	static int[] A = new int[max];

    static void push(int key) {
        if (size == max) {
            out.println("Overflow!!");
            return;
        }

        A[--top] = key;
        size++;
    }

    static int pop() {
        if (size == 0) {
            out.println("Underflow!!");
            return -1;
        }

        int key = A[top++];
        size--;
        return key;
    }

    static int getMid() {
        if (size == 0) {
            out.println("Underflow!!");
            return -1;
        }

        return A[(top + (max - 1)) / 2];
    }

    static int deleteMid() {
        if (size == 0) {
            out.println("Underflow!!");
            return -1;
        }

        int midIndex = (top + (max - 1)) / 2;
        int key = A[midIndex];

        for (int i = midIndex; i > top; i--) {
            A[i] = A[i - 1];
        }

        top++;
        size--;

        return key;
    }

    public static void main(String[] args) {        
        push(10);
        push(23);
        push(85);
        push(96);
        // push(102);
        out.println(pop());
        out.println("Mid: " + getMid());
        out.println("Delete mid: " + deleteMid());
        out.println("Mid: " + getMid());
        out.println(pop());
        out.println(pop());
        push(14);
        out.println(pop());
        out.println(top + " : " + size);
    }
}
