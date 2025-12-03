package Sorting;

public class SelctionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };

        selectionSort(arr);
        System.err.println("Selection Sort:");
        for (int x : arr) {
            System.out.println(x + " ");
        }
    }
}
