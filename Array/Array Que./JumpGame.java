package Array;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // The 'goal' represents the last index we need to reach
        int goal = nums.length - 1;

        // We start checking from the second last index and move backwards
        for (int i = goal - 1; i >= 0; i--) {
            // If from the current index 'i' we can reach or go beyond the 'goal'
            if (i + nums[i] >= goal) {
                // Then we move the goal to this index
                // Meaning: now we only need to reach this index
                goal = i;
            }
        }

        // Finally, if we can move the goal all the way back to 0
        // It means we can jump from the start to the end
        return goal == 0;
    }
}
