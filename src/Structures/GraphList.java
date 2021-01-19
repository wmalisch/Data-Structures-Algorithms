package Structures;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class GraphList {
    private HashMap<Integer, ArrayList<Integer>> adjVertices;
    private boolean directed;
    private boolean weighted;

    public GraphList(boolean directed, boolean weighted){
        this.directed = directed;
        this.weighted = weighted;
        adjVertices = new HashMap<>();
    }
}
