import java.lang.Math;
final class TreeInfo{
    public int height;
    public boolean balanced;

    public TreeInfo(int height, boolean balanced){
        this.height = height;
        this.balanced = balanced;
    }
}


public class checkBalancedTree {
    /**
     * Method to get height of a binary tree
     * @param node
     * @return height, where height of single node tree is 0, and two node tree is 1
     */
    public static int height(BinaryTree.Node node){
        if(node == null){
            return -1;
        }else{
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    /**
     * Top down recursion
     * @param root
     * @return true if tree is balanced
     */
    public static boolean isBalanced(BinaryTree.Node root){
        if(root == null){ return true; }

        // Check if current node height is balanced, then recurse to children nodes. O(n log n) Time complexity
        return (Math.abs(height(root.left) - height(root.right)) < 2) && isBalanced(root.left) && isBalanced(root.right);
    }

    private static TreeInfo isBalancedHelper(BinaryTree.Node root){
        if(root == null){
            return new TreeInfo(-1, true);
        }
        TreeInfo left = isBalancedHelper(root.left);
        if(!left.balanced){
            return new TreeInfo(-1,false);
        }
        TreeInfo right = isBalancedHelper(root.right);
        if(!right.balanced){
            return new TreeInfo(-1,false);
        }

        if(Math.abs(left.height - right.height) < 2){
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }

        return new TreeInfo(-1,false);
    }

    public static boolean isBalancedBottomUp(BinaryTree.Node root){
        return isBalancedHelper(root).balanced;
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(110);
        tree.insert(120);
        System.out.println(tree.root.key);
        System.out.println(isBalancedBottomUp(tree.root));
    }
}
