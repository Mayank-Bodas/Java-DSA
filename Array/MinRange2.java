package Array;

import java.util.*;

public class MinRange2 {

    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Sort the array
        // This helps us easily handle smaller and larger elements separately
        Arrays.sort(arr);

        // Step 2: Initial difference (without any changes)
        int res = arr[n - 1] - arr[0];

        // Step 3: Try splitting the array at each index 'i'
        // and consider increasing the first part and decreasing the second part
        for (int i = 1; i < n; i++) {

            // If decreasing arr[i] by k makes it negative, skip this split
            if (arr[i] - k < 0) {
                continue;
            }

            // Step 4: Calculate the new minimum height after modification
            // Either from smallest element increased by k
            // or from current element decreased by k
            int minH = Math.min(arr[0] + k, arr[i] - k);

            // Step 5: Calculate the new maximum height after modification
            // Either from element just before i (increased by k)
            // or from largest element decreased by k
            int maxH = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            // Step 6: Update result if this split gives a smaller range
            res = Math.min(res, maxH - minH);
        }

        // Step 7: Return the smallest difference found
        return res;
    }
}
