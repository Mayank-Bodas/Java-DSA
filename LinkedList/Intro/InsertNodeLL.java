package LinkedList.Intro;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertNodeLL {
    public static Node insertAtHead(Node head, int val) {
        Node newNode = new Node(val);
        return newNode;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtHead(head, 10);
        head = insertAtHead(head, 20);
        head = insertAtHead(head, 30);
        printLL(head);
    }
}
