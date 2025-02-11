/*
* Time Complexity : O(d * (n+b))
* d : is number of digits in largest element
* b : base of the nubers (here 10 in our case)
* if you want to sort alphabets then, b = 26
* n : ofcourse number of elements
**/

public class RadixSort {

    static void countingSort(int input[], int factor, int n) // O(n+b)
    {
        int count[] = new int[10];
        int output[] = new int[n];

        //fill the coutn array with frequency of last digit in each nuber
        for (int i = 0; i < n; i++) {
            count[(input[i] / factor) % 10]++;
        }

        //update the count array
        for (int i = 1; i < 10; i++) // O(b)
        {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = --count[(input[i] / factor) % 10];
            output[index] = input[i];
        }

        //copy the output array into input array
        for (int i = 0; i < n; i++) {
            input[i] = output[i];
        }
    }

    static void radixSort(int A[], int n) // O(n) + O(d*(n+b))
    {
        int max = Integer.MIN_VALUE;

        for (int x : A) {
            max = Math.max(max, x);
        }

        // O(d), where d = number of digits in largest number
        for (int factor = 1; max / factor > 0; factor *= 10) {
            countingSort(A, factor, n);
        }
    }

    public static void main(String[] args) {
        int input[] = {10, 3, 273, 40, 375, 110, 99};

        radixSort(input, input.length);

        for (int x : input) {
            System.out.print(x + " ");
        }
    }
}
