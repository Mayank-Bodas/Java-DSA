package Array;

public class DuplicateInArray {
    public int findDuplicate(int[] nums) {
        // Step 1: Initialize two pointers (slow and fast)
        // Both start from the first element of the array
        int slow = nums[0];
        int fast = nums[0];

        // Step 2: Detect the cycle
        // Move slow by 1 step and fast by 2 steps until they meet
        // This works because the problem guarantees there is one duplicate number
        while (true) {
            slow = nums[slow]; // slow moves 1 step
            fast = nums[nums[fast]]; // fast moves 2 steps

            if (slow == fast) { // cycle detected when both meet
                break;
            }
        }

        // Step 3: Find the entry point of the cycle
        // Initialize another pointer from the start
        int slow2 = nums[0];

        // Move both pointers by 1 step until they meet
        // The point where they meet is the duplicate number
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        // Step 4: Return the duplicate number
        return slow;
    }
}
