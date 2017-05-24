
import dataStructures.BinaryMinHeap;
import dataStructures.Edge;
import dataStructures.Vertex;
import java.util.ArrayList;

public class Prim_adj_list {
    private Vertex[] vertices;
    private int rootIndex;
    private byte w[][];
    private int totalVertices;
    private int totalCost;
    private final int infinity = 1000000;
        
    public Prim_adj_list(Vertex[] vertices, ArrayList<Edge> edges, int rootIndex, int totalVertices) {
        this.vertices = new Vertex[totalVertices+1];
        w = new byte[totalVertices+1][totalVertices+1];
        
        for(int i=1; i<=totalVertices; i++) {
            this.vertices[i] = vertices[i];
        }
        
        for (Edge e : edges) {
            int u_id = e.u.id;
            int v_id = e.v.id;
            
            vertices[u_id].adjList.add(vertices[v_id]);
            w[u_id][v_id] = (byte)(e.weight);    
        }
        
        this.rootIndex = rootIndex;
        this.totalVertices = totalVertices;
        totalCost = 0;
    }
    
    public void computeMST() {
        
        for(int i=1; i<=totalVertices; i++) {
            vertices[i].key = infinity;
            vertices[i].parent = null;
        }
        
        vertices[rootIndex].key = 0;
        
        BinaryMinHeap queue = new BinaryMinHeap(vertices, totalVertices);
        
        while (!queue.isEmpty()) {
            Vertex u = queue.heapExtractMin();
            u.setIsRemovedFromQueue(true);

            for (Vertex v : u.adjList) {
                if (!v.isRemovedFromQueue() && (w[u.id][v.id] < v.key)) {
                    v.parent = u;
                    v.key = w[u.id][v.id];
                    
                    queue.heapDecreaseKey(v.positionInQueue, v.key);
                }
            }
            
            totalCost += u.key;
        }
        
        System.out.println("Total cost in Prim : " + totalCost);
    }    
}
