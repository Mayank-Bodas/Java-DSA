package Array.Striver_a2z;

public class MoveZeros {
    static class Solution {
        public void moveZeroes(int[] nums) {
            /*
             * Pseudocode (Optimal One-Pass):
             * 1. Initialize 'i' as 0 (pointer for the position of non-zero elements).
             * 2. Traverse the array with 'j' from 0 to n-1.
             * 3. If nums[j] is not zero:
             * a. Swap nums[i] and nums[j].
             * b. Increment 'i'.
             * 4. This ensures all non-zeros are moved to the front in one pass,
             * and zeros naturally accumulate at the end.
             */

            int n = nums.length;
            int i = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] != 0) {
                    // Swap nums[i] and nums[j]
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 12 };

        System.out.print("Original array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        Solution sl = new Solution();
        sl.moveZeroes(arr);

        System.out.print("Moved zeros: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
