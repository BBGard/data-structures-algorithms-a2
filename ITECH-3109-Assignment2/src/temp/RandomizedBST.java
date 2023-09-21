package temp;

import java.util.Random;

//Define the Randomized BST class
public class RandomizedBST {
private RandomizedBSTNode root;
private Random random;

public RandomizedBST() {
   root = null;
   random = new Random();
}

// Helper method to get the size of a node
private int getSize(RandomizedBSTNode node) {
   return (node != null) ? node.size : 0;
}

// Helper method to perform a left rotation at the node
private RandomizedBSTNode leftRotation(RandomizedBSTNode node) {
   RandomizedBSTNode newRoot = node.right;
   node.right = newRoot.left;
   newRoot.left = node;
   // Update sizes
   newRoot.size = node.size;
   node.size = getSize(node.left) + getSize(node.right) + 1;
   return newRoot;
}

// Helper method to perform a right rotation at the node
private RandomizedBSTNode rightRotation(RandomizedBSTNode node) {
   RandomizedBSTNode newRoot = node.left;
   node.left = newRoot.right;
   newRoot.right = node;
   // Update sizes
   newRoot.size = node.size;
   node.size = getSize(node.left) + getSize(node.right) + 1;
   return newRoot;
}

// Helper method to insert a key into the Randomized BST
private RandomizedBSTNode randomizedBSTInsert(RandomizedBSTNode node, int key) {
   if (node == null) {
       return new RandomizedBSTNode(key);
   }

   // Generate a random probability
   double p = random.nextDouble();
   double threshold = (double) getSize(node.left) / (double) (getSize(node) + 1);

   if (p <= threshold) {
       // Insert key at the root
       RandomizedBSTNode newNode = new RandomizedBSTNode(key);
       if (key < node.key) {
           newNode.right = node;
       } else {
           newNode.left = node;
       }
       newNode.size = getSize(newNode.left) + getSize(newNode.right) + 1;
       return newNode;
   } else if (key < node.key) {
       node.left = randomizedBSTInsert(node.left, key);
   } else {
       node.right = randomizedBSTInsert(node.right, key);
   }

   // Update size
   node.size = getSize(node.left) + getSize(node.right) + 1;
   return node;
}

// Public method to insert a key into the Randomized BST
public void insert(int key) {
   root = randomizedBSTInsert(root, key);
}

// Public method to print the Randomized BST using in-order traversal
public void printInorder() {
   printInorder(root);
}

// Helper method to print the Randomized BST using in-order traversal
private void printInorder(RandomizedBSTNode node) {
   if (node == null) {
       return;
   }
   printInorder(node.left);
   System.out.print(node.key + " ");
   printInorder(node.right);
}



// Helper method to check if a subtree is balanced
public boolean isBalanced() {
    int height = getHeight(root);
    int expectedHeight = (int) (Math.log(getSize(root)) / Math.log(2)); // Expected height (log base 2)

    // Define a tolerance level (e.g., 1 or 2 levels)
    int tolerance = 2;

    return Math.abs(height - expectedHeight) <= tolerance;
}


//Helper method to get the height of a node
public int getHeight(RandomizedBSTNode node) {
    if (node == null) {
        return 0;
    }
    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);
    return Math.max(leftHeight, rightHeight) + 1;
}



public static void main(String[] args) {
   RandomizedBST tree = new RandomizedBST();

   // Insert elements into the tree
   tree.insert(50);
   tree.insert(30);
   tree.insert(70);
   tree.insert(20);
   tree.insert(40);

   // Print the tree using in-order traversal
   System.out.println("In-order traversal:");
   tree.printInorder();
}
}
