package Structures;

public class TreeNode {
    public int key, height;
    public TreeNode left, right;

    public TreeNode(int key){
        this.height = 1;
        this.key = key;
    }

    public int getKey(){
        return this.key;
    }

}
