package BinarySearch;

public class FindRotation {
    static class Solution {
        public int findRotationCount(int[] nums) {
            /*
             * Pseudocode (Find Rotation Count - O(log N)):
             * The number of rotations in a rotated sorted array is equal to the INDEX of
             * the minimum element.
             * 
             * 1. Use the logic to finding the Minimum in Rotated Sorted Array.
             * 2. Initialize low = 0, high = n-1.
             * 3. Loop while low < high:
             * a. mid = (low + high) / 2.
             * b. If nums[mid] > nums[high]:
             * - Minimum is in right half: low = mid + 1.
             * c. Else:
             * - Minimum is at mid or left: high = mid.
             * 4. Return 'low' (which is the index of the minimum element).
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
            return low;
        }
    }

    public static void main(String[] args) {
        // Example: [3, 4, 5, 1, 2] -> Min is 1 at index 3. Rotations: 3.
        // [1, 2, 3, 4, 5] -> Min is 1 at index 0. Rotations: 0.

        int[] arr = { 3, 4, 5, 1, 2 };
        Solution sl = new Solution();

        System.out.println("Array: 3 4 5 1 2");
        System.out.println("Rotation Count: " + sl.findRotationCount(arr));

        int[] arr2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Array: 4 5 6 7 0 1 2 -> Rotation Count: " + sl.findRotationCount(arr2));

        int[] arr3 = { 1, 2, 3, 4 };
        System.out.println("Array: 1 2 3 4 -> Rotation Count: " + sl.findRotationCount(arr3));
    }
}
