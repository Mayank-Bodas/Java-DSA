package Array;

public class MergeTwoArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer to the last valid element in nums1
        int midx = m - 1;

        // Pointer to the last element in nums2
        int nidx = n - 1;

        // Pointer to the last position in nums1 (where merged elements go)
        int right = m + n - 1;

        // While there are elements left in nums2
        while (nidx >= 0) {
            // If there are elements in nums1 AND current nums1 element is larger than nums2 element
            if (midx >= 0 && nums1[midx] > nums2[nidx]) {
                nums1[right] = nums1[midx];  // place the larger element at the end
                midx--;                       // move left in nums1
            } else {
                // Otherwise, place the nums2 element
                nums1[right] = nums2[nidx];
                nidx--;                       // move left in nums2
            }
            right--;  // move the merged pointer to the left
        }
    }
}
