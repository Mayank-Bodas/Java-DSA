package LinkedList.Questions;

public class AddTwoNumbersLL {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
     * Pseudocode (Add Two Numbers - O(max(N, M))):
     * Goal: Add two non-negative integers represented by linked lists.
     * The digits are stored in reverse order.
     * 
     * Algorithm:
     * 1. Initialize `dummy` node and `temp` pointer.
     * 2. Initialize `carry` to 0.
     * 3. Loop while `l1` is not null OR `l2` is not null OR `carry` > 0:
     * - `sum` = 0.
     * - If `l1` exists, add `l1.val` to `sum`, move `l1` to `l1.next`.
     * - If `l2` exists, add `l2.val` to `sum`, move `l2` to `l2.next`.
     * - Add `carry` to `sum`.
     * - Update `carry` = `sum / 10`.
     * - Create new node with `sum % 10` and attach to `temp.next`.
     * - Move `temp` to `temp.next`.
     * 4. Return `dummy.next`.
     * 
     * Time Complexity: O(max(N, M))
     * Space Complexity: O(max(N, M)) for the result list.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Case 1: 342 + 465 = 807
        // L1: 2 -> 4 -> 3
        // L2: 5 -> 6 -> 4
        // Result: 7 -> 0 -> 8
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("List 1 (342):");
        printList(l1);
        System.out.println("List 2 (465):");
        printList(l2);

        ListNode res1 = addTwoNumbers(l1, l2);
        System.out.println("Result (807):");
        printList(res1);

        // Test Case 2: 99 + 1 = 100
        // L1: 9 -> 9
        // L2: 1
        // Result: 0 -> 0 -> 1
        ListNode l3 = new ListNode(9);
        l3.next = new ListNode(9);

        ListNode l4 = new ListNode(1);

        System.out.println("\nList 3 (99):");
        printList(l3);
        System.out.println("List 4 (1):");
        printList(l4);

        ListNode res2 = addTwoNumbers(l3, l4);
        System.out.println("Result (100):");
        printList(res2);
    }
}
