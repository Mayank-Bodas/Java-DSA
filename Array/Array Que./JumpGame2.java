package Array;

public class JumpGame2 {
    public int jump(int[] nums) {
        int near = 0; // start of current level
        int far = 0; // end of current level
        int jumps = 0; // number of jumps taken

        // Keep jumping until we can reach or cross the last index
        while (far < nums.length - 1) {
            int farthest = 0;

            // Explore all indices in the current level (near..far)
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Move to the next level
            near = far + 1; // next level starts just after current level
            far = farthest; // next level ends at farthest reachable index
            jumps++; // used one more jump
        }

        return jumps;
    }
}
