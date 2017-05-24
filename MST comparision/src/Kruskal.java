
import Utils.EdgeSorter;
import dataStructures.Vertex;
import dataStructures.Edge;
import dataStructures.DisjointSet;
import java.util.ArrayList;

public class Kruskal {
    private Vertex[] vertices;
    private ArrayList<Edge> edges = new ArrayList();
    private int totalVertices;
    private int totalCost;
    
    public Kruskal(Vertex[] vertices, ArrayList edges, int totalVertices) {
        this.vertices = new Vertex[totalVertices+1];

        for(int i=1; i<=totalVertices; i++) {
            this.vertices[i] = vertices[i];
        }
        
        this.edges = edges;
        this.totalVertices = totalVertices;
    
        totalCost = 0;
    }
    
    public void computeMST() {
        ArrayList<Edge> A = new ArrayList();

        for(int i=1; i<=totalVertices; i++) {
            DisjointSet.makeSet(vertices[i]);
        }
        
        EdgeSorter.sortNonDecreasing(edges);
        
        for (Edge edge : edges) {
            if (DisjointSet.findSet(edge.u) != DisjointSet.findSet(edge.v)) {
                A.add(edge);
                totalCost += edge.weight;
                
                DisjointSet.union(edge.u, edge.v);
            }
        }
        
        System.out.println("Total cost in Kruskal: " + totalCost);
    }    
}
