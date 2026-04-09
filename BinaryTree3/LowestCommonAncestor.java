import java.util.*;

public class LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }

        boolean leftFound = getPath(root.left, n, path);
        boolean rightFound = getPath(root.right, n, path);
        if(leftFound || rightFound){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node LCA(Node root, int n1, int n2){//O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
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
    public static void main(String[] args) {
        Node root = new Node(
                1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(LCA(root, 4, 5).data);
        System.out.println(LCA2(root, 4, 6).data);
    }
}
