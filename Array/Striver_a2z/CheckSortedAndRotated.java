package Array.Striver_a2z;

public class CheckSortedAndRotated {
    static class Solution {
        public boolean check(int[] arr) {
            /*
             * Pseudocode:
             * 1. Initialize count = 0.
             * 2. Loop through array from i = 0 to n-1.
             * 3. Compare arr[i] with arr[(i+1) % n].
             * 4. If arr[i] > arr[(i+1) % n], increment count.
             * 5. If count <= 1, return true.
             */

            int n = arr.length;
            int count = 0;

            // Loop through all elements
            for (int i = 0; i < n; i++) {
                // Check if current element is greater than the next (circularly)
                // Use (i + 1) % n to handle the last element wrapping around to the first
                if (arr[i] > arr[(i + 1) % n]) {
                    count++;
                }
            }

            if (count <= 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 5, 1, 4 };
        Solution sl = new Solution();
        System.out.println(sl.check(arr));
    }
}
