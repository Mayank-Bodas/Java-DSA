public class CycleDetectionLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Detect Cycle in Linked List - O(N)):
     * Goal: Determine if the linked list has a cycle.
     * 
     * Algorithm: Floyd's Cycle-Finding Algorithm (Tortoise and Hare).
     * 1. Initialize two pointers, `slow` and `fast`, to `head`.
     * 2. Traverse the list while `fast` and `fast.next` are not null:
     * - Move `slow` one step: slow = slow.next.
     * - Move `fast` two steps: fast = fast.next.next.
     * - If `slow` meets `fast` (slow == fast), a cycle exists. Return true.
     * 3. If the loop finishes (fast reaches null), no cycle exists. Return false.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static boolean hasCycle(Node head) {
        if (head == null)
            return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1: No Cycle (1 -> 2 -> 3 -> null)
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        System.out.println("Test Case 1 (No Cycle): " + hasCycle(head1));
        // Expected: false

        // Test Case 2: Cycle (1 -> 2 -> 3 -> 4 -> 2 ...)
        Node head2 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head2.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle back to node 2

        System.out.println("Test Case 2 (Cycle): " + hasCycle(head2));
        // Expected: true
    }
}
