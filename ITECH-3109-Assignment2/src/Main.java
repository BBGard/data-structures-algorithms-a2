
public class Main {
    /**
     * The Driver program for the Randomized Binary Search Tree
     * This program will test the implementation of the Randomized Binary Search
     * Tree
     *
     * @author Benjamin Gardiner
     */
    public static void main(String[] args) {
        testRotationAndRootInsert(); // Test Rotation and Root Insert
        testRandomInsertAndDelete(); // Test Insertion and Deletion
    }

    /**
     * Test the correct implementation of leftRotation, rightRotation, and
     * rootInsert
     *
     * This test will build a tree manually and then insert a node into the tree
     * using rootInsert
     * The tree will rotate until the inserted node is at the root of the tree
     * The size attribute of the nodes will be printed to verify the correct
     * implementation of the size attribute
     * The expected output of the program is shown after each insertion
     */
    public static void testRotationAndRootInsert() {
        System.out.println(
                "\n\n\n--------------------------------------------------------------------------------------");
        System.out.println("----------------- TEST 1: leftRotation, rightRotation, rootInsert -----------------");
        System.out.println(
                "\n\n- To test the correct implementation of leftRotation, rightRotation, and rootInsert a tree will be built manually with 5 nodes.");
        System.out.println(
                "- Using 'rootInsert' to insert a node into the tree will then cause the tree to rotate until the inserted node is at the root of the tree.");

        System.out.println("\n----------- BEGIN TEST 1 -----------");
        System.out.println("\nBuild tree consisting of 1, 2, 3, 5, 6");
        RandomizedBST tree = new RandomizedBST();
        tree.nodeInsert(1);
        tree.nodeInsert(5);
        tree.nodeInsert(3);
        tree.nodeInsert(6);
        tree.nodeInsert(2);

        System.out.println("\n----- Verify tree -----\n");
        System.out.println("Inorder:");
        tree.printInorder();
        System.out.println(" - Expected: 1 2 3 5 6");
        System.out.println("\nPreorder:");
        tree.printPreorder();
        System.out.println(" - Expected: 1 5 3 2 6");
        System.out.println("\nPostorder:");
        tree.printPostorder();
        System.out.println(" - Expected: 2 3 6 5 1");
        System.out.println("\nHeight of tree: " + RandomizedBSTNode.getHeight(tree.root));
        System.out.println("Expected height: 4");

        System.out.println("\n-----------------------------------------------------");
        System.out.println("\n------- ROOT INSERT -------");
        System.out.println(
                "\nIf we rootInsert 4, the tree should rotate correctly to form a balanced tree with 4 as the root.");
        System.out.println("\nrunning rootInsert(4)...");
        tree.rootInsert(4);
        System.out.println("\n----- Verify tree -----\n");
        System.out.println("Current value of root: " + tree.root.key);
        System.out.println("\nInorder:");
        tree.printInorder();
        System.out.println(" - Expected: 1 2 3 4 5 6");
        System.out.println("\nPreorder:");
        tree.printPreorder();
        System.out.println(" - Expected: 4 1 3 2 5 6");
        System.out.println("\nPostorder:");
        tree.printPostorder();
        System.out.println(" - Expected: 2 3 1 6 5 4");
        System.out.println("\nHeight of tree: " + RandomizedBSTNode.getHeight(tree.root));
        System.out.println("Expected height: 4");

        System.out.println("\n-----------------------------------------------------");
        System.out.println("\n------- TEST SIZE ATTRIBUTE -------");
        System.out.println(
                "\nTo verify the correct implementation of the 'size' attribute, the size of the root node, and the size of the left and right children of the root node will be printed.");
        System.out.println("\nSize of root node\nOutput: " + RandomizedBSTNode.getSize(tree.root));
        System.out.println("Expected: 6");
        System.out.println("\nSize of left child of root node (node value 1)\nOutput: "
                + RandomizedBSTNode.getSize(tree.root.left));
        System.out.println("Expected: 3");
        System.out.println("\nSize of right child of root node (node value 5)\nOutput: "
                + RandomizedBSTNode.getSize(tree.root.right));
        System.out.println("Expectede: 2");
        System.out
                .println("\nSize of the node with value 3\nOutput: " + RandomizedBSTNode.getSize(tree.root.left.right));
        System.out.println("Expected: 2");
        System.out.println(
                "\nSize of the node with value 2\nOutput: " + RandomizedBSTNode.getSize(tree.root.left.right.left));
        System.out.println("Expected: 1");
        System.out.println(
                "\nSize of the node with value 6\nOutput: " + RandomizedBSTNode.getSize(tree.root.right.right));
        System.out.println("Expected: 1");
        System.out.println("\n------------ END TEST 1 ------------");

    }

    /**
     * Test the correct implementation of randomizedBSTInsert and
     * randomizedBSTDelete
     *
     * This test will insert 15 nodes into the tree and print the size of the root
     * node after each insertion.
     * The expected size of the root node is shown after each insertion.
     * This will prove the correct implementation of randomizedBSTInsert,
     * leftRotation, and rightRotation.
     * The tree will then be traversed using inorder, preorder, and postorder
     * traversal.
     * The expected output of the program is shown after each traversal.
     *
     * The tree will then be deleted using randomizedBSTDelete.
     * The size of the root node will be printed after each deletion.
     * The expected size of the root node is shown after each deletion.
     * The tree will then be traversed using inorder, preorder, and postorder
     * traversal.
     * The expected output of the program is shown after each traversal.
     *
     * Finally, the average height of 1000 trees with 15 nodes will be calculated
     * and printed.
     */
    private static void testRandomInsertAndDelete() {
        System.out.println(
                "\n\n\n--------------------------------------------------------------------------------------");
        System.out.println("\n\n--------------- TEST 2 randomizedBSTInsert: ---------------");
        System.out.println("-");
        System.out.println(
                "- This test will insert 15 nodes into the tree using randomizedBSTInsert, and print the size of the root node after each insertion.");
        System.out.println(
                "- The expected size of the root node is calculated as the number of nodes in the tree at that point in time.");
        System.out.println(
                "- This will prove the correct implementation of randomizedBSTInsert, leftRotation, and rightRotation.");
        System.out.println("-");

        RandomizedBST tree = new RandomizedBST();
        System.out.println("\nInserting 10...");
        tree.randomizedBSTInsert(10);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 1");
        System.out.println("Root value: " + tree.root.key);
        System.out.println("\nInserting 5...");
        tree.randomizedBSTInsert(5);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 2");
        System.out.println("Root value: " + tree.root.key);

        System.out.println("\nInserting 15...");

        tree.randomizedBSTInsert(15);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 3");
        System.out.println("Root value: " + tree.root.key);

        System.out.println("\nInserting 3...");

        tree.randomizedBSTInsert(3);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 4");
        System.out.println("Root value: " + tree.root.key);

        System.out.println("\nInserting 7...");

        tree.randomizedBSTInsert(7);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 5");
        System.out.println("Root value: " + tree.root.key);

        System.out.println("\nInserting 12...");

        tree.randomizedBSTInsert(12);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 6");
        System.out.println("Root value: " + tree.root.key);

        System.out.println("\nInserting 17...");

        tree.randomizedBSTInsert(17);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 7");
        System.out.println("Root value: " + tree.root.key);

        System.out.println("\nInserting 1...");

        tree.randomizedBSTInsert(1);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 8");
        System.out.println("Root value: " + tree.root.key);

        System.out.println("\nInserting 4, 6, 8, 11, 13, 16, and 18...");

        tree.randomizedBSTInsert(4);
        tree.randomizedBSTInsert(6);
        tree.randomizedBSTInsert(8);
        tree.randomizedBSTInsert(11);
        tree.randomizedBSTInsert(13);
        tree.randomizedBSTInsert(16);
        tree.randomizedBSTInsert(18);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected: 15");
        System.out.println("Root value: " + tree.root.key);

        System.out.println("\n\n\n--------------- Traversals: ---------------");
        System.out.println("\nInorder:");
        tree.printInorder();

        // Print the expected output of the program
        System.out.println("\n\nExpected output:");
        System.out.println("1 3 4 5 6 7 8 10 11 12 13 15 16 17 18");

        System.out.println("\n\nPreorder:");
        tree.printPreorder();

        System.out.println("\n\nPostorder:");
        tree.printPostorder();

        System.out.println("\n\n------------- END TEST 2 -------------");

        System.out.println("\n\n\n-------------- TEST 3: randomizedBSTDelete: --------------");
        System.out.println("- ");
        System.out.println(
                "- This test will delete a number of nodes from the tree using randomizedBSTDelete, and print the size of the root node, the root nodes value, and the traversals after each deletion.");
        System.out.println("\nDeleting 10...");
        tree.randomizedBSTDelete(10);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected size of root node: 14");
        System.out.println("Root: " + tree.root.key);
        System.out.println("\nInorder:");
        tree.printInorder();
        System.out.println("\nPreorder:");
        tree.printPreorder();
        System.out.println("\nPostorder:");
        tree.printPostorder();

        System.out.println("\n\nDeleting 5...");
        tree.randomizedBSTDelete(5);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected size of root node: 13");
        System.out.println("Root: " + tree.root.key);
        System.out.println("\nInorder:");
        tree.printInorder();
        System.out.println("\nPreorder:");
        tree.printPreorder();
        System.out.println("\nPostorder:");
        tree.printPostorder();

        System.out.println("\n\nDeleting 15...");
        tree.randomizedBSTDelete(15);
        System.out.println("Size of root node: " + tree.root.size);
        System.out.println("Expected size of root node: 12");
        System.out.println("Root: " + tree.root.key);
        System.out.println("\nInorder:");
        tree.printInorder();
        System.out.println("\nPreorder:");
        tree.printPreorder();
        System.out.println("\nPostorder:");
        tree.printPostorder();

        System.out.println("\n----------------- END TEST 3 -----------------");

        System.out.println("\n\n\n--------------- TEST 4: average height of random trees: ---------------");
        System.out.println("\n- This test will create a new tree and insert 15 nodes randomly into the tree.");
        System.out.println("- It will repeat this process 1000 times and calculate the average height of the 1000 trees.");
        System.out.println(
                "- The expected average height of the 1000 trees is 4.907 using (log(n) + 1, where n is the number of nodes).");

        System.out.println("\n\nCreating trees...");
        int numberOfTrees = 1000;
        int numberOfNodes = 15;
        double totalHeight = 0;
        double averageHeight = 0;

        // Create 1000 trees with 15 nodes
        for (int i = 0; i < numberOfTrees; i++) {
            RandomizedBST randomTree = new RandomizedBST();
            for (int j = 0; j < numberOfNodes; j++) {
                randomTree.randomizedBSTInsert((int) (Math.random() * 10));
            }
            totalHeight += RandomizedBSTNode.getHeight(randomTree.root);
        }

        System.out.println("\nResults:\n");
        averageHeight = totalHeight / numberOfTrees;
        System.out.println(
                "Average height of " + numberOfTrees + " trees with " + numberOfNodes + " nodes: " + averageHeight);

        System.out
                .println("Expected average height: " + String.format("%.3f", ( 1+ Math.log(numberOfNodes) / Math.log(2))));

        System.out.println("\n----------------- END TEST 5 -----------------");
        System.out.println("\n");
        System.out.println("----------------- END OF TESTS -----------------");
        System.out.println("-----------------------------------------------");
    }

}
