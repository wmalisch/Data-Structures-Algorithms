package Structures;
import java.awt.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class DijkstraNode implements GraphNode {
    private int n;
    private String name;
    private List<DijkstraNode> shortestPath;
    private int distance;
    private Map<DijkstraNode, Integer> adjNodes;

    public DijkstraNode(String name){
        this.name = name;
        shortestPath = new LinkedList<>();
        distance = Integer.MAX_VALUE;
        adjNodes = new HashMap<>();
    }

    public void addDestination(DijkstraNode node, int weight){
        adjNodes.put(node, weight);
    }

    @Override
    public int getVal() {
        return n;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setVal(int v) {
        this.n = v;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDistance(int dist){
        this.distance = dist;
    }

    public int getDistance(){
        return distance;
    }

    public Map<DijkstraNode, Integer> getAdjacentNodes(){
        return adjNodes;
    }

    public List<DijkstraNode> getShortestPath(){
        return shortestPath;
    }

    public void setShortestPath(LinkedList<DijkstraNode> path){
        this.shortestPath = path;
    }
}
