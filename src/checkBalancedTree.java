import java.lang.Math;

public class checkBalancedTree {

    public static int height(BinaryTree.Node node){
        if(node == null){
            return -1;
        }else{
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public static boolean isBalanced(BinaryTree.Node root){
        if(root == null){ return true; }
        return (Math.abs(height(root.left) - height(root.right)) < 2) && isBalanced(root.left) && isBalanced(root.right);
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
        System.out.println(isBalanced(tree.root));
    }
}
