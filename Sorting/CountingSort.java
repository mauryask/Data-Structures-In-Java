
/*
* Drawbacks
* Does not work with -ve numbers 
* (but you can modify it to work with -ve numbers)
* it is not good technique if k(max) >> n
* k should be of about O(n)

** The below code handles both +ve and -ve elements
 */
public class CountingSort {

    static void countingSort(int[] A, int n) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // Get the mion and max values
        for (int x : A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        // When you ddd min value in max value + 1 it gives the size of counting array
        // For example max is 10 and min -10 we will get range = 21 (it will haveindices from 0 to 20)
        int range = max - min + 1;

        int[] count = new int[range];

        // Fill the count array with frequncy of the elements
        // Insteadof putting numbers directly put num-min (normalized number) in the count array
        for (int x : A) {
            count[x - min]++;
        }

        // Update count array
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int index = --count[A[i] - min];
            output[index] = A[i];
        }

        //Copy the output array back into the original array
        for (int i = 0; i < n; i++) {
            A[i] = output[i];
        }
    }

    public static void main(String[] args) {
        //int input[] = {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
        int A[] = {5, 4, 7, 8, 9, 3, 5, 5, 7, 8, 9, 6, 3, 4};
        int n = A.length;

        countingSort(A, n);

        for (int x : A) {
            System.out.print(x + " ");
        }
    }
}
