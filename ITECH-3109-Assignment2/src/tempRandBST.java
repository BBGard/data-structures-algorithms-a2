class RandomizedBST {
    RandomizedBSTNode root;

    public RandomizedBST() {
        root = null;
    }

    public RandomizedBST(RandomizedBSTNode node) {
        root = node;
    }

    // Search for a key in the Randomized BST
    public RandomizedBSTNode randomizedBSTSearch(int key) {
        return randomizedBSTSearchHelper(root, key);
    }

    // Private recursive method for searching
    private RandomizedBSTNode randomizedBSTSearchHelper(RandomizedBSTNode node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return randomizedBSTSearchHelper(node.left, key);
        } else {
            return randomizedBSTSearchHelper(node.right, key);
        }
    }

    // Insert a key into the Randomized BST
    public void randomizedBSTInsert(int key) {
        root = RandomizedBSTNode.rootInsert(root, key);
    }

    // Delete a key from the Randomized BST
    public void randomizedBSTDelete(int key) {
        // Implement randomizedBSTDelete method as per your assignment
        // You need to call the corresponding method in RandomizedBSTNode
    }

    // Print the Randomized BST in pre-order
    public void printPreorder() {
        if (root != null) {
            root.printPreorderNode();
        }
    }

    // Print the Randomized BST in in-order
    public void printInorder() {
        if (root != null) {
            root.printInorderNode();
        }
    }

    // Print the Randomized BST in post-order
    public void printPostorder() {
        if (root != null) {
            root.printPostorderNode();
        }
    }
}
