import static java.lang.System.*;
import java.util.*;   

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
	
	//T(N): O(N log N + K log N)
	//S(n): O(N)
	static class GasStationInfo{
		int index;
		int count;
		
		GasStationInfo(int index, int count){
			this.index = index;
			this.count = count;
		}
	}
	
    static void betterWay(int[] A, int k){
		Queue<GasStationInfo> q = new PriorityQueue<>((a, b)->{
			double lengthA = (double)(A[a.index+1] - A[a.index])/(a.count+1);
			double lengthB = (double)(A[b.index+1] - A[b.index])/(b.count+1);
			return Double.compare(lengthB, lengthA);
		});
		
		//(N* log N)
		for(int i=0; i<A.length-1; i++){
			q.add(new GasStationInfo(i, 0));
		}
		
		//O(K * log N)
		for(int i=1; i<=k; i++){
			GasStationInfo gs = q.poll();
			gs.count++;
			q.add(gs);
		}
		
		GasStationInfo gs = q.peek();		
		double sectionLength = (double)(A[gs.index+1] - A[gs.index])/(gs.count+1);
		out.println(sectionLength);
	}
     	 
	 //Best way: binary search
	 // T(n) : O(N * log D) : Here D => (end - start : inital search range)
     static boolean check(int[] stations, double mid, int k){
        int count = 0;
        
        for(int i=0; i<stations.length-1; i++){
			//Distance between two consecutive stations
            int dist = stations[i+1] - stations[i];
            
            if(dist > mid){
				// Calculate the number of new stations needed to ensure max-distance <= mid
				// Here Math.ceil(dist/mid) gives number of segments (each of at most mid length) and substracting 1 from it gives numebr stattions to be placed
               count += Math.ceil(dist/mid) - 1;    
            }
        }
		
        // If required stations count > k, you need more than k stations to maintaina a max disatnce of at most mid
        return count <= k;
    }
    
    public static double findSmallestMaxDist(int stations[], int k) {
	   if (stations.length < 1) return 0; // Handle edge case: empty stations
	   double ans = 0;
	   // Define binary search range
	   double start = 0; // Minimum possible maximum distance between stations (If all stations placed at the same location)
	   double end = stations[stations.length - 1] - stations[0]; // Maximum distance between first and last stations
	   
	   // Binary search to find the smallest feasible maximum distance
	   while (start <= end) {
	  	  double mid = start + (end - start) / 2.0;
	  	  // Check if max distance of mid is achievable with k or fewer stations
	  	  if (check(stations, mid, k)) {
	  	 	 ans = mid; // Store potential answer
	  	 	 end = mid - 0.000001; // Try a smaller distance, maintaining 10^-6 precision
	  	  } else {
	  	 	 start = mid + 0.000001; // Try a larger distance
	  	  }
	   }
	   
	   return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;
        // int[] howMany = placeNumbers(A, k);
        // double minMaxDistance = getMinSectionLength(A, howMany);
        // out.println("Minimized maximum distance to a gas station: " + minMaxDistance);
		// solve(A, k);
		double maxDist = findSmallestMaxDist(A, k);
		out.println(maxDist);
    }
}