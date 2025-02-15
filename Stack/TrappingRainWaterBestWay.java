/*
* T(n) : O(n)
* S(n) : O(1)
** the idea is if leftHeight > rightHeight >> We know edge buildings between which water 
** wilol be trapped for example left is 4 and right is 3
** We know that water can be trapped on current building
** rightMax - current building height 
*/
public class TrappingRainWaterBestWay 
{
    public static int trap(int[] height) {
        int n = height.length;
        if(n< 3)
          return 0;

        //Initilize from 1 and n-1 cause water can not be stored on edge buildings  
        int left = 1, right = height.length - 2;
        //Assume edge elements as largest for now
        int maxLeft = height[0], maxRight = height[n-1];
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

