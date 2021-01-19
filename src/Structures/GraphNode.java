package Structures;

public class GraphNode {
    int n;
    String name;
    public GraphNode(int n, String name){
        this.n = n;
        this.name = name;
    }

    public int getVal(){
        return this.n;
    }

    public String getName(){
        return this.name;
    }

    public void setVal(int v){
        this.n = v;
    }

    public void setName(String name){
        this.name = name;
    }
}
