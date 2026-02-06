package LinkedList.Questions;

public class DeleteNthNodeLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /*
     * Pseudocode (Delete N-th Node from End - O(N)):
     * Goal: Remove the N-th node from the end of the list in a single pass.
     * 
     * Algorithm:
     * 1. Use a Dummy Node:
     * - Create `dummy` with `next` pointing to `head`.
     * - This simplifies edge cases like deleting the head itself.
     * 2. Initialize Two Pointers:
     * - `slow` = dummy
     * - `fast` = dummy
     * 3. Move Fast Pointer:
     * - Move `fast` ahead by `n` steps. (Or n+1 to be just ahead).
     * - Actually, move `fast` n+1 steps if starting from dummy to create a gap of
     * `n` nodes between slow and fast.
     * - Alternatively: Move `fast` n times. Then move both until `fast.next` is
     * null.
     * - Logic used here: Move `fast` O(N) steps ahead.
     * 
     * Current Logic:
     * - Move `fast` `n` steps ahead.
     * - Then move both `slow` and `fast` until `fast.next` is null.
     * - Now `slow` is at the node BEFORE the one to be deleted.
     * 4. Delete Node:
     * - slow.next = slow.next.next;
     * 5. Return dummy.next.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static Node deleteNthNode(Node head, int n) {
        Node dummy = new Node(0, head);
        Node slow = dummy;
        Node fast = dummy;

        // Move fast ahead by n steps
        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        // Move both until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Delete the node
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
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
        // Test Case 1: Delete 2nd from end (1 -> 2 -> 3 -> 4 -> 5, n=2)
        // Expected: 1 -> 2 -> 3 -> 5 -> null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        System.out.println("Original List 1:");
        printList(head1);

        Node res1 = deleteNthNode(head1, 2);
        System.out.println("After deleting 2nd from end:");
        printList(res1);

        // Test Case 2: Delete Head (1 -> 2, n=2)
        // Expected: 2 -> null
        Node head2 = new Node(1);
        head2.next = new Node(2);

        System.out.println("\nOriginal List 2:");
        printList(head2);

        Node res2 = deleteNthNode(head2, 2);
        System.out.println("After deleting head:");
        printList(res2);

        // Test Case 3: Delete Tail (1 -> 2, n=1)
        // Expected: 1 -> null
        Node head3 = new Node(1);
        head3.next = new Node(2);

        System.out.println("\nOriginal List 3:");
        printList(head3);

        Node res3 = deleteNthNode(head3, 1);
        System.out.println("After deleting tail:");
        printList(res3);
    }
}
