package dijkstra;
import java.util.*;
class RandomEdge {
    int V;
    int source;
    int destination;
    int weight;
    private static Random rd = new Random();

    public RandomEdge(int v) {
        V = v;
        do{
            source = rd.nextInt(v);
            destination = rd.nextInt(v);
        }while(source == destination);  // add an effective edge buy ensuring source != destination
        weight = rd.nextInt(10) + 1;  // add an effective edge buy ensuring weight > 0
    }
}