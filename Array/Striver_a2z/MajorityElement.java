package Array.Striver_a2z;

public class MajorityElement {
    static class Solution {
        /**
         * Finds the majority element in an array.
         * A majority element is an element that appears more than n/2 times.
         * Assumes that the majority element always exists in the array (LeetCode 169).
         * 
         * Algorithm (Boyer-Moore Voting Algorithm):
         * 1. Initialize `count` = 0 and `candidate` = 0.
         * 2. Iterate through each element `num` in the array:
         * a. If `count` is 0, we imply that previous elements have canceled each other
         * out.
         * - Set `candidate` = `num`.
         * - Set `count` = 1.
         * b. If `num` equals `candidate`, increment `count` (vote for candidate).
         * c. If `num` does not equal `candidate`, decrement `count` (vote against
         * candidate).
         * 3. Return `candidate`.
         * 
         * Time Complexity: O(N)
         * Space Complexity: O(1)
         */
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                    count = 1;
                } else if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
            return candidate;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();

        // Test Case 1: Standard case
        int[] arr1 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println("Majority Element: " + sl.majorityElement(arr1)); // Expected: 2

        // Test Case 2: Array with single element
        int[] arr2 = { 5 };
        System.out.println("Majority Element: " + sl.majorityElement(arr2)); // Expected: 5

        // Test Case 3: Alternating with majority at end
        int[] arr3 = { 3, 2, 3 };
        System.out.println("Majority Element: " + sl.majorityElement(arr3)); // Expected: 3
    }
}