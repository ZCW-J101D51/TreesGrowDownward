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
        root = addRecursive(root,value);
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
}
