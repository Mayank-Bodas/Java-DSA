package SlidingWindow_TwoPointer;

public class CountNumOfNiceSubarray {
    static class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            /*
             * Pseudocode (Count Number of Nice Subarrays - O(N)):
             * Goal: Count subarrays with EXACTLY 'k' odd numbers.
             * Logic:
             * count(exactly k) = count(atMost k) - count(atMost k-1).
             * Transform Odd -> 1, Even -> 0.
             * Then it's exactly "Binary Subarrays with Sum k".
             * 
             * Helper function atMost(nums, maxK):
             * 1. Initialize left=0, right=0, odds=0, count=0.
             * 2. Loop right from 0 to n-1:
             * a. If nums[right] is odd, odds++.
             * b. While odds > maxK:
             * - If nums[left] is odd, odds--.
             * - left++.
             * c. count += (right - left + 1). (All subarrays ending at right with odds <=
             * maxK).
             * 3. Return count.
             */
            return atMost(nums, k) - atMost(nums, k - 1);
        }

        private int atMost(int[] nums, int k) {
            if (k < 0)
                return 0;

            int left = 0;
            int odds = 0;
            int count = 0;
            int n = nums.length;

            for (int right = 0; right < n; right++) {
                if (nums[right] % 2 != 0) {
                    odds++;
                }

                // Shrink window if odd count exceeds k
                while (odds > k) {
                    if (nums[left] % 2 != 0) {
                        odds--;
                    }
                    left++;
                }

                count += (right - left + 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        // Example 1: [1,1,2,1,1], k=3 -> 2 ([1,1,2,1], [1,2,1,1])
        int[] nums1 = { 1, 1, 2, 1, 1 };
        int k1 = 3;
        Solution sl = new Solution();
        System.out.println("Arr: [1,1,2,1,1], K: 3 -> " + sl.numberOfSubarrays(nums1, k1));

        // Example 2: [2,4,6], k=1 -> 0
        int[] nums2 = { 2, 4, 6 };
        int k2 = 1;
        System.out.println("Arr: [2,4,6], K: 1 -> " + sl.numberOfSubarrays(nums2, k2));

        // Example 3: [2,2,2,1,2,2,1,2,2,2], k=2 -> 16
        int[] nums3 = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k3 = 2;
        System.out.println("Arr: [2,2,2,1,2,2,1,2,2,2], K: 2 -> " + sl.numberOfSubarrays(nums3, k3));
    }
}
