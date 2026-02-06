package LinkedList.Intro;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SearchLL {
    public static int search(Node head, int key) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key)
                return index;
            temp = temp.next;
            index++;
        }
        return -1;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("Element found at index: " + search(head, 4));
    }
}
