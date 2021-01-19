package Structures;

public class GraphMatrix {
    private int numNodes;
    private boolean directed;
    private boolean weighted;
    private int[][] matrix;
    private boolean[][] isSetMatrix;

    public GraphMatrix(int numOfNodes, boolean directed, boolean weighted){
        this.directed = directed;
        this.weighted = weighted;
        this.numNodes = numOfNodes;

        matrix = new int[numOfNodes][numOfNodes];
        isSetMatrix = new boolean[numNodes][numNodes];
    }

    public void addEdge(int source, int destination){

        int valueToAdd = 1;

        if (weighted){
            valueToAdd = 0;
        }

        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if(!directed){
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    public void addEdge(int source, int destination, int weight){

        int valueToAdd = weight;

        if (weighted){
            valueToAdd = 1;
        }

        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if(!directed){
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    public void printMatrix(){
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                // We only want to print the values of those positions that have been marked as set
                if (isSetMatrix[i][j])
                    System.out.format("%8s", String.valueOf(matrix[i][j]));
                else System.out.format("%8s", "/  ");
            }
            System.out.println();
        }
    }

    public void printEdges() {
        for (int i = 0; i < numNodes; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int j = 0; j < numNodes; j++) {
                if (isSetMatrix[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int source, int destination) {
        return isSetMatrix[source][destination];
    }

    public int getEdgeValue(int source, int destination) {
        if (!weighted || !isSetMatrix[source][destination])
            return -1;
        return matrix[source][destination];
    }

}
