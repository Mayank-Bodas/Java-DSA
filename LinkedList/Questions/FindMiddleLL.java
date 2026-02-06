package LinkedList.Questions;

public class FindMiddleLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Find Middle of Linked List - O(N)):
     * Goal: Return the middle node of the singly linked list.
     * 
     * Algorithm: Tortoise and Hare (Slow and Fast Pointers).
     * 1. Initialize `slow` and `fast` pointers to `head`.
     * 2. Iterate while `fast` and `fast.next` are not null:
     * - Move `slow` one step: slow = slow.next.
     * - Move `fast` two steps: fast = fast.next.next.
     * 3. When `fast` reaches the end (null or last node), `slow` will be at the
     * middle.
     * 4. Return `slow`.
     * 
     * Note: For even length 1->2->3->4, fast reaches null, slow at 3.
     * For odd length 1->2->3, fast reaches 3, slow at 2.
     */
    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
        // Test Case 1: Odd length (1 -> 2 -> 3 -> 4 -> 5)
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        System.out.println("Test Case 1 (Odd):");
        printList(head1);
        Node mid1 = findMiddle(head1);
        System.out.println("Middle: " + (mid1 != null ? mid1.data : "null"));
        // Expected: 3

        // Test Case 2: Even length (1 -> 2 -> 3 -> 4)
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);

        System.out.println("\nTest Case 2 (Even):");
        printList(head2);
        Node mid2 = findMiddle(head2);
        System.out.println("Middle: " + (mid2 != null ? mid2.data : "null"));
        // Expected: 3 (second middle) assuming requirements.
        // With loop fast!=null && fast.next!=null:
        // 1(s,f) -> 2(s), 3(f) -> 3(s), null(f) -> Stop. Returns 3. Correct.
    }
}
