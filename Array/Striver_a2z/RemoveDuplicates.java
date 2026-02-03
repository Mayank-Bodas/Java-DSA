package Array.Striver_a2z;

public class RemoveDuplicates {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            /*
             * Pseudocode:
             * 1. Check if array is empty. If so, return 0.
             * 2. Initialize 'i' as 0 (pointer for unique elements).
             * 3. Loop with 'j' from 1 to n-1.
             * 4. If nums[j] is different from nums[i]:
             * a. Increment 'i'.
             * b. Update nums[i] with nums[j].
             * 5. Return i + 1 (count of unique elements).
             */

            int n = nums.length;
            if (n == 0)
                return 0;

            int i = 0; // Slow pointer
            for (int j = 1; j < n; j++) {
                // If found a new unique element
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j]; // Move it to the next position
                }
            }

            return i + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 3, 3 };
        Solution sl = new Solution();
        int k = sl.removeDuplicates(arr);

        System.out.println("New length: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
