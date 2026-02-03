package Array.Striver_a2z;

public class LargestElement {
    static class Solution {
        public int largest(int[] arr) {
            /*
             * Pseudocode:
             * 1. Initialize 'max' with the first element of the array.
             * 2. Traverse the array from the beginning.
             * 3. For each element, check if it is greater than 'max'.
             * 4. If yes, update 'max' with the current element.
             * 5. Continue until the end of the array.
             * 6. Return the 'max' value.
             */

            // Initialize max with the first element
            int max = arr[0];

            // Traverse the array
            for (int i = 0; i < arr.length; i++) {
                // Check if current element is greater than max
                if (arr[i] > max) {
                    max = arr[i]; // Update max
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 43, 5 };
        Solution sl = new Solution();
        System.out.println(sl.largest(arr));
    }
}
