package Array;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Two pointers: one starting from the beginning, and one from the end
        int i = 0;
        int j = numbers.length - 1;

        // Loop until the two pointers meet
        while (i < j) {
            int sum = numbers[i] + numbers[j]; // Calculate the sum of the two numbers

            if (sum == target) {
                // If the sum matches the target, return their (1-based) indices
                return new int[] { i + 1, j + 1 };
            } else if (sum > target) {
                // If the sum is too large, move the right pointer left to reduce the sum
                j--;
            } else {
                // If the sum is too small, move the left pointer right to increase the sum
                i++;
            }
        }

        // This will never be reached if the input guarantees a solution
        return new int[] {};
    }
}
