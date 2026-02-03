package Array.Striver_a2z;

import java.util.ArrayList;

public class UnionArray {
    static class Solution {
        // Union usually asks to return the list of elements in the union.
        // Assuming sorted arrays as input based on the two-pointer logic used
        // previously.
        public ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
            /*
             * Pseudocode:
             * 1. Initialize pointers i=0, j=0.
             * 2. Initialize an empty list 'union'.
             * 3. Loop while i < n and j < m:
             * a. If arr1[i] <= arr2[j]:
             * - If 'union' is empty or last element != arr1[i], add arr1[i].
             * - Increment i.
             * b. Else (arr1[i] > arr2[j]):
             * - If 'union' is empty or last element != arr2[j], add arr2[j].
             * - Increment j.
             * 4. If elements remain in arr1, add them (checking for duplicates).
             * 5. If elements remain in arr2, add them (checking for duplicates).
             * 6. Return 'union'.
             */

            int i = 0, j = 0;
            ArrayList<Integer> union = new ArrayList<>();

            while (i < n && j < m) {
                if (arr1[i] <= arr2[j]) {
                    // Add to union if empty or not a duplicate of the last added element
                    if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                        union.add(arr1[i]);
                    }
                    i++;
                } else {
                    if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                        union.add(arr2[j]);
                    }
                    j++;
                }
            }

            // Add remaining elements of arr1
            while (i < n) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            }

            // Add remaining elements of arr2
            while (j < m) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
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
        ArrayList<Integer> result = sl.findUnion(arr1, arr2, arr1.length, arr2.length);

        System.out.println("Union of arrays:");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
