/*
* T(n) : O(n)
* S(n) : O(1)
*/
public class TrappingRainWaterBestWay 
{
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int trappedWater = 0;

        while (left <= right) {
            // Update max height seen from left
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                trappedWater += maxLeft - height[left];
                left++;
            } else {
                // Update max height seen from right
                maxRight = Math.max(maxRight, height[right]);
                trappedWater += maxRight - height[right];
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = trap(heights);
        System.out.println("Trapped water: " + trappedWater);
    }
}

