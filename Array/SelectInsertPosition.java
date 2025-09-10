package Array;

public class SelectInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // Initialize two pointers for binary search
        int left = 0; // Start of the array
        int right = nums.length - 1; // End of the array

        // Perform binary search
        while (left <= right) {
            // Calculate the middle index (safe formula avoids overflow)
            int mid = left + (right - left) / 2;

            // Case 1: Target is found at mid
            if (nums[mid] == target) {
                return mid; // Return the index directly
            }

            // Case 2: Target is smaller than nums[mid]
            // → search the left half
            else if (nums[mid] > target) {
                right = mid - 1; // Move the right pointer left
            }

            // Case 3: Target is larger than nums[mid]
            // → search the right half
            else {
                left = mid + 1; // Move the left pointer right
            }
        }

        // If target is not found:
        // At this point, 'left' is the insertion position
        // because the binary search window has closed.
        return left;
    }
}
