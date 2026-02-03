package Array.Striver_a2z;

public class MaxConsecutiveones {

    static class Solution {
        public int maxConsecutiveOnes(int arr[]) {
            /*
             * Pseudocode:
             * 1. Initialize 'count' to 0 (current streak of ones) and 'maxi' to 0 (maximum
             * streak found).
             * 2. Iterate through the array.
             * 3. If the current element is 1:
             * a. Increment 'count'.
             * 4. If the current element is 0:
             * a. Update 'maxi' with Math.max(maxi, count).
             * b. Reset 'count' to 0.
             * 5. After loop ends, do one final update of 'maxi' (to capture trailing ones).
             * 6. Return 'maxi'.
             */

            int count = 0;
            int maxi = 0;
            int j = 0;

            while (j < arr.length) {
                if (arr[j] == 1) {
                    count++;
                } else {
                    maxi = Math.max(maxi, count);
                    count = 0; // Reset streak
                }
                j++;
            }
            // Final check in case the array ends with a sequence of 1s
            maxi = Math.max(maxi, count);
            return maxi;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1, 1, 0, 1, 1 };

        System.out.print("Array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        Solution sl = new Solution();
        int maxOnes = sl.maxConsecutiveOnes(arr);

        System.out.println("Max consecutive ones: " + maxOnes);
    }
}