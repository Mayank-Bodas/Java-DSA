package Recursion;

public class SumNNatural {
    public static int sumNatural(int N){
        if(N==1){
            return 1;
        }
        return N + sumNatural(N-1);
    }

    public static void main(String[] args) {
        System.out.println("Sum of Natural numbers : " +sumNatural(10));
    }
}
