package Array.Striver_a2z;

public class MajorityElement {
    static class Solution {
        // Function to find the majority element in an array
        public int majorityElement(int[] nums) {
            /*
             * Pseudocode (Moore's Voting Algorithm):
             * 1. Initialize 'count' = 0 and 'candidate' = 0.
             * 2. Traverse the array:
             * a. If 'count' is 0, set current element as 'candidate' and set count = 1.
             * b. Else if current element == 'candidate', increment 'count'.
             * c. Else, decrement 'count'.
             * 3. (Optional Step): Verify if 'candidate' appears > N/2 times.
             * - Traverse array and count occurrences of 'candidate'.
             * - If count > N/2, return candidate.
             * - Else, return -1 (no majority element).
             */

            // Size of the given array
            int n = nums.length;

            // Count variable
            int cnt = 0;

            // Candidate element
            int el = 0;

            // Step 1: Find the potential majority element (Moore's Voting Algorithm)
            for (int i = 0; i < n; i++) {
                if (cnt == 0) {
                    cnt = 1;
                    el = nums[i];
                } else if (el == nums[i]) {
                    cnt++;
                } else {
                    cnt--;
                }
            }

            // Step 2: Verify the candidate
            // (Strictly required if majority element is not guaranteed to exist)
            int cnt1 = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == el) {
                    cnt1++;
                }
            }

            // Return the element if it's a majority
            if (cnt1 > (n / 2)) {
                return el;
            }

            // No majority found
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };

        Solution sl = new Solution();
        int ans = sl.majorityElement(arr);

        System.out.println("The majority element is: " + ans);
    }
}