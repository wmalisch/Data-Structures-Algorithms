package Structures;

/**
 * BinarySearchTree implementation from GeeksforGeeks
 *
 * @author GeeksforGeeks
 */
public class BinaryTree {

    /* Class containing left  
       and right child of current node 
     * and key value*/
    public class Node
    {
        public int key;
        public Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST 
    public Node root;

    // Constructor 
    public BinaryTree()
    {
        root = null;
    }

    // This method mainly calls insertRec() 
    public void insert(int key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to  
       insert a new key in BST */
    public Node insertRec(Node root, int key)
    { 
  
        /* If the tree is empty, 
           return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec() 
    public void inorder()
    {
        inorderRec(root);
    }

    // A utility function to  
    // do inorder traversal of BST 
    public void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

} 