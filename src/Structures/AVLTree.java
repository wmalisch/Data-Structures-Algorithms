package Structures;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

import com.sun.source.tree.Tree;

public class AVLTree {

    public TreeNode root;

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public int balanceFactor(TreeNode node){
        return height(node.left) - height(node.right);
    }


    public TreeNode rr(TreeNode node){
        TreeNode one = node.left;
        TreeNode two = one.right;

        one.right = node;
        node.left = two;

        // Update heights (only node and one would change)
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        one.height = Math.max(height(one.left), height(one.right)) + 1;

        return one;
    }

    public TreeNode ll(TreeNode node){
        TreeNode one = node.right;
        TreeNode two = one.left;

        one.left = node;
        node.right = two;

        // Update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        one.height = Math.max(height(one.left), height(one.right)) + 1;

        return one;
    }

    public void preOrder(TreeNode root){
        if(root != null){
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.key);
        }
    }

    // Breadth first search level order traversal
    public void BFSlevelOrderTraversal(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr != null){
                q.add(curr.left);
                q.add(curr.right);
                System.out.println(curr.getKey());
            }
        }
    }

    // AVL Tree insert, O(log n) time and O(n) space
    public TreeNode insert(TreeNode node, int key){
        if(node == null){
            return (new TreeNode(key));
        }

        if( key < node.key ){
            node.left = insert(node.left, key);
        }else if( key > node.key ){
            node.right = insert(node.right, key);
        }else{
            return node;
        }

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check its respective balance factor
        int balance = balanceFactor(node);

        if(balance > 1 && key < node.left.key){
            return rr(node);
        }else if(balance < -1 && key > node.right.key){
            return ll(node);
        }else if(balance > 1 && key > node.left.key){
            node.left = ll(node.left);
            return rr(node);
        }else if(balance < -1 && key < node.right.key){
            node.right = rr(node.right);
            return ll(node);
        }

        return node;
    }

    public static void main(String[] args){
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 80);
        tree.root = tree.insert(tree.root, 90);
        tree.root = tree.insert(tree.root, 100);
    }

}
