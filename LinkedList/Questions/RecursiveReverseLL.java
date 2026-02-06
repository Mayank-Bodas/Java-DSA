package LinkedList.Questions;

public class RecursiveReverseLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Reverse Linked List - Recursive O(N)):
     * Goal: Reverse the linked list using recursion.
     * 
     * Algorithm:
     * 1. Base Case: If `head` is null or `head.next` is null:
     * - Return `head` (it's the new head of the reversed sub-list).
     * 2. Recursive Step:
     * - Call reverse on the rest of the list: `newHead = reverse(head.next)`.
     * 3. Action (Post-recursion):
     * - The next node (`head.next`) should point back to `head`.
     * - `head.next.next = head`.
     * - Break the old link: `head.next = null` (to avoid cycles).
     * 4. Return `newHead` (which is the last node of original list).
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);

        // Reverse the link
        head.next.next = head;
        // Break the current link
        head.next = null;

        return newHead;
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
