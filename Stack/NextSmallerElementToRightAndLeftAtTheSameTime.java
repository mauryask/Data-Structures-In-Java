
import static java.lang.System.*;
import java.util.*;

public class NextSmallerElementToRightAndLeftAtTheSameTime {

/*
* Why is it working: Because the stack going to keep all the elements increasing order 
* So whenever an element encountered which is greater or equal to this element 
* for the element at the top of stack the current element will be next smaller element  
**/

    static void nextAndPreviousGreator(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] smallerToLeft = new int[n];
        int[] smallerToRight = new int[n];

        for (int i = 0; i < n; i++) {
            smallerToLeft[i] = -1;
            smallerToRight[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                //for element at top of stack A[i] will be next smaller to the right 
                smallerToRight[stack.pop()] = A[i];
            }

            if (!stack.isEmpty()) {
                smallerToLeft[i] = A[stack.peek()];
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            out.print(smallerToRight[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 1, 7, 5, 9};
        nextAndPreviousGreator(A);
    }
}
