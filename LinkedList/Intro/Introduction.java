package LinkedList.Intro;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Introduction {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node y = new Node(arr[0]);
        System.out.println(y.data);

    }
}
