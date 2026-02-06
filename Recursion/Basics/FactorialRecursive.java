package Recursion;

public class FactorialRecursive {
    public static int findFactorial(int n){
        if(n==0) return 1;
        return n*findFactorial(n-1);
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(findFactorial(N));
    }
}
