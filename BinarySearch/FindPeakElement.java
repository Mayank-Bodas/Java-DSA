package BinarySearch;

public class FindPeakElement {
    static class Solution {
        public int findPeakElement(int[] nums) {
            /*
             * Pseudocode (Find Peak Element - O(log N)):
             * Peak Element: element > neighbors.
             * 
             * 1. Initialize low = 0, high = n-1.
             * 2. Loop while low < high:
             * a. mid = (low + high) / 2.
             * b. If nums[mid] > nums[mid+1]:
             * - We are on a descending slope. The peak is either at 'mid' or to the left.
             * - high = mid.
             * c. Else (nums[mid] <= nums[mid+1]):
             * - We are on an ascending slope. The peak must be to the right.
             * - low = mid + 1.
             * 3. Return 'low' (or 'high', as they converge).
             */

            int n = nums.length;
            int low = 0, high = n - 1;

            while (low < high) {
                int mid = (low + high) / 2;

                if (nums[mid] > nums[mid + 1]) {
                    // Descending part: match or left side has peak
                    high = mid;
                } else {
                    // Ascending part: right side has peak
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        // Example 1: [1, 2, 3, 1] -> Peak is 3 (Index 2)
        int[] arr1 = { 1, 2, 3, 1 };
        Solution sl = new Solution();
        System.out.println("Array: 1 2 3 1 -> Peak Index: " + sl.findPeakElement(arr1));

        // Example 2: [1, 2, 1, 3, 5, 6, 4] -> Peak 2 (Index 1) or 6 (Index 5)
        int[] arr2 = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println("Array: 1 2 1 3 5 6 4 -> Peak Index: " + sl.findPeakElement(arr2));
    }
}
