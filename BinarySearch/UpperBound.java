package BinarySearch;

public class UpperBound {
    static class Solution {
        public int upperBound(int[] arr, int target) {
            /*
             * Pseudocode (Upper Bound - O(log N)):
             * Upper Bound: The smallest index 'ind' such that arr[ind] > target.
             * 
             * 1. Initialize 'low' = 0, 'high' = n-1.
             * 2. Initialize 'ans' = n.
             * 3. Loop while low <= high:
             * a. Calculate mid.
             * b. If arr[mid] > target:
             * - This could be the answer. Store it: ans = mid.
             * - Look for a smaller index on the left: high = mid - 1.
             * c. Else (arr[mid] <= target):
             * - We need a value strictly greater, so go right: low = mid + 1.
             * 4. Return 'ans'.
             */

            int low = 0;
            int high = arr.length - 1;
            int ans = arr.length; // Default if no element > target found

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] > target) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        // Example: [1, 2, 8, 10, 11, 12, 19]
        // Target 5 -> Upper Bound is 8 (index 2).
        // Target 8 -> Upper Bound is 10 (index 3).
        int[] arr = { 1, 2, 8, 10, 11, 12, 19 };

        System.out.println("Array: 1 2 8 10 11 12 19");

        Solution sl = new Solution();

        // Test Case 1: Target 5
        System.out.println("Target 5 -> Upper Bound Index: " + sl.upperBound(arr, 5));

        // Test Case 2: Target 8
        System.out.println("Target 8 -> Upper Bound Index: " + sl.upperBound(arr, 8));

        // Test Case 3: Target 20 (Not found, should return n=7)
        System.out.println("Target 20 -> Upper Bound Index: " + sl.upperBound(arr, 20));
    }
}
