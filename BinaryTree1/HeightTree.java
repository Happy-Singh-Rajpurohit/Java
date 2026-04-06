import java.util.*;

public class HeightTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
     }

     public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int CountNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = CountNodes(root.left);
        int rightCount = CountNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public static int SumNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = SumNodes(root.left);
        int rightSum = SumNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);    
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("The height of the tree is: " + height(root));
        System.out.println("The number of nodes in the tree is: " + CountNodes(root));
        System.out.println("The sum of the nodes in the tree is: " + SumNodes(root));
    }
}
