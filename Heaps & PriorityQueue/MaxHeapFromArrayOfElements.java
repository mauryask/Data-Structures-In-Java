
import static java.lang.System.*;

public class MaxHeapFromArrayOfElements {
    // initialize the heap size
    // with the number of the elements in 
    // the heap 

    static int heapSize;

    // O(logn)
    static void maxHeapify(int[] A, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < heapSize && A[l] > A[largest]) {
            largest = l;
        }
        if (r < heapSize && A[r] > A[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = A[largest];
            A[largest] = A[i];
            A[i] = temp;
            maxHeapify(A, largest);
        }
    }

    // print heap	
    static void printHeap(int A[]) {
        for (int i = 0; i < heapSize; i++) {
            out.print(A[i] + " ");
        }
        out.println();
    }

    // O(n)
    // Since it is done only once
    static void buildHeap(int A[]) {
		// Start heapifying from non-leaf nodes only
		// As the leaf nodes have only one element
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    //delete max
    // O(logn)
    static int deleteMax(int A[]) {
        if (heapSize == 0) {
            return -1;
        }

        int temp = A[0];
        A[0] = A[--heapSize];
        
		//Just place element at root to its correct position
        maxHeapify(A, 0);

        return temp;
    }

// Insert an element into the Max Heap
// O(log n) time complexity
static void insertKey(int[] A, int key, int n) {
    if (heapSize == n) { // If heap is full
        out.println("Overflow!!");
        return;
    }

    // Insert the new key at the end
    int i = heapSize;
    A[i] = key;
    heapSize++;

    // Percolate Up (Bubble Up) to restore heap property
    while (i > 0 && A[(i - 1) / 2] < A[i]) { // If parent is smaller, swap
        int temp = A[i];
        A[i] = A[(i - 1) / 2];
        A[(i - 1) / 2] = temp;
        
        i = (i - 1) / 2; // Move to parent index
    }
}

    public static void main(String[] args) {
        int A[] = {10, 12, 45, 78, 96, 41, 20, 14};
        int n = A.length; // heap size
		heapSize = n; // Numer of elements currently in the heap
        buildHeap(A);
        printHeap(A);
        out.println(deleteMax(A));
        out.println(deleteMax(A));
        out.println(deleteMax(A));
        out.println(deleteMax(A));
        printHeap(A);
        insertKey(A, 35, n);
        printHeap(A);
    }
}
