package Array;

import java.util.*; // (1) import utilities (not strictly needed here)

@SuppressWarnings("unused")
public class KthMaxofArray {// (2) start class
    public int findKthLargest(int[] nums, int k) { // (3) public API
        int targetIdx = nums.length - k; // (4) convert kth largest -> index in sorted order
        return quickSelect(nums, 0, nums.length - 1, targetIdx); // (5) call quickSelect on full array
    }

    private int quickSelect(int[] nums, int left, int right, int targetIdx) { // (6) helper: works on subarray
                                                                              // [left..right]
        if (left == right) // (7) base case: only one element
            return nums[left];

        int pivot = nums[right]; // (8) choose pivot = last element
        int low = left; // (9) low pointer scans from left
        int high = right - 1; // (10) high pointer scans from right-1 (pivot excluded)

        while (low <= high) { // (11) partition loop
            while (low <= high && nums[low] < pivot)
                low++; // (12) move low right until we find ≥ pivot
            while (low <= high && nums[high] > pivot)
                high--; // (13) move high left until we find ≤ pivot
            if (low <= high) { // (14) swap out-of-place elements
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }

        // (15) put pivot into its final position (swap pivot with nums[low])
        nums[right] = nums[low];
        nums[low] = pivot;

        // (16) now pivot is at index 'low' (its final sorted position)
        if (targetIdx == low) { // (17) found the answer
            return nums[low];
        } else if (targetIdx < low) { // (18) target is left of pivot → search left subarray
            return quickSelect(nums, left, low - 1, targetIdx);
        } else { // (19) target is right of pivot → search right subarray
            return quickSelect(nums, low + 1, right, targetIdx);
        }
    }

    // (20) optional main for quick test omitted here...
}
