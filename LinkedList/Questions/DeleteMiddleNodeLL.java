public class DeleteMiddleNodeLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Delete Middle Node - O(N)):
     * Goal: Delete the middle node of the linked list.
     * If size is even, delete the second middle node (0-based floor(n/2) index).
     * 
     * Algorithm:
     * 1. Edge Case: If head is null usually return null. If head.next is null (1
     * node),
     * delete it and return null.
     * 2. Initialize pointers:
     * - `slow` = head
     * - `fast` = head.next.next
     * - By starting `fast` 2 steps ahead, `slow` will point to the node *before*
     * the middle
     * when `fast` reaches the end.
     * 3. Traverse Loop:
     * - While `fast` is not null and `fast.next` is not null:
     * - slow = slow.next
     * - fast = fast.next.next
     * 4. Delete Middle:
     * - `slow.next = slow.next.next`
     * 5. Return `head`.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static Node deleteMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now before the middle node
        slow.next = slow.next.next;
        return head;
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
        // Middle is 3. Result: 1 -> 2 -> 4 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        System.out.println("Original List 1:");
        printList(head1);

        Node res1 = deleteMiddleNode(head1);
        System.out.println("After deleting middle:");
        printList(res1);

        // Test Case 2: Even length (1 -> 2 -> 3 -> 4)
        // Middle is 3 (Index 2). Result: 1 -> 2 -> 4
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);

        System.out.println("\nOriginal List 2:");
        printList(head2);

        Node res2 = deleteMiddleNode(head2);
        System.out.println("After deleting middle:");
        printList(res2);

        // Test Case 3: Two Nodes (1 -> 2)
        // Middle is 2. Result: 1
        Node head3 = new Node(1);
        head3.next = new Node(2);

        System.out.println("\nOriginal List 3:");
        printList(head3);

        Node res3 = deleteMiddleNode(head3);
        System.out.println("After deleting middle:");
        printList(res3);
    }
}
