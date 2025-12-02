package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ElementFreq {

    public static void countFreq(int[] arr, int n){

        //Brute Force Approach
        // boolean[] visited = new boolean[n];

        // for(int i = 0;i<n;i++){
        //     if(visited[i]){
        //         continue;
        //     }

        //     int count = 1;
        //     for(int j = i+1 ;j<n;j++){
        //         if(arr[i] == arr[j]){
        //             visited[j] = true;
        //             count++;
        //         }
        //     }
        //     System.out.println(arr[i] +" "+count);

        // }

        //Optimal Approach
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};
        int n = arr.length;
        countFreq(arr,n);
    }
}
