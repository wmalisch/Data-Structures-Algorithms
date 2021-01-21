import Structures.DijkstraNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class DijkstraGraph {
    private Set<DijkstraNode> nodes;

    public DijkstraGraph(){
        this.nodes = new HashSet<>();
    }

    public void addNode(DijkstraNode node){
        nodes.add(node);
    }

    private static DijkstraNode getLowestDistanceNode(Set<DijkstraNode> unsetNodes){
        DijkstraNode lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for(DijkstraNode node : unsetNodes){
            int dist = node.getDistance();
            if(dist < lowestDistance){
                lowestDistance = dist;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(DijkstraNode evaluationNode, int weight, DijkstraNode sourceNode){
        int sourceDist = sourceNode.getDistance();
        if(sourceDist + weight < evaluationNode.getDistance()){
            LinkedList<DijkstraNode> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static DijkstraGraph calculateShortestPathFromSource(DijkstraGraph graph, DijkstraNode src){
        // Set distance from src node to src node to 0
        src.setDistance(0);

        // Create set for nodes that have been checked and nodes that have not
        Set<DijkstraNode> settledNodes = new HashSet<>();
        Set<DijkstraNode> unsettledNodes = new HashSet<>();

        unsettledNodes.add(src);

        while(!unsettledNodes.isEmpty()){
            DijkstraNode currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for(Map.Entry<DijkstraNode, Integer> adjPair : currentNode.getAdjacentNodes().entrySet()){
                DijkstraNode adjNode = adjPair.getKey();
                int edgeWeight = adjPair.getValue();
                if(!settledNodes.contains(adjNode)){
                    calculateMinimumDistance(adjNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjNode);

                }
            }
            settledNodes.add(currentNode);
        }

        return graph;
    }

    public static void main(String[] args){
        DijkstraNode nodeA = new DijkstraNode("A");
        DijkstraNode nodeB = new DijkstraNode("B");
        DijkstraNode nodeC = new DijkstraNode("C");
        DijkstraNode nodeD = new DijkstraNode("D");
        DijkstraNode nodeE = new DijkstraNode("E");
        DijkstraNode nodeF = new DijkstraNode("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        DijkstraGraph graph = new DijkstraGraph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = graph.calculateShortestPathFromSource(graph, nodeA);
    }

}
