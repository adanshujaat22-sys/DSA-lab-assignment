class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {

    // INSERT
    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // INORDER
    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // PREORDER
    static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // POSTORDER
    static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // SEARCH
    static boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // FIND MIN
    static int findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // FIND MAX
    static int findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // COUNT TOTAL NODES
    static int countNodes(Node root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // COUNT LEAF NODES
    static int countLeaf(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeaf(root.left) + countLeaf(root.right);
    }

    // HEIGHT
    static int height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // DELETE (ONLY LEAF & ONE CHILD — ENOUGH FOR 80)
    static Node delete(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
        }
        return root;
    }

    public static void main(String[] args) {

        Node root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.println("Search 60: " + search(root, 60));

        root = delete(root, 80);

        System.out.print("Inorder after deleting 80: ");
        inorder(root);
        System.out.println();

        System.out.println("Minimum value: " + findMin(root));
        System.out.println("Maximum value: " + findMax(root));

        System.out.println("Total nodes: " + countNodes(root));
        System.out.println("Leaf nodes: " + countLeaf(root));

        System.out.println("Tree height: " + height(root));
    }
}

 