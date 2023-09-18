/**
 * 
 * @author Benjamin Gardiner
 * Based on the BST class provided by Eldar Hajilarov
 */
public class RandomizedBST {
    RandomizedBSTNode root;

    public RandomizedBST() {
        root = null;
    }

    public RandomizedBST(RandomizedBSTNode node) {
        root = node;
    }

    // Implement methods to provide an interface for RandomizedBST operations
    // These methods should use the corresponding methods in RandomizedBSTNode

    public void printPreorder() {
        if (root != null) {
            root.printPreorderNode();
        }
    }

    public void printInorder() {
        if (root != null) {
            root.printInorderNode();
        }
    }

    public void printPostorder() {
        if (root != null) {
            root.printPostorderNode();
        }
    }
}
