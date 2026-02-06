package LinkedList.Intro;

public class DoublyLinkedListCRUD {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    // 1. Insert at Head - O(1)
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            head.prev = newNode;
        }
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
        newNode.prev = temp;
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

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    // 4. Delete Value - O(N)
    public void deleteValue(int value) {
        if (head == null)
            return;

        if (head.data == value) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found!");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
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

    // 6. Display Forward - O(N)
    public void displayForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 7. Display Backward (to check prev pointers) - O(N)
    public void displayBackward() {
        if (head == null)
            return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedListCRUD dll = new DoublyLinkedListCRUD();

        System.out.println("Inserting 10, 20, 30 at tail:");
        dll.insertAtTail(10);
        dll.insertAtTail(20);
        dll.insertAtTail(30);
        dll.displayForward(); // 10 <-> 20 <-> 30 <-> null
        dll.displayBackward(); // 30 <-> 20 <-> 10 <-> null

        System.out.println("\nInserting 5 at head:");
        dll.insertAtHead(5);
        dll.displayForward(); // 5 <-> 10 <-> 20 <-> 30 <-> null

        System.out.println("\nInserting 15 at position 3:");
        dll.insertAtPosition(15, 3);
        dll.displayForward(); // 5 <-> 10 <-> 15 <-> 20 <-> 30 <-> null
        dll.displayBackward(); // Check logic consistency

        System.out.println("\nDeleting 15:");
        dll.deleteValue(15);
        dll.displayForward(); // 5 <-> 10 <-> 20 <-> 30 <-> null

        System.out.println("\nDeleting Head (5):");
        dll.deleteValue(5);
        dll.displayForward(); // 10 <-> 20 <-> 30 <-> null
        dll.displayBackward(); // 30 <-> 20 <-> 10 <-> null
    }
}
