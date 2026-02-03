package BinarySearch;

public class SearchInsert {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            /*
             * Pseudocode (Search Insert Position - O(log N)):
             * This problem is exactly the same as finding the Lower Bound.
             * We need to find the index where 'target' can be inserted while keeping the
             * array sorted.
             * This corresponds to the first index 'i' where nums[i] >= target.
             * 
             * 1. Initialize low=0, high=n-1, ans=n.
             * 2. Loop while low <= high:
             * a. mid = low + (high-low)/2.
             * b. If nums[mid] >= target:
             * - This is a possible position. ans = mid.
             * - Search left for a potentially earlier position: high = mid - 1.
             * c. Else (nums[mid] < target):
             * - Target must be to the right: low = mid + 1.
             * 3. Return 'ans'.
             */

            int low = 0;
            int high = nums.length - 1;
            int ans = nums.length;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] >= target) {
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
        // Example 1: [1, 3, 5, 6], Target 5 -> Index 2
        // Example 2: [1, 3, 5, 6], Target 2 -> Index 1
        // Example 3: [1, 3, 5, 6], Target 7 -> Index 4 (size of array)

        int[] arr = { 1, 3, 5, 6 };
        Solution sl = new Solution();

        System.out.println("Array: 1 3 5 6");
        System.out.println("Target 5 -> Insert Pos: " + sl.searchInsert(arr, 5));
        System.out.println("Target 2 -> Insert Pos: " + sl.searchInsert(arr, 2));
        System.out.println("Target 7 -> Insert Pos: " + sl.searchInsert(arr, 7));
        System.out.println("Target 0 -> Insert Pos: " + sl.searchInsert(arr, 0));
    }
}
