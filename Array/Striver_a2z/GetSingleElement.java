package Array.Striver_a2z;

public class GetSingleElement {
    static class Solution {
        public int getSingleElement(int arr[]) {
            /*
             * Pseudocode:
             * 1. Initialize 'xor' to 0.
             * 2. Iterate through each element in the array.
             * 3. XOR the current element with 'xor'.
             * - Property: a ^ a = 0 and a ^ 0 = a.
             * - Since every element appears twice except one, all duplicates will cancel
             * out to 0.
             * - The remaining 'xor' value will be the single element.
             * 4. Return 'xor'.
             */

            int n = arr.length;
            int xor = 0;
            for (int i = 0; i < n; i++) {
                xor = xor ^ arr[i];
            }
            return xor;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 2, 1, 2 };

        System.out.print("Array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        Solution sl = new Solution();
        int single = sl.getSingleElement(arr);

        System.out.println("Single element is: " + single);
    }
}
