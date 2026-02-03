package Array.Striver_a2z;

public class LinearSearch {
    static class Solution {
        public int search(int[] nums, int target) {
            /*
             * Pseudocode:
             * 1. Traverse the array from index 0 to n-1.
             * 2. For each element, check if it equals the target.
             * 3. If a match is found, return the current index.
             * 4. If the loop completes without finding the target, return -1.
             */

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i; // Target found, return index
                }
            }
            return -1; // Target not found
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 50, 30, 70, 80, 20 };
        int target = 30;

        System.out.print("Array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println("\nTarget: " + target);

        Solution sl = new Solution();
        int index = sl.search(arr, target);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

        // Test case for not found
        target = 99;
        System.out.println("Target: " + target);
        index = sl.search(arr, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
