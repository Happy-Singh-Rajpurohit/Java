import java.util.*;

public class AvlTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node rightRotate(Node root) {
        Node newRoot = root.left;
        Node temp = newRoot.right;
        newRoot.right = root;
        root.left = temp;
        return newRoot;
    }

    public static Node leftRotate(Node root) {
        Node newRoot = root.right;
        Node temp = newRoot.left;
        newRoot.left = root;
        root.right = temp;
        return newRoot;
    }

    public static Node insertIntoAvl(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insertIntoAvl(root.left, val);
        } else {
            root.right = insertIntoAvl(root.right, val);
        }
        int balance = getBalance(root);
        if (balance > 1 && val < root.left.data) {
            return rightRotate(root);
        }
        if (balance < -1 && val > root.right.data) {
            return leftRotate(root);
        }
        if (balance > 1 && val > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && val < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }


    public static void main(String[] args) {
        Node root = null;
        int[] values = {10, 20, 30, 40, 50, 25};
        for (int val : values) {
            root = insertIntoAvl(root, val);
        }
        System.out.println("Inorder traversal of the AVL tree is:");
        inorder(root);
    }
}
