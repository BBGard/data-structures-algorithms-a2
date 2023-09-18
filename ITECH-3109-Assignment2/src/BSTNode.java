
/**
 *
 * @author Eldar Hajilarov
 * Modified by Benjamin Gardiner
 */
public class BSTNode {

    int key;//data at the node
    BSTNode left;//left child
    BSTNode right;//right child
    
    int size; // the number of nodes in the tree with the root at *this* node

    public BSTNode(int key) {
        this.key = key;
        left = null;
        right = null;
        
        size = 1; // Initialize the size to 1 for the current node
    }
////////////////////////////Standard BST///////////////////////////////////////

    //Implementation of standard BST search at a node 
    //returns node that contains the key
    BSTNode nodeSearch(int key) {
        BSTNode node = this;

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

    //Implementation of standard BST insert at a node 
    boolean nodeInsert(int key) {
        if (key == this.key) {
            System.err.println("The tree already contains a node with the key: " + key);
            return false;
        }
        if (key < this.key) {
            if (left == null) {
                left = new BSTNode(key);
                return true;
            } else {
                return left.nodeInsert(key);
            }
        } else {
            if (right == null) {
                right = new BSTNode(key);
                return true;
            } else {
                return right.nodeInsert(key);
            }
        }
    }

    //Private method required by nodeDelete:
    //if the key is not found - returns null 
    //if the key is at the root - returns the root
    //otherwise, returns the parent of the node that contains the key
    private BSTNode parentSearch(int key) {
        BSTNode parent = this;
        BSTNode node = this;

        while (node != null) {
            if (key == node.key) {
                return parent;
            } else if (key < node.key) {
                parent = node;
                node = node.left;
            } else {
                parent = node;
                node = node.right;
            }
        }
        return null;
    }

    //Implementation of standard BST delete:
    //if this.key == key the method does not delete the node and returns false
    //if the key is not found the method returns false
    //otherwise, it deletes the node containing the key and returns true
    boolean nodeDelete(int key) {
        if (this.key == key) {
            return false;
        }
        BSTNode parent = parentSearch(key);//parent of the node to be deleted
        if (parent == null) {
            return false; //nothing to delete
        }
        boolean isLeftChild = true;
        if (parent.left != null) {
            isLeftChild = parent.left.key == key;
        }

        BSTNode node = isLeftChild ? parent.left : parent.right;

        if (node.left == null && node.right == null) {// deletes a leaf
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;
        }
        if (node.left != null && node.right == null) {//deletes a node with only a left child
            parent.left = node.left;
            return true;
        }
        if (node.left == null && node.right != null) {//deletes a node with only a right child
            parent.right = node.right;
            return true;
        }

        BSTNode base = node.right;//defines the base point - the right child of the node to be deleted

        if (base.left == null) {//the base point does not have a left child
            if (isLeftChild) {
                parent.left = base;
            } else {
                parent.right = base;
            }
            base.left = node.left;
            return true;
        }
        BSTNode first = base;
        BSTNode second = base.left;
        while (second.left != null) {
            first = second;
            second = second.left;
        }

        first.left = second.right;
        second.right = base;
        second.left = node.left;
        if (isLeftChild) {
            parent.left = second;
        } else {
            parent.right = second;
        }
        return true;
    }

    static int getHeight(BSTNode n) {
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

/////////////////////////////Rotations, root-insert, root-search//////////////////////////
    //performs a right rotation at the node and returns the new root
    static BSTNode rightRotation(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        BSTNode temp = node;
        node = node.left;
        temp.left = node.right;
        node.right = temp;

        return node;
    }
    //performs a left rotation at the node and returns the new root
    static BSTNode leftRotation(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        BSTNode temp = node;
        node = node.right;
        temp.right = node.left;
        node.left = temp;

        return node;
    }

    //Root-insert at the node
    static BSTNode rootInsert(BSTNode node, int key) {
    	
        if (node.nodeSearch(key) != null) {//key is already in the tree
            return node;
        }
        return rootInsertHelper(node, key);
    }
    
    //Private recursive method, called by rootInsert
    //It does all the job
    private static BSTNode rootInsertHelper(BSTNode node, int key) {
        if (node == null) {
            node = new BSTNode(key);
            return node;
        }
        if (key < node.key) {
            node.left = rootInsertHelper(node.left, key);
            node = rightRotation(node);
            return node;
        } else {//(key > node.key)
            node.right = rootInsertHelper(node.right, key);
            node = leftRotation(node);
            return node;
        }
    }
    
    //Root-search at the node
    static BSTNode rootSearch(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.key) {
            return node;
        }
        if (key < node.key) {
            BSTNode temp = rootSearch(node.left, key);
            if (temp != null) {
                node.left = temp;
                node = rightRotation(node);
                return node;
            }
            return null;
        }
        if (key > node.key) {
            BSTNode temp = rootSearch(node.right, key);
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
}
