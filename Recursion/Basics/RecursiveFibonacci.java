package Recursion;

public class RecursiveFibonacci {
    public static int fibonacci(int N){
        if(N <= 1){
            return N;
        }

        int last = fibonacci(N-1);
        int slast = fibonacci(N-2);

        return last + slast;
    }

    public static void main(String[] args) {
        int N= 4;
        System.out.println(fibonacci(N));
    }
}
