/**
 * 
 * @author Benjamin Gardiner
 * Based on the BSTNode class provided by Eldar Hajilarov
 */
public class RandomizedBSTNode {
    int key; // data at the node
    RandomizedBSTNode left; // left child
    RandomizedBSTNode right; // right child
    int size; // the number of nodes in the tree with the root at this node

    public RandomizedBSTNode(int key) {
        this.key = key;
        left = null;
        right = null;
        size = 1; // Initialize the size to 1 for the current node
    }

    ////////// Modified, leftRotation, rightRotation, and rootInsert methods //////////
    
    // Perform a right rotation at the node and return the new root
    static RandomizedBSTNode rightRotation(RandomizedBSTNode node) {
    	if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        
        RandomizedBSTNode temp = node;
        node = node.left;
        temp.left = node.right;
        node.right = temp;

        // Recalculate the size attributes
        temp.size = 1 + temp.left.size + temp.right.size;
        node.size = 1 + node.left.size + node.right.size;

        return node;
    }
    
 // Perform a left rotation at the node and return the new root
    static RandomizedBSTNode leftRotation(RandomizedBSTNode node) {
        if (node == null || node.right == null) {
            return node;
        }
        RandomizedBSTNode temp = node;
        node = node.right;
        temp.right = node.left;
        node.left = temp;

        // Recalculate the size attributes
        temp.size = 1 + temp.left.size + temp.right.size;
        node.size = 1 + node.left.size + node.right.size;

        return node;
    }
    
    
    
    //////////////////////// Methods from BSTNode ///////////////////////////////////
}

