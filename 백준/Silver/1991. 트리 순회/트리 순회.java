import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Tree {
        Node root;

        void initialize(char parent, char left, char right) {
            if(root == null) {
                root = new Node(parent);

                if(left != '.') {
                    root.left = new Node(left);
                }

                if(right != '.') {
                    root.right = new Node(right);
                }
            } else {
                addNode(root, parent, left, right);
            }
        }

        void addNode(Node root, char parent, char left, char right) {
            if(root == null) return;

            if(root.data == parent) {
                if(left != '.') {
                    root.left = new Node(left);
                }

                if(right != '.') {
                    root.right = new Node(right);
                }
            } else {
                addNode(root.left, parent, left, right);
                addNode(root.right, parent, left, right);
            }
        }

        // root -> left -> right
        void preorderTraversal(Node root) {
            if(root == null) return;
            preOrder.append(root.data);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        // left -> root -> right
        void inorderTraversal(Node root) {
            if(root == null) return;
            inorderTraversal(root.left);
            inOrder.append(root.data);
            inorderTraversal(root.right);
        }

        // left -> right -> root
        void postorderTraversal(Node root) {
            if(root == null) return;
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            postOrder.append(root.data);
        }
    }

    static StringBuilder preOrder = new StringBuilder();
    static StringBuilder inOrder = new StringBuilder();
    static StringBuilder postOrder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.initialize(parent, left, right);
        }

        tree.preorderTraversal(tree.root);
        System.out.println(preOrder);
        tree.inorderTraversal(tree.root);
        System.out.println(inOrder);
        tree.postorderTraversal(tree.root);
        System.out.println(postOrder);
    }
}
