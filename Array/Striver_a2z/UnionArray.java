package Array.Striver_a2z;

import java.util.ArrayList;

public class UnionArray {
    static class Solution {
        /**
         * Finds the Union of two sorted arrays.
         * The union of two arrays can be defined as the common and distinct elements in
         * the two arrays.
         * 
         * Algorithm (Two Pointers):
         * 1. Initialize pointers i = 0 (for arr1) and j = 0 (for arr2).
         * 2. Initialize an empty list 'union'.
         * 3. Loop while both pointers are within bounds (i < n && j < m):
         * a. If arr1[i] <= arr2[j]:
         * - Check if 'union' is empty OR the last element added is NOT equal to arr1[i]
         * (to avoid duplicates).
         * - If true, add arr1[i] to 'union'.
         * - Increment i.
         * b. Else (arr1[i] > arr2[j]):
         * - Check if 'union' is empty OR the last element added is NOT equal to
         * arr2[j].
         * - If true, add arr2[j] to 'union'.
         * - Increment j.
         * 4. Process remaining elements of arr1:
         * - Add to 'union' if not duplicate.
         * 5. Process remaining elements of arr2:
         * - Add to 'union' if not duplicate.
         * 6. Return 'union'.
         * 
         * Time Complexity: O(N + M), where N and M are the sizes of the arrays.
         * Space Complexity: O(N + M) for the result list.
         */
        public ArrayList<Integer> findUnion(int arr1[], int arr2[]) {
            int n = arr1.length;
            int m = arr2.length;
            int i = 0, j = 0;
            ArrayList<Integer> union = new ArrayList<>();

            while (i < n && j < m) {
                // If arr1[i] is smaller or equal, we process it
                if (arr1[i] <= arr2[j]) {
                    // Add only if it's the first element or different from the last added
                    if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                        union.add(arr1[i]);
                    }
                    i++;
                } else {
                    // If arr2[j] is smaller, process it
                    if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                        union.add(arr2[j]);
                    }
                    j++;
                }
            }

            // Add remaining elements from arr1
            while (i < n) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            }

            // Add remaining elements from arr2
            while (j < m) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }

            return union;
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        int arr2[] = { 1, 2, 3, 6, 7 };

        Solution sl = new Solution();
        ArrayList<Integer> result = sl.findUnion(arr1, arr2);

        System.out.println("Union of arrays:");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Test Case 2: Duplicates
        int[] a1 = { 1, 2, 2, 3 };
        int[] a2 = { 2, 3, 3, 4 };
        System.out.println("Union of duplicates test:");
        System.out.println(sl.findUnion(a1, a2));
        // Expected: [1, 2, 3, 4]
    }
}
