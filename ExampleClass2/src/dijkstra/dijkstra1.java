package dijkstra;
import java.util.*;
import java.io.*;
import java.lang.*;

 class InitialSetting
 {
     public static void main(String args[]) throws IOException
     {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
         int t = Integer.parseInt(read.readLine());
         while(t-->0)
         {
             String str[] = read.readLine().trim().split(" ");
             int V = Integer.parseInt(str[0]);
             int E = Integer.parseInt(str[1]);

             ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
             for(int i=0; i<V;i++)
             {
                 adj.add(new ArrayList<ArrayList<Integer>>());
             }

             int i = 0;
             while(i++<E)
             {
                 String S[] = read.readLine().trim().split(" ");
                 int u = Integer.parseInt(S[0]);
                 int v = Integer.parseInt(S[1]);
                 int w = Integer.parseInt(S[2]);
                 ArrayList<Integer> t1 = new ArrayList<Integer>();
                 ArrayList<Integer> t2 = new ArrayList<Integer>();
                 t1.add(v);
                 t1.add(w);
                 t2.add(u);
                 t2.add(w);
                 adj.get(u).add(t1);
                 adj.get(v).add(t2);
             }
             int S = Integer.parseInt(read.readLine());

             dijkstra1 algo = new dijkstra1();
             int [] ptr = algo.dijkstra(V,adj,S);

             for(i=0;i<V;i++)
             {
                 System.out.print(ptr[i]+" ");
             }
             System.out.println();
         }
     }

 }
 class dijkstra1
 {
    int minDistance( int dist[] , boolean sptSet[], int V)
    {
        int min = Integer.MAX_VALUE, min_index = 0;
        for(int v = 0; v < V; v++)
        {
            if(sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    //function to find the shortest distance of all vertices
    //From the source vertex S.
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        //creating Adjacency matrix from Adjacency list
        int [][]adj_mat = new int[V][V];
        for(int i = 0; i < V; i++)
        {
            for(int j = 0; j < adj.get(i).size(); j++)
            {
                adj_mat[i][adj.get(i).get(j).get(0)] = adj.get(i).get(j).get(1);
            }
        }
        //distance[] is output list.dist[i] will hold the shortest distance from source to i.
        int [] dist = new int [V];

        //sptSet[i] will true if vertex i is included in shortest path tree or shortest distance from src to i is finalized
        boolean [] sptSet = new boolean[V];

        //initializing all distances as INFINITE and stpSet[] as false.

        for(int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        //distance of sourve vertex from itsleft is always 0.
        dist[S] = 0;

        //iterating over all vertices.
        for(int count = 0; count < V-1; count++)
        {
            //picking the minumum distance vertex from the set of vertices not yet processed and marking the picked vertex as processed.
            int u = minDistance(dist,sptSet,V);
            sptSet[u] = true;

            //updating dist[] value adjacent vertices of the picked vertex.
            for(int v = 0; v < V; v++)
            {
                // Updating dist[V] only if it's not in the sptSet, there is an edge from u  to v, and total weight of path from source to
                // v through u is smaller than current value of dist[v].
                if(!sptSet[v] && adj_mat[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + adj_mat[u][v] <dist[v])
                {
                    dist[v] = dist[u] + adj_mat[u][v];
                }
            }
        }
        return dist;
    }
}
