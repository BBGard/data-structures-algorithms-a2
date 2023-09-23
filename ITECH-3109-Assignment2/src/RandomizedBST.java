
/**
 * Randomized Binary Search Tree
 * @author Benjamin Gardiner
 * Based on the BST class provided by Eldar Hajilarov
 */
public class RandomizedBST {
  RandomizedBSTNode root; // root - the root of the tree

  /**
   * Constructor
   * Initializes the tree with a null root node
   */
  public RandomizedBST() {
    root = null;
  }

  /**
   * Constructor
   * Initializes the tree with a given root node
   *
   * @param node - the root of the tree
   */
  public RandomizedBST(RandomizedBSTNode node) {
    root = node;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Implement methods to provide an interface for RandomizedBST operations
  // These methods should use the corresponding methods in RandomizedBSTNode
  // to perform the operations

  /**
   * Implementation of randomized BST insert at a node
   *
   * @param key - the value of the node
   * @return true if key inserted
   */
  public boolean randomizedBSTInsert(int key) {
    if(root == null) {
      root = new RandomizedBSTNode(key);
      return true;
    } else {
      root = RandomizedBSTNode.randomizedBSTInsert(root, key);
      return true;
    }
  }

  /**
   * Implementation of randomized BST insert at the root
   * @param key - the value of the node
   * @return true if key inserted
   */
  public boolean rootInsert(int key){
    if(root == null) {
      root = new RandomizedBSTNode(key);
      return true;
    } else {
      root = RandomizedBSTNode.rootInsert(root, key);
      return true;
    }
}

  /**
   * Implementation of randomized BST delete at a node
   *
   * @param key - the value of the node
   * @return true if key deleted
   */
  public boolean randomizedBSTDelete(int key) {
    if(root == null) {
      System.out.println("The tree is empty!");
      return false;
    } else {
      root = RandomizedBSTNode.randomizedBSTDelete(root, key);
      return true;
    }
  }

  public boolean nodeInsert(int key) {
    if(root == null) {
      root = new RandomizedBSTNode(key);
      return true;
    } else {
      return root.nodeInsert(key);
    }
  }

  // Print methods
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
