package BinarySearch;

public class SearchRotatedArray2 {
    static class Solution {
        public boolean search(int[] nums, int target) {
            /*
             * Pseudocode (Search in Rotated Sorted Array II - With Duplicates):
             * Worst Case Time Complexity: O(N) due to shrinking step. Average: O(log N).
             * 
             * 1. Initialize low = 0, high = n-1.
             * 2. Loop while low <= high:
             * a. mid = (low + high) / 2.
             * b. If nums[mid] == target, return true.
             * c. Edge Case (Duplicates):
             * - If nums[low] == nums[mid] == nums[high], we cannot determine the sorted
             * half.
             * - Shrink search space: low++, high--, then continue.
             * d. Identify sorted half (Same logic as Rotated Array I):
             * - If nums[low] <= nums[mid]: (Left half sorted)
             * - Check if target in range.
             * - Else: (Right half sorted)
             * - Check if target in range.
             * 3. Return false if not found.
             */

            int low = 0, high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    return true;
                }

                // Handle duplicates: ambiguous state
                if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                    low++;
                    high--;
                    continue;
                }

                // Identify sorted half
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target < nums[mid]) { // Use < instead of <= for mid check to avoid
                                                                     // redundancy, though <= works too if mid matched
                                                                     // earlier
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        // Example 1: [2, 5, 6, 0, 0, 1, 2], Target 0 -> true
        int[] arr = { 2, 5, 6, 0, 0, 1, 2 };
        Solution sl = new Solution();

        System.out.println("Array: 2 5 6 0 0 1 2");
        System.out.println("Target 0 -> Found: " + sl.search(arr, 0));
        System.out.println("Target 3 -> Found: " + sl.search(arr, 3));

        // Example 2: [1, 0, 1, 1, 1], Target 0 -> true
        int[] arr2 = { 1, 0, 1, 1, 1 };
        System.out.println("Array: 1 0 1 1 1, Target 0 -> Found: " + sl.search(arr2, 0));
    }
}
