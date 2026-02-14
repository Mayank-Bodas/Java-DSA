package SlidingWindow_TwoPointer;

public class LongestOnes {
    static class Solution {
        public int longestOnes(int[] nums, int k) {
            /*
             * Pseudocode (Max Consecutive Ones III - O(N) Sliding Window):
             * Goal: Find longest subarray with at most 'k' zeros.
             * 
             * 1. Initialize left = 0, right = 0, zeros = 0, maxLen = 0.
             * 2. Loop right from 0 to n-1:
             * a. If nums[right] == 0, increment zeros.
             * b. If zeros > k:
             * - Shrink window from left.
             * - If nums[left] == 0, decrement zeros.
             * - left++.
             * c. Update maxLen = max(maxLen, right - left + 1).
             * 3. Return maxLen.
             */

            int left = 0, right = 0;
            int zeros = 0;
            int maxLen = 0;
            int n = nums.length;

            while (right < n) {
                if (nums[right] == 0) {
                    zeros++;
                }

                // Shrink if zeros exceed k
                while (zeros > k) {
                    if (nums[left] == 0) {
                        zeros--;
                    }
                    left++;
                }

                if (zeros <= k) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                right++;
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        // Example 1: [1,1,1,0,0,0,1,1,1,1,0], K=2 -> Output: 6
        int[] nums1 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k1 = 2;
        Solution sl = new Solution();
        System.out.println("Arr: [1,1,1,0,0,0,1,1,1,1,0], K=2 -> " + sl.longestOnes(nums1, k1));

        // Example 2: [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K=3 -> Output: 10
        int[] nums2 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k2 = 3;
        System.out.println("Arr: [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K=3 -> " + sl.longestOnes(nums2, k2));
    }
}
