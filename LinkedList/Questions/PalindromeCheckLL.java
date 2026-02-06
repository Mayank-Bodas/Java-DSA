public class PalindromeCheckLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Check if Linked List is Palindrome - O(N)):
     * Goal: Determine if the linked list reads the same forwards and backwards.
     * 
     * Algorithm:
     * 1. Find the Middle:
     * - Use Tortoise and Hare (`slow`, `fast`).
     * - When `fast` ends, `slow` is at the middle.
     * 2. Reverse the Second Half:
     * - Reverse the list starting from `slow.next`.
     * - Let the new head of the reversed half be `secondHead`.
     * 3. Compare Halves:
     * - Use two pointers: `first` (from head) and `second` (from secondHead).
     * - Traverse both. If `first.data != second.data`, return false.
     * 4. Restore List (Optional but good practice):
     * - Reverse the second half again to restore original structure.
     * 5. Return true if loop completes.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        // Step 1: Find Middle
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse Second Half
        Node newHead = reverse(slow.next);

        // Step 3: Compare
        Node first = head;
        Node second = newHead;
        boolean isPal = true; // Flag to store result before restoring
        while (second != null) {
            if (first.data != second.data) {
                isPal = false;
                break; // No need to compare further
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore List (Optional)
        reverse(newHead); // Restore the second half

        return isPal;
    }

    // Helper method to reverse a linked list
    private static Node reverse(Node head) {
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

    public static void main(String[] args) {
        // Test Case 1: Palindrome (1 -> 2 -> 3 -> 2 -> 1)
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(1);

        System.out.println("Test Case 1 (Palindrome): " + isPalindrome(head1));
        // Expected: true

        // Test Case 2: Not Palindrome (1 -> 2 -> 3)
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        System.out.println("Test Case 2 (Not Palindrome): " + isPalindrome(head2));
        // Expected: false

        // Test Case 3: Empty/Single is Palindrome
        Node head3 = new Node(10);
        System.out.println("Test Case 3 (Single Node): " + isPalindrome(head3));
        // Expected: true

        // Test Case 4: Even length palindrome (1 -> 2 -> 2 -> 1)
        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(2);
        head4.next.next.next = new Node(1);
        System.out.println("Test Case 4 (Even Palindrome): " + isPalindrome(head4));
        // Expected: true

        // Test Case 5: Even length non-palindrome (1 -> 2 -> 3 -> 4)
        Node head5 = new Node(1);
        head5.next = new Node(2);
        head5.next.next = new Node(3);
        head5.next.next.next = new Node(4);
        System.out.println("Test Case 5 (Even Non-Palindrome): " + isPalindrome(head5));
        // Expected: false

        // Test Case 6: Null list
        Node head6 = null;
        System.out.println("Test Case 6 (Null List): " + isPalindrome(head6));
        // Expected: true
    }
}
