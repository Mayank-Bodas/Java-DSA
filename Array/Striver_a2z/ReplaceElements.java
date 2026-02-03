package Array.Striver_a2z;

import java.util.Arrays;

public class ReplaceElements {
    static class Solution {
        public int[] replaceElements(int[] arr) {
            /*
             * Pseudocode (Reverse Iteration - O(N)):
             * 1. Initialize 'maxi' to -1.
             * 2. Traverse the array from the end (right to left):
             * a. Store current element in 'temp'.
             * b. Update current position arr[i] with 'maxi'.
             * c. Update 'maxi' = max(maxi, temp).
             * 3. Return the modified array.
             */

            int n = arr.length;
            int maxi = -1;

            for (int i = n - 1; i >= 0; i--) {
                int temp = arr[i];
                arr[i] = maxi;
                maxi = Math.max(maxi, temp);
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        // Example: [17, 18, 5, 4, 6, 1]
        // Output: [18, 6, 6, 6, 1, -1]
        int[] arr = { 17, 18, 5, 4, 6, 1 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        Solution sl = new Solution();
        int[] result = sl.replaceElements(arr);

        System.out.println("Modified Array: " + Arrays.toString(result));
    }
}
