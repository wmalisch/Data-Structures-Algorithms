package Structures;
import java.util.Map;
import java.util.HashMap;

public class GraphNode extends AbstractGraphNode {
    private Map<GraphNode, Integer> adjacentNodes;

    public GraphNode(String name, int val){
        this.name = name;
        this.val = val;
        adjacentNodes = new HashMap<>();
    }
    @Override
    public int getVal() { return this.val; }

    @Override
    public String getName() { return this.name; }

    @Override
    public void setVal(int v) { this.val = v; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public boolean wasVisited() { return this.visited; }

    @Override
    public void setVisited(boolean visit) { this.visited = visit; }

    public Map<GraphNode, Integer> getAdjacentNodes() { return this.adjacentNodes; }

    public boolean isNeighbour(GraphNode node) { return adjacentNodes.containsKey(node); }

    public void addNeighbour(GraphNode node, int weight){ adjacentNodes.put(node, weight); }

    public void addNeighbour(Map.Entry<GraphNode, Integer> nodeEntry){ adjacentNodes.put(nodeEntry.getKey(), nodeEntry.getValue()); }

}
