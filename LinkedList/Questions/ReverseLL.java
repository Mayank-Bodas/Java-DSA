
public class ReverseLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Reverse Linked List - Iterative O(N)):
     * Goal: Reverse the direction of links in a singly linked list.
     * 
     * Algorithm:
     * 1. Initialize three pointers:
     * - `prev` = null (new end of list)
     * - `temp` = head (current node)
     * 2. Iterate while `temp` is not null:
     * - Store next node: `front` = temp.next
     * - Reverse link: `temp.next` = prev
     * - Move prev: `prev` = temp
     * - Move temp: `temp` = front
     * 3. Return `prev` (new head).
     */
    public static Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Case 1: Standard List (1 -> 2 -> 3 -> 4 -> 5)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        Node reversedHead = reverse(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
        // Expected: 5 -> 4 -> 3 -> 2 -> 1 -> null
    }
}
