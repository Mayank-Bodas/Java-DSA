package LinkedList.Questions;

public class IntersactionOfTwoLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Intersection of Two Linked Lists - O(N + M)):
     * Goal: Find the node where two linked lists intersect.
     * 
     * Algorithm (Two Pointers):
     * 1. Initialize two pointers:
     * - `d1` = head1
     * - `d2` = head2
     * 2. Traverse both lists:
     * - Move `d1` to `d1.next`. If `d1` reaches null, reset it to `head2`.
     * - Move `d2` to `d2.next`. If `d2` reaches null, reset it to `head1`.
     * 3. Rationale:
     * - If there is an intersection, both pointers will travel distance (len1 +
     * len2 + intersection_len) and meet at the intersection.
     * - If no intersection, both will travel (len1 + len2) and become null
     * simultaneously.
     * 4. Return `d1` (which is either the intersection node or null).
     * 
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     */
    public static Node findIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        Node d1 = head1;
        Node d2 = head2;

        while (d1 != d2) {
            // If d1 reaches end, switch to head2. Else next.
            d1 = d1 == null ? head2 : d1.next;

            // If d2 reaches end, switch to head1. Else next.
            d2 = d2 == null ? head1 : d2.next;
        }
        return d1;
    }

    public static void main(String[] args) {
        // Test Case 1: Intersecting Lists
        // List 1: 1 -> 2 -> 3 \
        // -> 8 -> 9 -> 10
        // List 2: 4 -> 5 /
        // Intersection at Node(8)

        Node common = new Node(8);
        common.next = new Node(9);
        common.next.next = new Node(10);

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = common;

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = common;

        Node intersection = findIntersection(head1, head2);
        System.out.println("Test Case 1 (Intersection): " + (intersection != null ? intersection.data : "null"));
        // Expected: 8

        // Test Case 2: No Intersection
        // List 1: 1 -> 2
        // List 2: 3 -> 4
        Node head3 = new Node(1);
        head3.next = new Node(2);

        Node head4 = new Node(3);
        head4.next = new Node(4);

        Node intersection2 = findIntersection(head3, head4);
        System.out.println("Test Case 2 (No Intersection): " + (intersection2 != null ? intersection2.data : "null"));
        // Expected: null
    }
}
