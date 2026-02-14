package SlidingWindow_TwoPointer;

public class BinarySubarrayWithSumK {
    static class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            /*
             * Pseudocode (Binary Subarrays With Sum - O(N)):
             * Goal: Count subarrays with sum == goal.
             * Logic:
             * count(sum == goal) = count(sum <= goal) - count(sum <= goal-1).
             * This transforms the "exact sum" problem into "at most sum" problem,
             * which is solvable with a standard sliding window.
             * 
             * Helper function atMost(nums, S):
             * 1. Initialize left=0, right=0, sum=0, count=0.
             * 2. Loop right from 0 to n-1:
             * a. sum += nums[right].
             * b. While sum > S:
             * - sum -= nums[left].
             * - left++.
             * c. count += (right - left + 1). (All subarrays ending at right with sum <=
             * S).
             * 3. Return count.
             */
            return atMost(nums, goal) - atMost(nums, goal - 1);
        }

        private int atMost(int[] nums, int goal) {
            if (goal < 0)
                return 0;

            int left = 0;
            int sum = 0;
            int count = 0;
            int n = nums.length;

            for (int right = 0; right < n; right++) {
                sum += nums[right];

                // Shrink window if sum exceeds goal
                while (sum > goal) {
                    sum -= nums[left];
                    left++;
                }

                // Add number of valid subarrays ending at 'right'
                count += (right - left + 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        // Example 1: [1,0,1,0,1], Goal=2 -> 4
        // Logic: [1,0,1], [1,0,1,0], [0,1,0,1], [1,0,1]
        int[] nums1 = { 1, 0, 1, 0, 1 };
        int k1 = 2;
        Solution sl = new Solution();
        System.out.println("Arr: [1,0,1,0,1], Goal: 2 -> " + sl.numSubarraysWithSum(nums1, k1));

        // Example 2: [0,0,0,0,0], Goal=0 -> 15 (5*6/2)
        int[] nums2 = { 0, 0, 0, 0, 0 };
        int k2 = 0;
        System.out.println("Arr: [0,0,0,0,0], Goal: 0 -> " + sl.numSubarraysWithSum(nums2, k2));
    }
}
