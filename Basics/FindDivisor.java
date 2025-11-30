package Basics;
import java.util.ArrayList;
import java.util.List;

public class FindDivisor {

    //Approach : 1
    // public static List<Integer> getDivisor(int N) {
    //     List<Integer> res = new ArrayList<>();
    //     for (int i = 1; i <= N; i++) {
    //         if (N % i == 0) {
    //             res.add(i);
    //         }
    //     }
    //     return res;
    // }

    //Approach 2 : Optimized
    public static List<Integer> getDivisor(int N){
        List<Integer> res = new ArrayList<>();
        for(int i =1;i*i<=N;i++){
            if(N % i ==0){
                res.add(i);

                if( i != N/i){
                    res.add(N/i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 36;
        List<Integer> result = getDivisor(N);
        System.out.println(result);
    }
}
