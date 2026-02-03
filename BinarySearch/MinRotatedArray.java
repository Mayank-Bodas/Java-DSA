package BinarySearch;

public class MinRotatedArray {
    static class Solution {
        public int findMin(int[] nums) {
            /*
             * Pseudocode (Minimum in Rotated Sorted Array - O(log N)):
             * 1. Initialize low = 0, high = n-1.
             * 2. Loop while low < high:
             * a. mid = (low + high) / 2.
             * b. If nums[mid] > nums[high]:
             * - The minimum must be in the right half (mid+1 to high).
             * - low = mid + 1.
             * c. Else (nums[mid] <= nums[high]):
             * - The minimum is at 'mid' or to its left.
             * - high = mid.
             * 3. Return nums[low].
             * 
             * Note: Standard Binary Search condition 'low < high' is used to converge to a
             * single index.
             */

            int low = 0;
            int high = nums.length - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return nums[low];
        }
    }

    public static void main(String[] args) {
        // Example 1: [3, 4, 5, 1, 2] -> Min is 1
        int[] arr = { 3, 4, 5, 1, 2 };
        Solution sl = new Solution();

        System.out.println("Array: 3 4 5 1 2");
        System.out.println("Min Element: " + sl.findMin(arr));

        // Example 2: [4, 5, 6, 7, 0, 1, 2] -> Min is 0
        int[] arr2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Array: 4 5 6 7 0 1 2");
        System.out.println("Min Element: " + sl.findMin(arr2));

        // Example 3: [11, 13, 15, 17] -> Min is 11
        int[] arr3 = { 11, 13, 15, 17 };
        System.out.println("Array: 11 13 15 17");
        System.out.println("Min Element: " + sl.findMin(arr3));
    }
}
