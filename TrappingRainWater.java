/*
As in Approach 2, instead of computing the left and right parts seperately, we may think of some way to do it in one iteration. 
From the figure in dynamic programming approach, 
notice that as long as right_max[i]>left_max[i], the water trapped depends upon the left_max, 
and similar is the case when left_max[i]>right_max[i]. 
So, we can say that:
 if there is a larger bar at one end (say right), we are assured that the water trapped would be dependant on height of bar in current direction (from left to right). 
 As soon as we find the bar at other end (right) is smaller, we start iterating in opposite direction (from right to left). 
 We must maintain left_max and right_max during the iteration, but now we can do it in one iteration using 2 pointers, 
 switching between the two.

Algorithm

    Initialize left pointer to 0 and right pointer to size - 1
    While left<right, do:
        If height[left] is smaller than height[right]
            * if height[left] >= left_max, update left_max
            * else, add left_max - height[left] to res
            add 1 to variable left
        Else
            * If height[right] >= right_max, update right_max
            * Else, add right_max - height[right] to res
            * subtract 1 from right

*/
class TrappingTrainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left_max = height[0];
        int right_max = height[height.length - 1];
        int res = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    res += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                    right--;
                } else {
                    res += right_max - height[right];
                }
                right--;
            }
        }
        return res;
    }

    
}
