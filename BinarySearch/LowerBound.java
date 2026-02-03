package BinarySearch;

public class LowerBound {
    static class Solution {
        public int lowerBound(int[] arr, int target) {
            /*
             * Pseudocode (Lower Bound - O(log N)):
             * Lower Bound: The smallest index 'ind' such that arr[ind] >= target.
             * 
             * 1. Initialize 'low' = 0, 'high' = n-1.
             * 2. Initialize 'ans' = n (hypothetical index if no element >= target).
             * 3. Loop while low <= high:
             * a. Calculate mid.
             * b. If arr[mid] >= target:
             * - This 'mid' could be the answer. Store it: ans = mid.
             * - We might find a smaller index on the left, so high = mid - 1.
             * c. Else (arr[mid] < target):
             * - We need larger values, go right: low = mid + 1.
             * 4. Return 'ans'.
             */

            int low = 0;
            int high = arr.length - 1;
            int ans = arr.length; // Default to size if not found

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid] >= target) {
                    ans = mid;
                    high = mid - 1; // Look left
                } else {
                    low = mid + 1; // Look right
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        // Example: [1, 2, 8, 10, 11, 12, 19]
        // Target: 5. Lower Bound element: 8 (index 2).
        int[] arr = { 1, 2, 8, 10, 11, 12, 19 };
        int target = 5;

        System.out.println("Array: 1 2 8 10 11 12 19");
        System.out.println("Target: " + target);

        Solution sl = new Solution();
        int ind = sl.lowerBound(arr, target);

        System.out.println("Lower Bound Index: " + ind);
        if (ind < arr.length) {
            System.out.println("Lower Bound Element: " + arr[ind]);
        } else {
            System.out.println("Lower Bound Element: Not Found (index n)");
        }

        // Example 2: Target 0. LB Index 0 (Element 1).
        System.out.println("Target 0 -> LB Index: " + sl.lowerBound(arr, 0));

        // Example 3: Target 20. LB Index 7 (Out of bounds).
        System.out.println("Target 20 -> LB Index: " + sl.lowerBound(arr, 20));
    }
}
