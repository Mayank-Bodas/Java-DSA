package BinarySearch;

import java.util.Arrays;

public class FloorCeilFinder {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            /*
             * Pseudocode (Optimal - O(log N)):
             * 1. Use Binary Search to find the first occurrence (search left part if
             * found).
             * 2. Use Binary Search to find the last occurrence (search right part if
             * found).
             * 3. Return [first, last]. If not found, return [-1, -1].
             */

            int[] result = { -1, -1 };

            // Find the first occurrence (searching left)
            int left = binarySearch(nums, target, true);

            // Find the last occurrence (searching right)
            int right = binarySearch(nums, target, false);

            result[0] = left;
            result[1] = right;
            return result;
        }

        private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
            int left = 0;
            int right = nums.length - 1;
            int idx = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    idx = mid;
                    if (isSearchingLeft) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            return idx;
        }
    }

    public static void main(String[] args) {
        // Example: [5, 7, 7, 8, 8, 10]
        // Target 8 -> [3, 4]
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        Solution sl = new Solution();

        System.out.println("Array: " + Arrays.toString(nums));

        int[] res = sl.searchRange(nums, 8);
        System.out.println("Target 8 -> " + Arrays.toString(res));

        int[] res2 = sl.searchRange(nums, 6);
        System.out.println("Target 6 -> " + Arrays.toString(res2));
    }
}
