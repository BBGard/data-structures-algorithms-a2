/**
 * 
 * @author Benjamin Gardiner
 * Based on the BST class provided by Eldar Hajilarov
 */
public class RandomizedBST {
    static RandomizedBSTNode root;

    public RandomizedBST() {
        root = null;
    }

    public RandomizedBST(RandomizedBSTNode node) {
        root = node;
    }

    // Implement methods to provide an interface for RandomizedBST operations
    // These methods should use the corresponding methods in RandomizedBSTNode
    
    // randomizedBSTInsert
    public void randomizedBSTInsert(int key) {
        if (root == null) {
            root = new RandomizedBSTNode(key);
        } else {
            root = RandomizedBSTNode.randomizedBSTInsert(root, key);
        }
    }
    
    public void randomizedBSTDelete(int key) {
        if (root != null) {
            root = root.randomizedBSTDelete(root, key);
        }
    }
    
    // Public method to check if the tree is balanced
//    public boolean isBalanced() {
//        return RandomizedBSTNode.isBalanced(root);
//    }
    public boolean isBalanced() {
        int height = getHeight();
        int expectedHeight = (int) (Math.log(RandomizedBSTNode.getSize(root)) / Math.log(2)); // Expected height (log base 2)

        // Define a tolerance level (e.g., 1 or 2 levels)
        int tolerance = 2;

        return Math.abs(height - expectedHeight) <= tolerance;
    }


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
    
    public int getHeight() {
    	int height = RandomizedBSTNode.getHeight(root);
    	return height;
    }
}
