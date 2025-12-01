package Recursion;

public class PrintNTo1 {
    
    static void printNTo1(int n){
        if(n<1) return;
        System.out.println(n);
        printNTo1(n-1);
    }

    public static void main(String[] args) {
        int N = 5;
        printNTo1(N);
    }
}
