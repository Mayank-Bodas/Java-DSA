package LinkedList.Intro;

public class IntroductionDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /*
     * Pseudocode (Construct DLL from Array - O(N)):
     * Goal: Convert an integer array into a Doubly Linked List.
     * 
     * 1. If array is empty, return null.
     * 2. Create the `head` node with arr[0].
     * 3. Maintain a pointer `prev` (initially pointing to head).
     * 4. Iterate through the rest of the array (i = 1 to N-1):
     * a. Create `temp` node with arr[i].
     * b. Link: prev.next = temp.
     * c. Link: temp.prev = prev.
     * d. Move: prev = temp.
     * 5. Return `head`.
     */
    public static Node constructDLL(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev; // Key step for DLL
            prev = temp;
        }
        return head;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Case 1: Standard Array
        int[] arr1 = { 1, 2, 3, 4, 5 };
        Node head1 = constructDLL(arr1);
        System.out.print("Test Case 1: ");
        printList(head1);
        // Expected: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null

        // Test Case 2: Single Element
        int[] arr2 = { 10 };
        Node head2 = constructDLL(arr2);
        System.out.print("Test Case 2: ");
        printList(head2);
        // Expected: 10 <-> null

        // Test Case 3: Empty Array
        int[] arr3 = {};
        Node head3 = constructDLL(arr3);
        System.out.print("Test Case 3: ");
        printList(head3);
        // Expected: null
    }
}
