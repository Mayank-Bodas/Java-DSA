package Recursion;

public class PrintNameNTime {

    public static void printName(String name,int count,int N){
        if(count == N){
            return;
        }
        System.out.println(name);
        printName(name, count+1, N);
    }

    public static void main(String[] args) {
        int N = 5;
        String name = "Mayank";
        printName(name,0,N);
    }
}
