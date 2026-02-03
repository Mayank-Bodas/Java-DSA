package BinarySearch;

public class SearchRotatedArray {
    static class Solution {
        public int search(int[] nums, int target) {
            /*
             * Pseudocode (Search in Rotated Sorted Array - O(log N)):
             * 1. Initialize low = 0, high = n-1.
             * 2. Loop while low <= high:
             * a. mid = (low + high) / 2.
             * b. If nums[mid] == target, return mid.
             * c. Identify the sorted half:
             * - If nums[low] <= nums[mid]: (Left half is sorted)
             * - If target is in range [nums[low], nums[mid]), search left: high = mid - 1.
             * - Else search right: low = mid + 1.
             * - Else: (Right half is sorted)
             * - If target is in range (nums[mid], nums[high]], search right: low = mid + 1.
             * - Else search left: high = mid - 1.
             * 3. Return -1 if not found.
             */

            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    return mid;
                }

                // Check if left half is sorted
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                // Right half must be sorted
                else {
                    if (nums[mid] < target && target <= nums[high]) { // Corrected logic: target <= nums[high]
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        // Example: [4, 5, 6, 7, 0, 1, 2], Target 0 -> Index 4
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        Solution sl = new Solution();

        System.out.println("Array: 4 5 6 7 0 1 2");
        System.out.println("Target 0 -> Index: " + sl.search(arr, 0));
        System.out.println("Target 3 -> Index: " + sl.search(arr, 3)); // Not found
        System.out.println("Target 4 -> Index: " + sl.search(arr, 4)); // Pivot edge case

        // Example 2: [3, 1], Target 1 -> Index 1
        int[] arr2 = { 3, 1 };
        System.out.println("Array: 3 1, Target 1 -> Index: " + sl.search(arr2, 1));
    }
}
