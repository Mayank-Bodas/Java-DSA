package BinarySearch;

public class SmallestDivisorFinder {
    static class Solution {
        /*
         * Pseudocode (Smallest Divisor Given a Threshold - O(N * log(MaxElem))):
         * Goal: Find the smallest divisor 'k' such that sum(ceil(nums[i] / k)) <=
         * threshold.
         * Search Space: [1, max(nums)] (or a safe upper bound like 10^6 or
         * Integer.MAX_VALUE).
         * 
         * 1. Determine range [low, high].
         * - low = 1.
         * - high = max(nums) (since ceil(num/max) = 1, giving min possible sum =
         * length).
         * 2. Binary Search:
         * a. mid = low + (high - low) / 2.
         * b. Calculate 'sum':
         * - Iterate through array.
         * - Add ceil(num / mid) to sum.
         * - Optimization: ceil(a/b) = (a + b - 1) / b.
         * c. If sum <= threshold:
         * - Possible answer. Try smaller: high = mid. (We want *smallest* divisor)
         * - (Note: logic is slightly diff from standard BS if we want to store ans vs
         * contract range.
         * Here: if condition met, we might go lower, so high = mid).
         * d. If sum > threshold:
         * - Divisor too small (sum too big). Need larger divisor: low = mid + 1.
         * 3. Return low (or high, they converge).
         */

        public int smallestDivisor(int[] nums, int threshold) {
            int maxVal = 0;
            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }

            int low = 1;
            int high = maxVal; // Optimization: Answer won't exceed max element

            while (low < high) {
                int mid = low + (high - low) / 2; // Prevent overflow
                if (getSum(nums, mid) <= threshold) {
                    high = mid; // Try to find a smaller divisor
                } else {
                    low = mid + 1; // Increase divisor to reduce sum
                }
            }
            return low;
        }

        private int getSum(int[] nums, int divisor) {
            int sum = 0;
            for (int num : nums) {
                // Optimization: Integer arithmetic for ceil(num / divisor)
                sum += (num + divisor - 1) / divisor;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 2, 5, 9 };
        int threshold1 = 6;
        System.out.println("Test Case 1: " + solution.smallestDivisor(nums1, threshold1)); // Expected: 5

        // Test Case 2
        int[] nums2 = { 44, 22, 33, 11, 1 };
        int threshold2 = 5;
        System.out.println("Test Case 2: " + solution.smallestDivisor(nums2, threshold2)); // Expected: 44

        // Test Case 3
        int[] nums3 = { 21212, 10101, 12121 };
        int threshold3 = 1000000;
        System.out.println("Test Case 3: " + solution.smallestDivisor(nums3, threshold3)); // Expected: 1
    }
}
