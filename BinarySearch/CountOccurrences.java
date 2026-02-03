package BinarySearch;

public class CountOccurrences {
    static class Solution {
        public int count(int[] arr, int n, int x) {
            /*
             * Pseudocode (Optimal - O(log N)):
             * 1. Find the first occurrence of 'x' using Binary Search.
             * - If first occurrence is -1, return 0 (element not found).
             * 2. Find the last occurrence of 'x' using Binary Search.
             * 3. Count = (lastIndex - firstIndex) + 1.
             * 4. Return Count.
             */

            int first = firstOccurrence(arr, x);
            if (first == -1)
                return 0;

            int last = lastOccurrence(arr, x);
            return (last - first) + 1;
        }

        private int firstOccurrence(int[] arr, int target) {
            int low = 0, high = arr.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == target) {
                    ans = mid;
                    high = mid - 1; // Search left
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }

        private int lastOccurrence(int[] arr, int target) {
            int low = 0, high = arr.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == target) {
                    ans = mid;
                    low = mid + 1; // Search right
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        // Example: [1, 1, 2, 2, 2, 2, 3]
        // Target 2 -> Occurrences: 4
        // Target 4 -> Occurrences: 0

        int[] arr = { 1, 1, 2, 2, 2, 2, 3 };
        Solution sl = new Solution();

        System.out.println("Array: 1 1 2 2 2 2 3");

        System.out.println("Count of 2: " + sl.count(arr, arr.length, 2));
        System.out.println("Count of 4: " + sl.count(arr, arr.length, 4));
        System.out.println("Count of 1: " + sl.count(arr, arr.length, 1));
    }
}
