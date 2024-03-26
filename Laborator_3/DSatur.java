import java.util.Arrays;

public class DSatur {
    private int[][] graph;
    private int[] saturationDegree;
    private int[] color;
    private boolean[] colored;
    private int numVertices;

    public DSatur(int[][] adjacencyMatrix) {
        this.graph = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
        this.saturationDegree = new int[numVertices];
        this.color = new int[numVertices];
        this.colored = new boolean[numVertices];
    }

    public void colorGraph() {
        Arrays.fill(color, -1); // Initialize to uncolored (-1)
        Arrays.fill(saturationDegree, 0);

        int maxDegreeVertex = getMaxDegreeVertex();
        color[maxDegreeVertex] = 0; // Color the vertex with maximum degree with color 0
        colored[maxDegreeVertex] = true;

        for (int i = 1; i < numVertices; i++) {
            int vertex = getNextVertex();
            colorVertex(vertex);
            colored[vertex] = true;
            updateSaturationDegree(vertex);
        }
    }

    private int getMaxDegreeVertex() {
        int maxDegree = -1;
        int maxDegreeVertex = -1;
        for (int i = 0; i < numVertices; i++) {
            int degree = 0;
            for (int j = 0; j < numVertices; j++) {
                if (graph[i][j] == 1) {
                    degree++;
                }
            }
            if (degree > maxDegree) {
                maxDegree = degree;
                maxDegreeVertex = i;
            }
        }
        return maxDegreeVertex;
    }

    private int getNextVertex() {
        int maxSatDegree = -1;
        int nextVertex = -1;
        for (int i = 0; i < numVertices; i++) {
            if (!colored[i] && saturationDegree[i] > maxSatDegree) {
                maxSatDegree = saturationDegree[i];
                nextVertex = i;
            }
        }
        return nextVertex;
    }

    private void updateSaturationDegree(int vertex) {
        for (int i = 0; i < numVertices; i++) {
            if (graph[vertex][i] == 1 && colored[i]) {
                saturationDegree[i]++;
            }
        }
    }

    private void colorVertex(int vertex) {
        boolean[] usedColors = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (graph[vertex][i] == 1 && color[i] != -1) {
                usedColors[color[i]] = true;
            }
        }
        for (int i = 0; i < numVertices; i++) {
            if (!usedColors[i]) {
                color[vertex] = i;
                break;
            }
        }
    }

    public void printColors() {
        System.out.println("Vertex\tColor");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + "\t\t" + color[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };

        DSatur dsatur = new DSatur(graph);
        dsatur.colorGraph();
        dsatur.printColors();
    }
}
