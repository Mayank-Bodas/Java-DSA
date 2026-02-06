package LinkedList.Questions;

public class SortLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Pseudocode (Sort List - Merge Sort - O(N log N)):
     * Goal: Sort the linked list in ascending order.
     * 
     * Algorithm (Merge Sort):
     * 1. Base Case: If head is null or head.next is null, return head.
     * 2. Find Middle:
     * - Use fast/slow pointers.
     * - Important: Break the list into two halves by setting `prev.next = null` (or
     * finding node before middle).
     * 3. Recursion:
     * - `left = sort(head)`
     * - `right = sort(middle)`
     * 4. Merge:
     * - Merge the two sorted halves (`left` and `right`) into one list.
     * - Use a dummy node to simplify merging.
     * 5. Return the merged head.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(log N) due to recursion stack.
     */
    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find Middle and Split
        Node middle = findMiddle(head);
        Node rightHalf = middle.next;
        middle.next = null; // Split the list

        // Step 2: Recursively sort both halves
        Node left = sort(head);
        Node right = sort(rightHalf);

        // Step 3: Merge sorted halves
        return merge(left, right);
    }

    // Helper to find the middle node (returns the node BEFORE the second half
    // starts,
    // or the end of the first half)
    private static Node findMiddle(Node head) {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head.next; // fast starts ahead to handle even length correctly for split

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper to merge two sorted lists
    private static Node merge(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
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
        // Test Case 1: Unsorted List (4 -> 2 -> 1 -> 3)
        Node head1 = new Node(4);
        head1.next = new Node(2);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(3);

        System.out.println("Original List 1:");
        printList(head1);

        Node sorted1 = sort(head1);
        System.out.println("Sorted List 1:");
        printList(sorted1);
        // Expected: 1 -> 2 -> 3 -> 4 -> null

        // Test Case 2: Reverse Sorted (-1 -> 5 -> 3 -> 4 -> 0)
        Node head2 = new Node(-1);
        head2.next = new Node(5);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(0);

        System.out.println("\nOriginal List 2:");
        printList(head2);

        Node sorted2 = sort(head2);
        System.out.println("Sorted List 2:");
        printList(sorted2);
        // Expected: -1 -> 0 -> 3 -> 4 -> 5 -> null

        // Test Case 3: Empty List
        Node head3 = null;
        System.out.println("\nOriginal List 3 (Empty):");
        Node sorted3 = sort(head3);
        System.out.println("Sorted List 3:");
        printList(sorted3);
    }
}
