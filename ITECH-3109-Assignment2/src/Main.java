
/**
 * 
 */
import java.util.Random;

/**
 * This is the driver program for running the ITECH-3109 Assignment 2 code. This
 * program tests the correctness of a Randomized BST implementation, ensuring it
 * is balanced and efficient.
 * 
 * @author Benjamin Gardiner - Student ID: 30399545
 */
public class Main {
	public static void main(String[] args) {
		randomizedTester();

		// Basic Test
//		 RandomizedBST tree = new RandomizedBST();
//
//	        // Insert elements into the tree
//	        tree.randomizedBSTInsert(50);
//	        tree.randomizedBSTInsert(30);
//	        tree.randomizedBSTInsert(70);
//	        tree.randomizedBSTInsert(20);
//	        tree.randomizedBSTInsert(40);
//
//	        // Print the tree using in-order traversal
//	        System.out.println("In-order traversal:");
//	        tree.printInorder();
//	        System.out.println();
//	        
//	        // Check if tree is balanced
//	        if (tree.isBalanced()) {
//	            System.out.println("Tree is balanced.");
//	        } else {
//	            System.out.println("Tree is not balanced.");
//	        }
//
//	        // Insert more elements into the tree
//	        tree.randomizedBSTInsert(60);
//	        tree.randomizedBSTInsert(80);
//	        tree.randomizedBSTInsert(10);
//
//	        // Print the updated tree
//	        System.out.println("In-order traversal after additional insertions:");
//	        tree.printInorder();
//	        
//	     // Check if tree is balanced
//	        if (tree.isBalanced()) {
//	            System.out.println("\nTree is balanced.");
//	        } else {
//	            System.out.println("\nTree is not balanced.");
//	        }		
		// Test rotations
//		createAndRotateTree();

		// Test insertion
//		createAndInsertTree();

		// Test traversals
//		createAndTraverseTree();
	}
	
	public static void randomizedTester() {
        int numTests = 1000; // Number of tests to run
        int numInsertions = 1000; // Number of insertions per test

        int totalHeight = 0;
        Random random = new Random();


        RandomizedBST tree = new RandomizedBST();

        for (int i = 0; i < numTests; i++) {
            tree = new RandomizedBST(); // Create a new tree for each test

            for (int j = 0; j < numInsertions; j++) {
                int randomValue = random.nextInt(100);;// Generate a random value for insertion
                tree.randomizedBSTInsert(randomValue);
            }

            int height = tree.getHeight();
            totalHeight += height;
        }

        double averageHeight = (double) totalHeight / numTests;
        int expectedHeight = (int) (Math.log(numInsertions) / Math.log(2));

        // Define a tolerance level, e.g., 1 or 2 levels
        int tolerance = 2;
        
        System.out.println("AVG: " + (averageHeight - expectedHeight));

        if (Math.abs(averageHeight - expectedHeight) <= tolerance) {
            System.out.println("On average, the tree remains balanced.");
        } else {
            System.out.println("On average, the tree is not balanced.");
        }
    }

	private static void createAndRotateTree() {
		 RandomizedBST randomizedBST = new RandomizedBST();


//	         Insert nodes manually to create a sample tree
	        randomizedBST.randomizedBSTInsert(50);
	        randomizedBST.randomizedBSTInsert(30);
	        randomizedBST.randomizedBSTInsert(70);
	        randomizedBST.randomizedBSTInsert(20);
	        randomizedBST.randomizedBSTInsert(40);
	        // Print the tree with 'size' attributes using in-order traversal
	        System.out.println("Initial In-order traversal (with 'size' attributes):");
	        printTreeWithSize(randomizedBST.root);
	        System.out.println("\n");

	        // Perform rightRotation and print the tree with updated 'size' attributes
	        System.out.println("After rightRotation(50):");
	        RandomizedBSTNode node50 = randomizedBST.root.nodeSearch(50);
	        node50 = RandomizedBSTNode.rightRotation(node50);
	        printTreeWithSize(randomizedBST.root);
	        System.out.println("\n");

	        // Perform leftRotation and print the tree with updated 'size' attributes
	        System.out.println("After leftRotation(30):");
	        RandomizedBSTNode node30 = randomizedBST.root.nodeSearch(30);
	        node30 = RandomizedBSTNode.leftRotation(node30);
	        printTreeWithSize(randomizedBST.root);
	        System.out.println("\n");

	        // Perform rootInsert and print the tree with updated 'size' attributes
	        System.out.println("After rootInsert(60):");
	        randomizedBST.root = RandomizedBSTNode.rootInsert(randomizedBST.root, 60);
	        printTreeWithSize(randomizedBST.root);
	        System.out.println("\n");
	}
	
	// Helper method to print the tree with 'size' attributes using in-order traversal
    private static void printTreeWithSize(RandomizedBSTNode node) {
        if (node == null) {
            return;
        }

        printTreeWithSize(node.left);
        System.out.println("Node: " + node.key + ", Size: " + node.size);
        printTreeWithSize(node.right);
    }

	private static void createAndInsertTree() {

	}

	private static void createAndTraverseTree() {
		RandomizedBST randomizedBST = new RandomizedBST();

		// Insert 10-15 random elements into the tree using randomizedBSTInsert
		Random random = new Random();
		int numNodes = random.nextInt(6) + 10; // Generate a random number between 10 and 15
		System.out.println("Inserting " + numNodes + " random elements into the Randomized BST:");
		for (int i = 0; i < numNodes; i++) {
			int key = random.nextInt(100); // Generate a random integer key (you can adjust the range)

			System.out.print(key + " ");
			randomizedBST.randomizedBSTInsert(key);
		}
		System.out.println("\n");

		// Print the tree using pre-order, in-order, and post-order traversals
		System.out.println("Pre-order traversal:");
		randomizedBST.printPreorder();
		System.out.println("\n");

		System.out.println("In-order traversal:");
		randomizedBST.printInorder();
		System.out.println("\n");

		System.out.println("Post-order traversal:");
		randomizedBST.printPostorder();
		System.out.println("\n");

		// Get and print the height of the tree
		int height = randomizedBST.getHeight();
		System.out.println("Height of the Randomized BST: " + height);
	}
}
