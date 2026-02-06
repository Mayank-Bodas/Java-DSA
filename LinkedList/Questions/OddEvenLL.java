public class OddEvenLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Odd Even Linked List - O(N)):
     * Goal: Group all nodes with odd indices together followed by nodes with even
     * indices.
     * (Note: 1-based indexing: 1st node is Odd, 2nd is Even).
     * 
     * Algorithm:
     * 1. If head is null or head.next is null, return head.
     * 2. Initialize pointers:
     * - `odd` = head (1st node)
     * - `even` = head.next (2nd node)
     * - `evenHead` = head.next (to remember the start of even list)
     * 3. Iterate while `even` and `even.next` are not null:
     * - Link current odd to next odd: `odd.next = even.next`.
     * - Move odd pointer: `odd = odd.next`.
     * - Link current even to next even: `even.next = odd.next`.
     * - Move even pointer: `even = even.next`.
     * 4. Connect the end of odd list to the start of even list:
     * - `odd.next = evenHead`.
     * 5. Return `head` (start of odd list).
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even; // Store start of even list

        while (even != null && even.next != null) {
            // odd points to next odd node (skipping even)
            odd.next = even.next;
            odd = odd.next;

            // even points to next even node (skipping odd)
            even.next = odd.next;
            even = even.next;
        }

        // Connect tail of odd list to head of even list
        odd.next = evenHead;

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
        // Test Case 1: Standard List (1 -> 2 -> 3 -> 4 -> 5)
        // Odd indices: 1, 3, 5. Even indices: 2, 4.
        // Result: 1 -> 3 -> 5 -> 2 -> 4 -> null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        System.out.println("Original List 1:");
        printList(head1);

        Node res1 = oddEvenList(head1);
        System.out.println("Odd-Even List 1:");
        printList(res1);
        // Expected: 1 -> 3 -> 5 -> 2 -> 4 -> null

        // Test Case 2: Even length (2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7)
        // Indices: 1(2), 2(1), 3(3), 4(5), 5(6), 6(4), 7(7)
        // Odds: 2, 3, 6, 7. Evens: 1, 5, 4.
        // Result: 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4 -> null
        Node head2 = new Node(2);
        head2.next = new Node(1);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(5);
        head2.next.next.next.next = new Node(6);
        head2.next.next.next.next.next = new Node(4);
        head2.next.next.next.next.next.next = new Node(7);

        System.out.println("\nOriginal List 2:");
        printList(head2);

        Node res2 = oddEvenList(head2);
        System.out.println("Odd-Even List 2:");
        printList(res2);
    }
}
