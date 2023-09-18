/**
 * 
 */

/**
 * This is the driver program for running the ITECH-3109 Assignment 2 code.
 * This program tests the correctness of a Randomized BST implementation,
 * ensuring it is balanced and efficient. 
 * 
 * @author Benjamin Gardiner - Student ID: 30399545
 */
public class Main {
    public static void main(String[] args) {
        RandomizedBST bst = new RandomizedBST();

        // Insert elements into the Randomized BST
        bst.randomizedBSTInsert(5);
        bst.randomizedBSTInsert(3);
        bst.randomizedBSTInsert(7);
        bst.randomizedBSTInsert(2);
        bst.randomizedBSTInsert(4);

        // Print the tree using pre-order, in-order, and post-order traversals
        System.out.println("Pre-order traversal:");
        bst.printPreorder();
        System.out.println();

        System.out.println("In-order traversal:");
        bst.printInorder();
        System.out.println();

        System.out.println("Post-order traversal:");
        bst.printPostorder();
        System.out.println();
    }
}

