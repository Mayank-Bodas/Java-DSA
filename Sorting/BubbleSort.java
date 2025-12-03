package Sorting;

public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int n = arr.length;

        for(int i = 0;i<n-1;i++){
            boolean swapped = false;

            for(int j = 0;j< n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12,34,25,11,22};
        bubbleSort(arr);
        System.out.println("Bubble Sort");
        for(int x : arr){
            System.out.println( x + " ");
        } 
    }
}
