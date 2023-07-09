import java.util.Scanner;

class BST {

    static class Node {
        char key;
        String value;
        Node left, right;

        public Node(char key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node min() {
            if (left == null) {
                return this;
            } else {
                return left.min();
            }
        }
    }

    Node root;
    String printValue = "";

    public BST() {
        root = null;
    }

    public String find(char key) {
        Node node = find(root, key);

        return node == null ? null : node.value;
    }

    private Node find(Node node, char key) {
        if (node == null || node.key == key) {
            return node;
        } else if (key < node.key) {
            return find(node.left, key);
        } else if (key > node.key) {
            return find(node.right, key);
        }
        return null;
    }

    public void insert(char key, String value) {
        root = insertItem(root, key, value);
    }

    public Node insertItem(Node node, char key, String value) {

        if (node == null) {
            node = new Node(key, value);
            ;
            return node;
        }

        if (key < node.key) {
            node.left = insertItem(node.left, key, value);
        }

        if (key > node.key) {
            node.right = insertItem(node.right, key, value);
        }

        return node;
    }

    public int findMinKey() {
        return findMin(root).key;
    }

    public Node findMin(Node node) {
        return node.min();
    }

    public void delete(char key) {
        root = delete(root, key);
    }

    public Node delete(Node node, char key) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {

            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node minRight = findMin(node.right);

                node.key = minRight.key;
                node.value = minRight.value;

                node.right = delete(node.right, node.key);
            }
        }

        return node;
    }

    public void printInOrderTraversal() {
        printValue = "";
        inOrderTraversal(root);
        printValueWithoutSpace();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            printValue += node.key + " ";
            inOrderTraversal(node.right);
        }
    }

    public void printPreOrderTraversal() {
        printValue = "";
        preOrderTraversal(root);
        printValueWithoutSpace();
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            printValue += node.key + " ";
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void printPostOrderTraversal() {
        printValue = "";
        postOrderTraversal(root);
        printValueWithoutSpace();
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            printValue += node.key + " ";
        }
    }

    private void printValueWithoutSpace() {
        System.out.println(printValue.substring(0, printValue.length() - 1));
    }

    boolean checkBST(Node root) {

        boolean leftOK = false;

        if (root.left != null) {
            if (root.left.key < root.key) {
                leftOK = true;
            }
        } else {
            leftOK = true;
        }

        boolean rightOK = false;

        if (root.right != null) {
            if (root.right.key > root.key) {
                rightOK = true;
            }
        } else {
            rightOK = true;
        }

        return leftOK && rightOK;
    }
}

public class App {

    static BST bst = new BST();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            validateInput(sc.nextLine());
        }
    }

    static void validateInput(String input) {
        if (input.equals("INFIXA")) {
            bst.printInOrderTraversal();
        } else if (input.equals("PREFIXA")) {
            bst.printPreOrderTraversal();
        } else if (input.equals("POSFIXA")) {
            bst.printPostOrderTraversal();
        } else if (!input.equals("")) {
            String op = input.split(" ")[0];
            char key = input.split(" ")[1].charAt(0);

            if (op.equals("I")) {
                bst.insert(key, String.valueOf(key));
            } else if (op.equals("P")) {
                System.out.println(bst.find(key) == null ? "nao existe" : (key + " existe"));
            }
        }
    }
}
