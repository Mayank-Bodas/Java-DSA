package Binary_Tree.Intro;

public class Introduction {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int key) {
            data = key;
            left = null;
            right = null;
        }
    }

    static class Solution {
        public Node createBinaryTree() {
            /*
             * Creating a Binary Tree manually:
             * 1
             * / \
             * 2 3
             * \ / \
             * 5 6 7
             */
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            return root;
        }

        // Helper to print Inorder Traversal (Left, Root, Right)
        public void printInorder(Node node) {
            if (node == null)
                return;
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        Node root = sl.createBinaryTree();

        System.out.println("Binary Tree Created.");
        System.out.print("Inorder Traversal: ");
        sl.printInorder(root);
        System.out.println();
    }
}
