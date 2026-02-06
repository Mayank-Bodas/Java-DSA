package LinkedList.Intro;

public class SinglyLinkedListCRUD {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // 1. Insert at Head - O(1)
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Insert at Tail - O(N)
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // 3. Insert at Position (1-based index) - O(N)
    public void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 4. Delete Value - O(N)
    public void deleteValue(int value) {
        if (head == null)
            return;

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found!");
            return;
        }
        temp.next = temp.next.next;
    }

    // 5. Search - O(N)
    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // 6. Display - O(N)
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedListCRUD sll = new SinglyLinkedListCRUD();

        System.out.println("Inserting 10, 20, 30 at tail:");
        sll.insertAtTail(10);
        sll.insertAtTail(20);
        sll.insertAtTail(30);
        sll.display(); // 10 -> 20 -> 30 -> null

        System.out.println("Inserting 5 at head:");
        sll.insertAtHead(5);
        sll.display(); // 5 -> 10 -> 20 -> 30 -> null

        System.out.println("Inserting 15 at position 3:");
        sll.insertAtPosition(15, 3);
        sll.display(); // 5 -> 10 -> 15 -> 20 -> 30 -> null

        System.out.println("Searching for 20: " + sll.search(20)); // true
        System.out.println("Searching for 100: " + sll.search(100)); // false

        System.out.println("Deleting 15:");
        sll.deleteValue(15);
        sll.display(); // 5 -> 10 -> 20 -> 30 -> null

        System.out.println("Deleting Head (5):");
        sll.deleteValue(5);
        sll.display(); // 10 -> 20 -> 30 -> null
    }
}
