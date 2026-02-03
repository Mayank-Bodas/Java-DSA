package BinarySearch;

public class BinarySearch {
    static class Solution {
        public int search(int[] nums, int target) {
            /*
             * Pseudocode (O(log N)):
             * 1. Initialize 'start' = 0, 'end' = n-1.
             * 2. Loop while start <= end:
             * a. Calculate mid = start + (end - start) / 2.
             * b. If nums[mid] == target, return mid.
             * c. If nums[mid] > target, target is in left half -> end = mid - 1.
             * d. If nums[mid] < target, target is in right half -> start = mid + 1.
             * 3. Return -1 if not found.
             */

            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 3, 5, 9, 12 };
        int target = 9;

        System.out.print("Array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println("\nTarget: " + target);

        Solution sl = new Solution();
        int result = sl.search(arr, target);

        System.out.println("Index: " + result);
    }
}
