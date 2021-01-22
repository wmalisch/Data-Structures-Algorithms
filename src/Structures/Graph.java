package Structures;

import java.util.HashSet;

/**
 * Most basic graph implementation. This graph requires links/edges to be managed at the node level, this is for simple algorithm questions.
 * Be careful because this graph will not maintain directed structure if there is a mistake
 */
public class Graph extends AbstractGraph{

    public Graph(boolean directed){
        nodes = new HashSet<>();
        this.directed = directed;
    }
}
