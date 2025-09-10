package Array;

import java.util.*;

public class MinMax {
    public int[] getMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        MinMax obj = new MinMax();
        int[] arr = { 5, 2, 9, 34, 7 };

        int[] result = obj.getMinMax(arr);
        if (result != null) {
            System.out.println("Min = " + result[0]);
            System.out.println("Max = " + result[1]);
        } else {
            System.out.println("Array is empty!");
        }
    }
}
