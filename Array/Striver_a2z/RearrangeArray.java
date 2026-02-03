package Array.Striver_a2z;

import java.util.Arrays;

public class RearrangeArray {
    static class Solution {
        public int[] rearrangeArray(int[] nums) {
            /*
             * Pseudocode (Optimal - O(N)):
             * 1. Create a result array 'ans' of size n.
             * 2. Initialize pointers:
             * - pos = 0 (for positive numbers, at even indices).
             * - neg = 1 (for negative numbers, at odd indices).
             * 3. Traverse the input array:
             * a. If nums[i] > 0:
             * - Place it at ans[pos].
             * - Increment pos by 2.
             * b. Else:
             * - Place it at ans[neg].
             * - Increment neg by 2.
             * 4. Return 'ans'.
             * 
             * Note: Hints assume equal number of positive and negative elements,
             * which is the standard constraint for this LeetCode problem (2149).
             */

            int n = nums.length;
            int[] ans = new int[n];
            int pos = 0;
            int neg = 1;

            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    ans[pos] = nums[i];
                    pos += 2;
                } else {
                    ans[neg] = nums[i];
                    neg += 2;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        // Example: [3, 1, -2, -5, 2, -4]
        // Output: [3, -2, 1, -5, 2, -4]
        int[] nums = { 3, 1, -2, -5, 2, -4 };

        System.out.println("Original Array: " + Arrays.toString(nums));

        Solution sl = new Solution();
        int[] result = sl.rearrangeArray(nums);

        System.out.println("Rearranged Array: " + Arrays.toString(result));
    }
}
