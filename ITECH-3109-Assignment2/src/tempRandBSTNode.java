class tempRandBSTNode {
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

    // Perform a right rotation at the node and return the new root
    static RandomizedBSTNode rightRotation(RandomizedBSTNode node) {
        if (node == null || node.left == null) {
            return node;
        }
        RandomizedBSTNode temp = node;
        node = node.left;
        temp.left = node.right;
        node.right = temp;

        // Recalculate the size attributes
        temp.size = 1 + getSize(temp.left) + getSize(temp.right);
        node.size = 1 + getSize(node.left) + getSize(node.right);

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
        temp.size = 1 + getSize(temp.left) + getSize(temp.right);
        node.size = 1 + getSize(node.left) + getSize(node.right);

        return node;
    }

    // Root-insert at the node
    static RandomizedBSTNode rootInsert(RandomizedBSTNode node, int key) {
        if (nodeSearch(node, key) != null) {
            // Key is already in the tree
            return node;
        }
        return rootInsertHelper(node, key);
    }

    // Private recursive method, called by rootInsert
    private static RandomizedBSTNode rootInsertHelper(RandomizedBSTNode node, int key) {
        if (node == null) {
            node = new RandomizedBSTNode(key);
            return node;
        }
        if (key < node.key) {
            node.left = rootInsertHelper(node.left, key);
            node = rightRotation(node);
        } else {
            node.right = rootInsertHelper(node.right, key);
            node = leftRotation(node);
        }

        // Recalculate the size attributes
        if (node.left != null) {
            node.left.size = 1 + getSize(node.left.left) + getSize(node.left.right);
        }
        if (node.right != null) {
            node.right.size = 1 + getSize(node.right.left) + getSize(node.right.right);
        }
        node.size = 1 + getSize(node.left) + getSize(node.right);

        return node;
    }

    // Helper method to get the size of a node (handles null cases)
    private static int getSize(RandomizedBSTNode node) {
        return (node != null) ? node.size : 0;
    }

    // Implement randomizedBSTInsert and randomizedBSTDelete methods here
    // Algorithms for these methods are described in Lecture 6.1

    // ... (other methods for randomizedBSTInsert and randomizedBSTDelete)

    // Print the node in pre-order
    void printPreorderNode() {
        System.out.print(key + " ");
        if (left != null) {
            left.printPreorderNode();
        }
        if (right != null) {
            right.printPreorderNode();
        }
    }

    // Print the node in in-order
    void printInorderNode() {
        if (left != null) {
            left.printInorderNode();
        }
        System.out.print(key + " ");
        if (right != null) {
            right.printInorderNode();
        }
    }

    // Print the node in post-order
    void printPostorderNode() {
        if (left != null) {
            left.printPostorderNode();
        }
        if (right != null) {
            right.printPostorderNode();
        }
        System.out.print(key + " ");
    }
}
