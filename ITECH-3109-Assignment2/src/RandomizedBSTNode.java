
/**
 * 
 * @author Benjamin Gardiner
 * Based on the BSTNode class provided by Eldar Hajilarov
 */
public class RandomizedBSTNode {
    int key; // data at the node
    RandomizedBSTNode left; // left child
    RandomizedBSTNode right; // right child
    int size; // Size of the subtree rooted at this node

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
        
        RandomizedBSTNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        // Update sizes
        newRoot.size = node.size;
        node.size = getSize(node.left) + getSize(node.right) + 1;
        return newRoot;
//        RandomizedBSTNode temp = node;
//        node = node.left;
//        temp.left = node.right;
//        node.right = temp;
//        
//        temp.size = node.size;
//        node.size = getSize(node.left) + getSize(node.right) + 1;
//
//        return node;
    }
    
 // Perform a left rotation at the node and return the new root
    static RandomizedBSTNode leftRotation(RandomizedBSTNode node) {
        if (node == null || node.right == null) {
            return node;
        }
        
        RandomizedBSTNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        
        // Update sizes
        newRoot.size = node.size;
        node.size = getSize(node.left) + getSize(node.right) + 1;
        return newRoot;
        
//        RandomizedBSTNode temp = node;
//        node = node.right;
//        temp.right = node.left;
//        node.left = temp;
//        
//        temp.size = node.size;
//        node.size = getSize(node.left) + getSize(node.right) + 1;
//
//        return node;
    }
    
 // Root-insert at the node
    static RandomizedBSTNode rootInsert(RandomizedBSTNode node, int key) {
        if (node.nodeSearch(key) != null) {
            // Key is already in the tree
            return node;
        }
        return rootInsertHelper(node, key);
    }
    
 // Private recursive method, called by rootInsert
    private static RandomizedBSTNode rootInsertHelper(RandomizedBSTNode node, int key) {
//        if (node == null) {
//            node = new RandomizedBSTNode(key);
//            return node;
//        }
//        if (key < node.key) {
//            node.left = rootInsertHelper(node.left, key);
//            node = rightRotation(node);
//        } else {
//            node.right = rootInsertHelper(node.right, key);
//            node = leftRotation(node);
//        }
//
//        // Recalculate the size attributes
////        if (node.left != null) {
////            node.left.size = 1 + getSize(node.left.left) + getSize(node.left.right);
////        }
////        if (node.right != null) {
////            node.right.size = 1 + getSize(node.right.left) + getSize(node.right.right);
////        }
//        node.size = 1 + getSize(node.left) + getSize(node.right);
//
//        return node;
    	 // Insert key at the root
        RandomizedBSTNode newNode = new RandomizedBSTNode(key);
        
        if(node == null) {
        	return newNode;
        }
        
        if (key < node.key) {
            newNode.right = node;
        } else {
            newNode.left = node;
        }
        newNode.size = getSize(newNode.left) + getSize(newNode.right) + 1;
        return newNode;
    }
    
    // Gets the size of a node
    public static int getSize(RandomizedBSTNode node) {
    	if(node == null) {
    		return 0;
    	} 
    	else {
    		return node.size;
    	}
    }
    
    static RandomizedBSTNode randomizedBSTInsert(RandomizedBSTNode node, int key) {
        if (node.nodeSearch(key) != null) {
            // Key is already in the tree
            return node;
        }
        return randomizedBSTInsertHelper(node, key);
    }
    
    private static RandomizedBSTNode randomizedBSTInsertHelper(RandomizedBSTNode node, int key) {
        if (node == null) {
            return new RandomizedBSTNode(key);
        }

        // Generate a random probability to decide to insert at root or recursively
        double randomProbability = Math.random(); // Generate random probability
        double probabilityRoot = 1.0 / (getSize(node) + 1); // Probability 1/(N+1)

    
        // If probability is less than or equal to the threshold, perform root insert
        if(randomProbability <= probabilityRoot) {
            // Perform a root insertion and stop
            return RandomizedBSTNode.rootInsert(node, key);
        } else {
            // Recursively insert into the appropriate subtree
            if (key < node.key) {
                node.left = randomizedBSTInsertHelper(node.left, key);
            } else {
                node.right = randomizedBSTInsertHelper(node.right, key);
            }

            // Update the size attribute
//            node.size++;
            node.size = getSize(node.left) + getSize(node.right) + 1;

            return node;
        }
    }
    
     
	public RandomizedBSTNode randomizedBSTDelete(RandomizedBSTNode node, int key) {
		if (node == null) {
			return null; // Key not found
		}

		if (key == node.key) {
			// Node with the key is found; perform deletion and join two subtrees
			return join(node.left, node.right);
		} else if (key < node.key) {
			node.left = randomizedBSTDelete(node.left, key);
		} else {
			node.right = randomizedBSTDelete(node.right, key);
		}

		// Update the size attribute
		node.size--;

		return node;
	}
	
	private RandomizedBSTNode join(RandomizedBSTNode t1, RandomizedBSTNode t2) {
	    if (t1 == null) {
	        return t2;
	    }
	    if (t2 == null) {
	        return t1;
	    }

	    // Generate a random probability
	    double p = Math.random();
	    double threshold = (double) t1.size / (double) (t1.size + t2.size);

	    if (p <= threshold) {
	        // Use t1 as the root
	        t1.right = join(t1.right, t2);
	        // Update the size attribute
	        t1.size = t1.size + t2.size + 1;
	        return t1;
	    } else {
	        // Use t2 as the root
	        t2.left = join(t1, t2.left);
	        // Update the size attribute
	        t2.size = t1.size + t2.size + 1;
	        return t2;
	    }
	}
	
	// Helper method to check if a subtree is balanced
//    public static boolean isBalanced(RandomizedBSTNode node) {
//        if (node == null) {
//            return true; // An empty subtree is balanced
//        }
//
//        int leftHeight = getHeight(node.left);
//        int rightHeight = getHeight(node.right);
//        
////        System.out.println("leftHeight: " + leftHeight);
////        System.out.println("rightHeight: " + rightHeight);
//
//        // Check if the heights of left and right subtrees differ by at most 1
//        if (Math.abs(leftHeight - rightHeight) <= 1) {
//            // Recursively check left and right subtrees
//            return isBalanced(node.left) && isBalanced(node.right);
//        }
//
//        return false; // The tree is not balanced
//    }

    
    //////////////////////// Methods from BSTNode ///////////////////////////////////
  //Implementation of standard BST search at a node 
    //returns node that contains the key
    RandomizedBSTNode nodeSearch(int key) {
    	RandomizedBSTNode node = this;

        while (node != null) {
            if (key == node.key) {
                return node;
            } else if (key < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
    
  //Root-search at the node
    static RandomizedBSTNode rootSearch(RandomizedBSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.key) {
            return node;
        }
        if (key < node.key) {
        	RandomizedBSTNode temp = rootSearch(node.left, key);
            if (temp != null) {
                node.left = temp;
                node = rightRotation(node);
                return node;
            }
            return null;
        }
        if (key > node.key) {
        	RandomizedBSTNode temp = rootSearch(node.right, key);
            if (temp != null) {
                node.right = temp;
                node = leftRotation(node);
                return node;
            }
            return null;
        }
        return null;
    }
    
    @Override
    public String toString() {
        String s = "data: " + key;
        return s;
    }
    
    static int getHeight(RandomizedBSTNode n) {
        if (n == null) {
            return 0;
        }
        int h1 = getHeight(n.left);
        int h2 = getHeight(n.right);
        
        return h1 > h2 ? h1 + 1 : h2 + 1;
    }

    void printPreorderNode() {
        System.out.print(key + " ");
        if (left != null) {
            left.printPreorderNode();
        }
        if (right != null) {
            right.printPreorderNode();
        }
    }

    void printInorderNode() {
        if (left != null) {
            left.printInorderNode();
        }
        System.out.print(key + " ");
        if (right != null) {
            right.printInorderNode();
        }
    }

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

