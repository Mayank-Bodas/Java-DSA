package LinkedList.Questions;

public class DetectCycleHeadLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Detect Cycle Start Node - O(N)):
     * Goal: Return the node where the cycle begins.
     * 
     * Algorithm: Floyd's Cycle-Finding Algorithm (Tortoise and Hare) + Entry Point
     * Logic.
     * 1. Detect Cycle:
     * - Initialize `slow` and `fast` pointers to `head`.
     * - Move `slow` one step, `fast` two steps.
     * - If they meet (`slow == fast`), a cycle exists.
     * 
     * 2. Find Entry Point:
     * - Reset `slow` to `head`.
     * - Keep `fast` at the meeting point.
     * - Move both `slow` and `fast` one step at a time until they meet again.
     * - The meeting point is the start of the cycle.
     * 
     * 3. Return `slow` (or `fast`) as the cycle head.
     * 4. If no cycle is found (fast reaches null), return null.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect Cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find Entry Point
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Cycle start node
            }
        }
        return null; // No cycle
    }

    public static void main(String[] args) {
        // Test Case 1: Cycle (1 -> 2 -> 3 -> 4 -> 2 ...)
        // Cycle starts at Node(2)
        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle back to node 2

        Node cycleStart1 = detectCycle(head1);
        System.out.println("Test Case 1 (Cycle Start): " + (cycleStart1 != null ? cycleStart1.data : "null"));
        // Expected: 2

        // Test Case 2: No Cycle (1 -> 2 -> 3 -> null)
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        Node cycleStart2 = detectCycle(head2);
        System.out.println("Test Case 2 (No Cycle): " + (cycleStart2 != null ? cycleStart2.data : "null"));
        // Expected: null
    }
}
