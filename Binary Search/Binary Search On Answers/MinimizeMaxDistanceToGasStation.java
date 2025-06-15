import static java.lang.System.*;

public class MinimizeMaxDistanceToGasStation {
    // Bruteforce way
    // T(n): (K*N)
    // S(n): O(N)
    static int[] placeNumbers(int[] A, int k) {
        // howMany[j] will store the number of gas stations placed between A[j] and A[j+1]
        int[] howMany = new int[A.length - 1]; // Corrected size: there are A.length - 1 segments

        // Try placing the number in between the numbers with longer distance
        for (int i = 1; i <= k; i++) {
            double maxValue = -1.0; // Use double for floating-point comparisons
            int maxIndex = -1;

            // Finding the distance between the consecutive numbers
            for (int j = 0; j < A.length - 1; j++) {
                // Calculate the current length of the section after placing howMany[j] stations
                double sectionLength = (double) (A[j + 1] - A[j]) / (howMany[j] + 1);

                // Picking the section with largest distance value
                if (sectionLength > maxValue) {
                    maxIndex = j;
                    maxValue = sectionLength;
                }
            }
            // Place the number at the maxIndex (Between largest section)
            howMany[maxIndex]++;
        }
        return howMany;
    }

    static double getMinSectionLength(int[] A, int[] howMany) {
        double maxDist = -1.0; // Initialize with a small value, as we're looking for the maximum of minimums
        // Finding out the minimized maxDistance
        for (int i = 0; i < A.length - 1; i++) { // Iterate through the segments
            double sectionLength = (double) (A[i + 1] - A[i]) / (howMany[i] + 1);
            if (sectionLength > maxDist) {
                maxDist = sectionLength;
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;
        int[] howMany = placeNumbers(A, k);
        double minMaxDistance = getMinSectionLength(A, howMany);
        out.println("Minimized maximum distance to a gas station: " + minMaxDistance);
    }
}