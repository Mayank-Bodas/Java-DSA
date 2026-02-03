package Array.Striver_a2z;

public class SortZeroOneTwo {

    static class Solution {
        public void sortColors(int[] nums) {
            /*
             * Pseudocode (Dutch National Flag Algorithm - O(N)):
             * 1. Initialize three pointers:
             * - low = 0 (boundary for 0s)
             * - mid = 0 (current element being processed)
             * - high = n-1 (boundary for 2s)
             * 2. Loop while mid <= high:
             * a. If nums[mid] == 0:
             * - Swap nums[low] and nums[mid].
             * - Increment low and mid.
             * b. If nums[mid] == 1:
             * - Just increment mid (it's in the correct place for now).
             * c. If nums[mid] == 2:
             * - Swap nums[mid] and nums[high].
             * - Decrement high.
             * - (Do not increment mid, because the swapped element from high needs to be
             * checked).
             * 3. The array is sorted in-place.
             */

            int low = 0;
            int mid = 0;
            int high = nums.length - 1;

            while (mid <= high) {
                if (nums[mid] == 0) {
                    // Swap nums[low] and nums[mid]
                    int temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;

                    low++;
                    mid++;
                } else if (nums[mid] == 1) {
                    mid++;
                } else { // nums[mid] == 2
                    // Swap nums[mid] and nums[high]
                    int temp = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp;

                    high--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 2, 1, 1, 0 };

        System.out.print("Original array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        Solution sl = new Solution();
        sl.sortColors(arr);

        System.out.print("Sorted array: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
