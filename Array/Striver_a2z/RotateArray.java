package Array.Striver_a2z;

public class RotateArray {
    static class Solution {
        public void rotate(int[] nums, int k) {
            /*
             * Pseudocode:
             * 1. Get array length n.
             * 2. Normalize k by doing k = k % n (to handle k > n).
             * 3. Reverse the whole array (0 to n-1).
             * 4. Reverse the first k elements (0 to k-1).
             * 5. Reverse the remaining elements (k to n-1).
             * 
             * Example: [1,2,3,4,5], k=2
             * Reverse all: [5,4,3,2,1]
             * Reverse first 2: [4,5,3,2,1]
             * Reverse rest: [4,5,1,2,3] -> Correct Right Rotation
             */

            int n = nums.length;
            if (n == 0) {
                return;
            }
            k = k % n; // Handle cases where k >= n

            // Step 1: Reverse the entire array
            reverseArray(nums, 0, n - 1);

            // Step 2: Reverse the first k elements
            reverseArray(nums, 0, k - 1);

            // Step 3: Reverse the rest
            reverseArray(nums, k, n - 1);
        }

        public void reverseArray(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        System.out.print("Original array: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println("\nRotation k=" + k);

        Solution sl = new Solution();
        sl.rotate(arr, k);

        System.out.print("Rotated array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
