# Data Structures and Algorithms Assignment 2
## University Assignment
### Randomized Binary Search Trees Implementation
#### Overview:
Written in Java, this programming assignment for ITECH 3109 Data Structures and Algorithms involves the implementation of Randomized Binary Search Trees (Randomized BST) using either Java or C. The primary objective is to enhance the provided Binary Search Tree (BST) implementation by introducing randomness to achieve an efficient BST structure.

#### Key Tasks:

**1. Building Randomized BST:**
- Implement Randomized BST using Java or C.
- Assume integer-type data values for simplicity.
- Modify provided BST code:
  - Define additional attribute(s).
  - Modify existing methods/functions.
  - Write new implementations for required methods/functions.
- Implement RandomizedBSTNode as a self-referential class/struct with an additional attribute int size representing the number of nodes in the tree rooted at this node.
- Implement/modify methods: leftRotation, rightRotation, rootInsert to efficiently recalculate size attributes.

**2. RandomizedBST Class/Struct:**
- Create a class/struct RandomizedBST to provide an interface for functionality implemented in RandomizedBSTNode, similar to the provided BST class/struct.

**3. Driver Program:**
- Design and write a program to test correctness.
- Validate leftRotation, rightRotation, and rootInsert by showing correct calculation of size attributes.
- Create a small Randomized BST (10-15 nodes) using randomizedBSTInsert.
- Print the tree using pre-order, post-order, and in-order traversals.
