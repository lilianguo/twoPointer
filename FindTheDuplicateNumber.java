class Solution {
    // Time complexity : O(n)
    // Space complextiy: O(1)
    /*
    什么是快慢指针算法？
    从起点出发，慢指针走一步，快指针走两步。因为有环，所以一定会相遇。
    相遇之后，把其中一根指针拉回起点，重新走，这回快慢指针都各走一步。他们仍然会再次相遇，且相遇点为环的入口。

    时间复杂度是多少？
    时间复杂度是 O(n)的。
    空间复杂度 O（1）
    */
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int p1 = nums[0];
        int p2 = slow;
        while(p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}