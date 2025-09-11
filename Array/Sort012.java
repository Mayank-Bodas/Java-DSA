/*
    DUTCH NATIONAL FLAG ALGORITHM.
    Maintain three pointers: low, mid, high to partition the array into 0s, 1s, and 2s.

    Traverse while mid <= high: swap 0s to the left, 2s to the right, leave 1s in the middle.

    Continue until all elements are processed → sorted array in-place in O(n) time, O(1) space.
*/

package Array;

public class Sort012 {
    public void sortColors(int[] nums) {
        // Initialize three pointers
        int low = 0; // boundary for 0s
        int mid = 0; // current element under consideration
        int high = nums.length - 1; // boundary for 2s

        // Process elements until mid crosses high
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Case 1: Current element is 0 → swap with low, expand both low and mid
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Case 2: Current element is 1 → already in correct region, just move mid
                mid++;
            } else {
                // Case 3: Current element is 2 → swap with high, shrink high
                // (don't increment mid yet because new nums[mid] must be checked)
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
