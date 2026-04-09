import java.util.*;

public class MinimumDistanceBetNodes {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node LCA2(Node root, int n1, int n2){//O(n)
        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLCA = LCA2(root.left, n1, n2);
        Node rightLCA = LCA2(root.right, n1, n2);

        if(leftLCA != null && rightLCA != null){
            return root;
        }

        if(leftLCA != null){
            return leftLCA;
        }

        return rightLCA;
    }

    public static int findDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = findDist(root.left, n);
        int rightDist = findDist(root.right, n);
        if(leftDist == -1 && rightDist == -1){
            return -1;
        } else if(leftDist == -1){
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDistance(Node root, int n1, int n2){
        Node lca = LCA2(root, n1, n2);
        int dist1 = findDist(lca, n1);
        int dist2 = findDist(lca, n2);
        return dist1 + dist2;
    }
    public static void main(String[] args) {
        Node root = new Node(
                1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(minDistance(root, 4, 6));
    }
}
