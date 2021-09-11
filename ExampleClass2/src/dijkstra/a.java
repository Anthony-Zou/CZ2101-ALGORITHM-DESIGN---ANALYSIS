package dijkstra;

import java.util.*;

public class a {
    public static void main(String[] args) {
        int V = 10;
        int EPercent = 200;
        int cases = 19;
        int runs = 100;
        int[][] test0 = new int[][]{{100, 300}, {200, 300}, {300, 300}, {400, 300}, {500, 300},
                {600, 300}, {700, 300}, {800, 300}, {900, 300}, {1000, 300},
                {2000, 300},{3000, 300},{4000, 300},{5000, 300},{6000, 300},
                {7000, 300},{8000, 300},{9000, 300},{10000, 300},};
        long time[] = MatrixCPUPerformance(test0, cases, runs);
//        System.out.println(MatrixCPUTime(V,EPercent));
        for(int i = 0; i < time.length; i++){
            System.out.println("V = " + test0[i][0] + ", time = " + time[i]);
        }
    }

    // CPU time for one Dijkstra function call in MS
    public static long MatrixCPUTime(int V, int EPercent){
        GraphMatrix graphMatrix = new GraphMatrix(V);
        for (int i = 0; i < V * EPercent / 100; i++){
            graphMatrix.addRandomEdge(V);
        }
        long start = System.nanoTime();
        Dijkstra(graphMatrix.adjMatrix, V, 0);
        long time = (System.nanoTime() - start) / 1000;
        return time;
    }

    // Average CPU time for a number of Dijkstra function calls in MS
    public static long[] MatrixCPUPerformance(int[][] test, int cases, int runs){
        int V;
        int EPercent;
        long[] result = new long[cases];
        long time = 0;
        for(int i = 0; i < cases; i++){
            for (int j = 0; j < runs; j++){
                time += MatrixCPUTime(test[i][0], test[i][1]);
            }
            result[i] = time / runs;
        }
        return result;
    }

    public static void Dijkstra(int[][] graph, int V, int source)  {
        int path_array[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            path_array[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        path_array[source] = 0;
        // now find shortest path for all vertices
        for (int count = 0; count < V; count++) {
            int u = minDistance(V, path_array, sptSet);
            sptSet[u] = true;
            for (int i = 0; i < V; i++)
                if (!sptSet[i] && graph[u][i] != 0 && path_array[u] != Integer.MAX_VALUE
                        && path_array[u] + graph[u][i] < path_array[i])
                    path_array[i] = path_array[u] + graph[u][i];
        }
        //printMinPath(V, path_array);
    }

    public static void printMinPath(int V, int path_array[])   {
        System.out.println("Vertex# \t Minimum Distance from Source");
        for (int i = 0; i < V; i++){
            if (path_array[i] == Integer.MAX_VALUE)
                System.out.println(i + " \t\t\t INFINITE" );
            else
                System.out.println(i + " \t\t\t " + path_array[i]);
        }
    }

    public static int minDistance(int V, int path_array[], Boolean sptSet[])   {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < V; i++)
            if (!sptSet[i] && path_array[i] <= min) {
                min = path_array[i];
                min_index = i;
            }
        return min_index;
    }
}

class GraphMatrix{
    int V;
    int adjMatrix[][];
    private static Random rd = new Random();

    public GraphMatrix(int v) {
        this.V = v;
        this.adjMatrix = new int[v][v];
    }

    // Add random edges
    public void addRandomEdge(int v) {
        RandomEdge edge = new RandomEdge(v);
        adjMatrix[edge.source][edge.destination] = edge.weight;
    }

    public void printGraphMatrix() {
        for (int i = 0; i < this.V; i++) {
            for (int j = 0; j < this.V; j++) {
                if (adjMatrix[i][j] != 0)
                    System.out.println("vertex " + i + " is connected to " +
                            j + " with weight " + adjMatrix[i][j]);
            }
        }
    }

}
