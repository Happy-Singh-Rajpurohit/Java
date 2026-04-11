import java.util.*;

public class BstToBalancedBST {
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

    public static Node createBST(ArrayList<Integer> Inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = st + (end - st) / 2;
        Node root = new Node(Inorder.get(mid));
        root.left = createBST(Inorder, st, mid - 1);
        root.right = createBST(Inorder, mid + 1, end);
        return root;
    }

    public static void storeInorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        storeInorder(root.left, list);
        list.add(root.data);
        storeInorder(root.right, list);
    }

    public static Node BalaceBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        storeInorder(root, list);
        return createBST(list, 0, list.size() - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        root = BalaceBST(root);
        inorder(root);
    }
}