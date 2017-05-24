package dataStructures;

public class Edge {
    
    public Vertex u;
    public Vertex v;
    public int weight;
    
    public Edge(Vertex v1, Vertex v2, int weight) {
        this.u = v1;
        this.v = v2;
        this.weight = weight;
    }
}
