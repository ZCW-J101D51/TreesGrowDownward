import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kristofer on 7/13/20.
 */
public class TreeOneZero {
    Node root;

    //constructor
    public TreeOneZero(Node root) {
        this.root = root;
    }

    //method to add a value to the tree
    public void add(Integer value) {
        root = addRecursive(root, value);
    }

    //RECURSIVE method to add a value
    private Node addRecursive(Node current, Integer value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    //method to check if a value exists in tree
    private boolean containsNode(Integer value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, Integer value) {
        if (current == null) {
            return false;
        }

        if (value.equals(current.value)) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    //method to delete a value from tree
    public void delete(Integer value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, Integer value) {
        if (current == null) {
            return null;
        }

        if (value.equals(current.value)) {
            // Node to delete found

            //first IF: node has no children
            if (current.left == null && current.right == null) {
                return null;
            }

            //second IF: Node has one child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            //third IF: Node has two children
            Integer smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        //recursive search for the node to delete
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else {
            current.right = deleteRecursive(current.right, value);
        }

        return current;
    }

    //method to find smallest value
    private Integer findSmallestValue(Node right) {
        return root.left == null ? root.value : findSmallestValue(root.left);

    }

    //method for in - order
    public void traverseInOrder() {
        traverseInOrderRecursive(root);
        System.out.println();
    }

    //resursive method for in-order traversal
    private void traverseInOrderRecursive(Node node) {
        if (node != null) {
            traverseInOrderRecursive(node.left);
            System.out.print(" " + node.value);
            traverseInOrderRecursive(node.right);
        }
    }

    //public method for pre-order traversal
    public void traversePreOrder() {
        traversePreOrderRecursive(root);
        System.out.println();
    }

    //recursive method for pre-order traversal
    private void traversePreOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrderRecursive(node.left);
            traversePreOrderRecursive(node.right);
        }
    }

    //method for post-order traversal
    public void traversePostOrder() {
        traversePostOrderRecursive(root);
        System.out.println();
    }

    //recur method for post-order traversal
    private void traversePostOrderRecursive(Node node) {
        if (node != null) {
            traversePostOrderRecursive(node.left);
            traversePostOrderRecursive(node.right);
            System.out.print(" " + node.value);
        }
    }

    //methodZzzzz for level-order traversal
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        System.out.println();
    }
}