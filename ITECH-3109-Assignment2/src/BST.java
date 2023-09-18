
/**
 *
 * @author Eldar Hajilarov
 * Modified by Benjamin Gardiner
 * 
 */
public class BST {

    BSTNode root;

    public BST() {
        root = null;
    }

    public BST(BSTNode node) {
        root = node;
    }

    public BSTNode nodeSearch(int key){
        return root.nodeSearch(key);
    }
    
    public int getHeight() {
        return BSTNode.getHeight(root);
    }

    public void printPreorder() {
        root.printPreorderNode();
    }

    public void printInorder() {
        root.printInorderNode();
    }

    public void printPostorder() {
        root.printPostorderNode();
    }
    
    public boolean nodeInsert(int key){
        return root.nodeInsert(key);
    }
    
    public boolean nodeDelete(int key){
        return root.nodeDelete(key);
    }
    
    public void rootInsert(int key){
        root = BSTNode.rootInsert(root, key);
    }
    
    public boolean rootSearch(int key){
        if(key != root.key){
            root = BSTNode.rootSearch(root, key);
            return key == root.key;
        }
        return false;
    }
}
