package Array;

public class MoveNegetive {
    public void segregateElements(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;

        // Step 1: Copy all positive numbers in order
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                temp[index++] = arr[i];
            }
        }

        // Step 2: Copy all negative numbers in order
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                temp[index++] = arr[i];
            }
        }

        // Step 3: Copy back into original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
