package Array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        // Step 1: Handle the case when k is greater than the array length
        // Because rotating by length or its multiples doesn't change the array
        k = k % nums.length;

        // Step 2: Reverse the entire array
        // Example: [1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
        reverse(nums, 0, nums.length - 1);

        // Step 3: Reverse the first k elements
        // After previous step: [7,6,5,4,3,2,1]
        // Reverse first 3 elements -> [5,6,7,4,3,2,1]
        reverse(nums, 0, k - 1);

        // Step 4: Reverse the remaining n-k elements
        // Remaining part: [4,3,2,1] -> reverse -> [1,2,3,4]
        // Final array becomes [5,6,7,1,2,3,4]
        reverse(nums, k, nums.length - 1);
    }

    // Helper method to reverse elements in an array between two indices (inclusive)
    private void reverse(int[] nums, int left, int right) {
        // Continue swapping until the two pointers meet in the middle
        while (left < right) {
            int temp = nums[left]; // temporarily store left element
            nums[left] = nums[right]; // move right element to left position
            nums[right] = temp; // move temp (left) to right position
            left++; // move left pointer forward
            right--; // move right pointer backward
        }
    }
}
