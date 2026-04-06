package BinaryTree2;
import java.util.*;

public class Diameter {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int diameter2(Node root){//O(n^2)
        if(root == null){
            return 0;
        }
        int leftDia = diameter2(root.left);
        int leftHeight = height(root.left);
        int rightDia = diameter2(root.right); 
        int rightHeight = height(root.right);
        int selfDia = leftDia + rightDia + 1;
        return Math.max(selfDia, Math.max(leftDia, rightDia));
    }

    static class Info{
        int dia;
        int height;

        public Info(int dia, int height){
            this.dia = dia;
            this.height = height;
        }
    }

    public static Info diameter(Node root){//O(n)
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int selfDia = leftInfo.height + rightInfo.height + 1;
        int dia = Math.max(selfDia, Math.max(leftInfo.dia, rightInfo.dia));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(dia, height);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // System.out.println("The height of the tree is: " + height(root));
        // System.out.println(diameter2(root));
        System.out.println(diameter(root).dia);
    }

}
