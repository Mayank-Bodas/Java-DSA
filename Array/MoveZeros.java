package Array;

class MoveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0;
        // 'left' marks the position where the next non-zero element should go.

        // Traverse the array with 'right' pointer
        for (int right = 0; right < nums.length; right++) {

            // If current element is non-zero
            if (nums[right] != 0) {

                // Swap nums[right] with nums[left]
                // This puts the non-zero element at the correct position in front
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                // Move 'left' forward since we just placed a non-zero at that index
                left++;
            }
        }
    }
}
