package Array.Striver_a2z;

public class MissingNumber {
    static class Solution {
        public int missingNumber(int[] arr) {
            /*
             * Pseudocode:
             * 1. Get the length of array 'n'.
             * 2. Calculate the expected sum of first 'n' numbers using formula n*(n+1)/2.
             * 3. Calculate the actual sum of elements in the array.
             * 4. The missing number is expectedSum - actualSum.
             * 
             * Note: The input array typically contains numbers from 0 to n.
             * if length is n, numbers are 0, 1, ..., n. (so one is missing).
             * But usually "Missing Number" problem on LeetCode (268) is:
             * Given array nums containing n distinct numbers in range [0, n].
             * Return the only number in range that is missing from the array.
             * 
             * Wait, if array has length 'n', it usually means there are n numbers.
             * If range is [0, n], there are n+1 possible numbers.
             * So expected sum should be for range [0, n], i.e., n*(n+1)/2.
             * And actual sum is sum of array elements.
             * 
             * Let's check the user's logic:
             * n = arr.length;
             * expectedSum = n * (n + 1) / 2;
             * This formula is for sum of 1 to n. Or 0 to n.
             * This matches LeetCode 268 logic.
             */

            int n = arr.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }

            // Expected sum of numbers from 0 to n
            int expectedSum = n * (n + 1) / 2;

            return expectedSum - sum;
        }
    }

    public static void main(String[] args) {
        // Example: Array of size 3, containing [3, 0, 1]. Range [0, 3]. Missing 2.
        int[] arr = { 3, 0, 1 };

        System.out.print("Array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        Solution sl = new Solution();
        int missing = sl.missingNumber(arr);

        System.out.println("Missing Number: " + missing);

        // Example 2: [0, 1]. Range [0, 2]. Missing 2.
        int[] arr2 = { 0, 1 };
        System.out.println("Missing Number for {0,1}: " + sl.missingNumber(arr2));
    }
}