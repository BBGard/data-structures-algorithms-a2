package temp;

import java.util.Random;

//Define the Randomized BST Node class
class RandomizedBSTNode {
 int key;
 RandomizedBSTNode left, right;
 int size; // Size of the subtree rooted at this node

 public RandomizedBSTNode(int key) {
     this.key = key;
     this.size = 1;
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
}


