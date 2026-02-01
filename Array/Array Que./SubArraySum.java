package Array;

public class SubArraySum {
    public int maxSubArray(int[] nums) {
        // maxSum will store the maximum sum found so far
        // Initialize it to the smallest possible integer so that any sum will be larger
        int maxSum = Integer.MIN_VALUE;

        // currentSum will keep the sum of the current subarray
        int currentSum = 0;

        // Loop through each element of the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the running sum
            currentSum += nums[i];

            // If currentSum is greater than maxSum, update maxSum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // If currentSum becomes negative, reset it to 0
            // Because a negative sum will decrease any future sum
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Return the maximum sum found
        return maxSum;
    }
}
