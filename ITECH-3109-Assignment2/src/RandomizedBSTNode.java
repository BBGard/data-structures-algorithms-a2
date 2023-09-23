
/**
 * Randomized Binary Search Tree Node
 * @author Benjamin Gardiner
 * Based on the BSTNode class provided by Eldar Hajilarov
 */
public class RandomizedBSTNode {
  int key; // key - the value of the node
  RandomizedBSTNode left; // left - the left child of the node
  RandomizedBSTNode right; // right - the right child of the node
  int size; // size - the number of nodes in the subtree rooted at this node

  /**
   * Constructor - initializes the node with a given key
   * @param key - the value of the node
   */
  public RandomizedBSTNode(int key) {
    this.key = key;
    this.left = null;
    this.right = null;
    this.size = 1; // the size of a node is 1
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Modified methods for leftRotation, rightRotation, rootInsert, randomizedBSTInsert, randomizedBSTDelete

  /**
   * Implementation of left rotation at a node
   * @param node - the node to rotate
   * @return the new root of the subtree
   */
  public static RandomizedBSTNode leftRotation(RandomizedBSTNode node) {

    if(node == null || node.right == null) {
      return node;
    }

    // Perform left rotation
    RandomizedBSTNode newRoot = node.right;
    node.right = newRoot.left;
    newRoot.left = node;

    // Update size for node and newRoot
    node.size = 1 + getSize(node.left) + getSize(node.right);
    newRoot.size = 1 + getSize(newRoot.left) + getSize(newRoot.right);

    return newRoot;
  }

  /**
   * Implementation of right rotation at a node
   * @param node - the node to rotate
   * @return the new root of the subtree
   */
  public static RandomizedBSTNode rightRotation(RandomizedBSTNode node) {

    if(node == null || node.left == null) {
      return node;
    }

    // Perform right rotation
    RandomizedBSTNode newRoot = node.left;
    node.left = newRoot.right;
    newRoot.right = node;

    // Update size for node and newRoot
    node.size = 1 + getSize(node.left) + getSize(node.right);
    newRoot.size = 1 + getSize(newRoot.left) + getSize(newRoot.right);

    return newRoot;
  }

  /**
   * Implementation of root insert at a node
   * @param node - the node to insert at
   * @param key - the value of the node to insert
   * @return the inserted node
   */
  public static RandomizedBSTNode rootInsert(RandomizedBSTNode node, int key) {
    if(node == null) {
      // Tree is empty, create new node
      return new RandomizedBSTNode(key);
    }

    // Insert key and perform rotations
    if(key < node.key) {
      node.left = rootInsert(node.left, key);
      node = rightRotation(node);
    } else {
      node.right = rootInsert(node.right, key);
      node = leftRotation(node);
    }

    // No need to update size as it is updated in the rotations
    return node;
  }

  /**
   * Implementation of randomized BST insert at a node
   * @param node - the node to insert at
   * @param key - the value of the node to insert
   * @return the inserted node
   * @implNote (from ITECH-3109 Lec6.1)
   * - uses the following recursive algorithm  for randomized insertion into BST with n nodes:
	 * - With probability 1 / (n+1) perform a root insertion and stop;
	 * - With the probability n / (n+1) , apply the same algorithm recursively to the appropriate (left or right) subtree;
   * - To get n at each step, we need to store the size of each subtree and update it during the insertion operations.
   */
  public static RandomizedBSTNode randomizedBSTInsert(RandomizedBSTNode node, int key) {
    if(node == null) {
      // Tree is empty, create new node
      // System.out.println("Empty tree!");
      return new RandomizedBSTNode(key);
    }

    // Generate a random probability to decide to insert at root or recursively
    double probability = Math.random(); // Generates a random double between 0.0 and 1.0
    // Probability of inserting at root is 1 / (N + 1)
    double rootProbability = 1.0 / (RandomizedBSTNode.getSize(node) + 1); 

    // Insert key and perform rotations
    if(probability < rootProbability) {
      node = rootInsert(node, key);
    } else {
      if(key < node.key) {
        node.left = randomizedBSTInsert(node.left, key);
      } else {
        node.right = randomizedBSTInsert(node.right, key);
      }
    }

    // Update the size of the node
    node.size = 1 + RandomizedBSTNode.getSize(node.left) + RandomizedBSTNode.getSize(node.right);

    // Check and fix balance using rotations if needed
    int balance = getBalance(node);

    if (balance > 1) {
        // Left-heavy, perform right rotation or left-right rotation
        if (getBalance(node.left) >= 0) {
            return rightRotation(node);
        } else {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
    } else if (balance < -1) {
        // Right-heavy, perform left rotation or right-left rotation
        if (getBalance(node.right) <= 0) {
            return leftRotation(node);
        } else {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }
    }

    return node;
  }

  /**
 * Implementation of randomized BST delete at a node
 * @param node - the node to delete at
 * @param key - the value of the node to delete
 * @return the deleted node
 * @implNote (from ITECH-3109 Lec6.1)
 * - First, we define a join of two disjoint BSTs, T1 (of size n1) and T2 (of size n2),
 * - such that all keys in T1 are less than all keys in T2.
 * - Use T1 as root with probability n1 / (n1 + n2), and recursively join right subtree of T1 with T2;
 * - Use T2 as root with probability n2 / (n1 + n2), and recursively join left subtree of T2 with T1;
 * - Randomized delete:
 * - Given a key k, find a node with k and delete it;
 * - Join two broken subtrees as above;
 */
  public static RandomizedBSTNode randomizedBSTDelete(RandomizedBSTNode node, int key) {
    if(node == null) {
      return null;
    }

    // Delete key and perform rotations
    if(key == node.key) {
      // Join the left and right subtrees
      node = join(node.left, node.right);
    } else if(key < node.key) {
      // Delete key from left subtree and perform rotations
      node.left = randomizedBSTDelete(node.left, key);
      node = rightRotation(node);
    } else {
      // Delete key from right subtree and perform rotations
      node.right = randomizedBSTDelete(node.right, key);
      node = leftRotation(node);
    }

    // No need to update size as it is updated in the rotations

    // Check and fix balance using AVL rotations if needed
    int balance = getBalance(node);

    if (balance > 1) {
        // Left-heavy, perform right rotation or left-right rotation
        if (getBalance(node.left) >= 0) {
            return rightRotation(node);
        } else {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
    } else if (balance < -1) {
        // Right-heavy, perform left rotation or right-left rotation
        if (getBalance(node.right) <= 0) {
            return leftRotation(node);
        } else {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }
    }

    return node;
  }

  /**
   * Implementation of join of two disjoint BSTs
   * @param tree1 - the first tree
   * @param tree2 - the second tree
   * @return the joined tree
   */
	public static RandomizedBSTNode join(RandomizedBSTNode tree1, RandomizedBSTNode tree2) {
		if (tree1 == null) {
			return tree2;
		}
		if (tree2 == null) {
			return tree1;
		}

		// Join the two subtrees using a random probability
		double probability = Math.random();
		// Probability of joining tree1 as root is size of tree1 / (size of tree1 + size
		// of tree2)
		double tree1Probability = RandomizedBSTNode.getSize(tree1)
				/ (RandomizedBSTNode.getSize(tree1) + RandomizedBSTNode.getSize(tree2));

		if (probability < tree1Probability) {
			// Join tree1 as root and recursively join right subtree of tree1 with tree2
			tree1.right = join(tree1.right, tree2);
			tree1 = leftRotation(tree1);
		} else {
			// Join tree2 as root and recursively join left subtree of tree2 with tree1
			tree2.left = join(tree1, tree2.left);
			tree2 = rightRotation(tree2);
		}

		// No need to update size as it is updated in the rotations

		return tree1;
	}


  /*******************************************************************************************************
   * Helper methods - From provided BSTNode, unless otherwise stated
   */

  // Returns the size of a node
  public static int getSize(RandomizedBSTNode node) {
    if(node == null) {
      return 0;
    }
    return node.size;
  }

  // Returns the balance of a node
  public static int getBalance(RandomizedBSTNode node) {
    if(node == null) {
      return 0;
    }
    return getHeight(node.left) - getHeight(node.right);
  }

  // Returns the height of a node
  public static int getHeight(RandomizedBSTNode node) {
    if(node == null) {
      return 0;
    }
    return 1 + Math.max(getHeight(node.left), getHeight(node.right));
  }

  // Returns the node with the given key
  public static RandomizedBSTNode nodeSearch(RandomizedBSTNode node, int key) {
    if(node == null || node.key == key) {
      return node;
    }

    if(key < node.key) {
      return nodeSearch(node.left, key);
    } else {
      return nodeSearch(node.right, key);
    }
  }

  // Root search for a node with the given key
  public static boolean rootSearch(RandomizedBSTNode node, int key) {
    if(node == null) {
      return false;
    }

    if(key == node.key) {
      return true;
    }

    if(key < node.key) {
      node = rightRotation(node);
      return rootSearch(node.left, key);
    } else {
      node = leftRotation(node);
      return rootSearch(node.right, key);
    }
  }

  // Implementation of standard BST insert at a node
  // returns true if key inserted
  // returns false if key already exists
  public boolean nodeInsert(int key) {
    if (key == this.key) {
      System.err.println("The tree already contains a node with the key: " + key);
      return false;
    }
    if (key < this.key) {
      if (left == null) {
        left = new RandomizedBSTNode(key);
        return true;
      } else {
        return left.nodeInsert(key);
      }
    } else {
      if (right == null) {
        right = new RandomizedBSTNode(key);
        return true;
      } else {
        return right.nodeInsert(key);
      }
    }
  }

  // Prints the tree using preorder traversal
  public void printPreorderNode() {
    System.out.print(key + " ");
    if (left != null) {
      left.printPreorderNode();
    }
    if (right != null) {
      right.printPreorderNode();
    }
  }

  // Prints the tree using inorder traversal
  public void printInorderNode() {
    if (left != null) {
      left.printInorderNode();
    }
    System.out.print(key + " ");
    if (right != null) {
      right.printInorderNode();
    }
  }

  // Prints the tree using postorder traversal
  public void printPostorderNode() {
    if (left != null) {
      left.printPostorderNode();
    }
    if (right != null) {
      right.printPostorderNode();
    }
    System.out.print(key + " ");
  }


}
