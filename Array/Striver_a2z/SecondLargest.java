package Array.Striver_a2z;

public class SecondLargest {
    static class Solution {
        public int secondLargest(int[] arr) {
            /*
             * Pseudocode:
             * 1. Initialize 'max' with the first element of the array.
             * 2. Initialize 'secondMax' with -1 (or Integer.MIN_VALUE).
             * 3. Traverse the array.
             * 4. If the current element is greater than 'max':
             * a. Update 'secondMax' to 'max'.
             * b. Update 'max' to the current element.
             * 5. Else if the current element is less than 'max' and greater than
             * 'secondMax':
             * a. Update 'secondMax' to the current element.
             * 6. Return 'secondMax'.
             */

            // Initialize max with the first element
            int max = arr[0];
            // Initialize secondMax to -1 since array elements are assumed positive
            // If we initialize with arr[0], it might fail if arr[0] is the largest
            int secondMax = -1;

            for (int i = 0; i < arr.length; i++) {
                // Case 1: Found a new maximum
                if (arr[i] > max) {
                    secondMax = max; // Previous max becomes second largest
                    max = arr[i]; // Update max
                }
                // Case 2: Element is not max but greater than current secondMax
                else if (arr[i] < max && arr[i] > secondMax) {
                    secondMax = arr[i]; // Update second largest
                }
            }
            return secondMax;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 23, 54, 63, 19 };
        Solution sl = new Solution();
        System.out.println("Second largest element is: " + sl.secondLargest(arr));
    }
}
