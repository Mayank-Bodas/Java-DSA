package Array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // Step 1: Find the first index from the end where nums[i-1] < nums[i]
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        // If no such index is found, it means the array is in descending order
        // This is the last permutation, so we just reverse to get the first permutation
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 2: Find the element just larger than nums[i-1] to the right of it
        int j = nums.length - 1;
        while (j >= i && nums[j] <= nums[i - 1]) {
            j--;
        }

        // Step 3: Swap that element with nums[i-1]
        swap(nums, i - 1, j);

        // Step 4: Reverse the suffix (from i to end) to get the smallest order
        reverse(nums, i, nums.length - 1);
    }

    // Utility: Swap elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Utility: Reverse part of the array in-place
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
