package Array.Striver_a2z;

public class MaxiSubArray {
    static class Solution {
        public int maxSubArray(int[] nums) {
            /*
             * Pseudocode (Kadane's Algorithm - O(N)):
             * 1. Initialize 'maxi' to Long.MIN_VALUE (or nums[0]).
             * 2. Initialize 'sum' to 0.
             * 3. Traverse through the array:
             * a. Add current element to 'sum'.
             * b. Update 'maxi' if 'sum' > 'maxi'.
             * c. If 'sum' becomes negative, reset 'sum' to 0. (A negative sum prefix won't
             * help maximize future subarrays).
             * 4. Return (int) maxi.
             * 
             * Note: Using 'long' for sum/maxi helps avoid overflow during intermediate
             * calculations,
             * though the final result is cast to int.
             */

            long maxi = Long.MIN_VALUE;
            long sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];

                if (sum > maxi) {
                    maxi = sum;
                }

                // If sum becomes negative, discard it
                if (sum < 0) {
                    sum = 0;
                }
            }
            return (int) maxi;
        }
    }

    public static void main(String[] args) {
        // Example: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        // Max subarray is [4, -1, 2, 1] with sum 6.
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.print("Array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        Solution sl = new Solution();
        int maxSum = sl.maxSubArray(arr);

        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
}
