
import dataStructures.BinaryMinHeap;
import dataStructures.Edge;
import dataStructures.Vertex;
import java.util.ArrayList;

public class Prim_adj_mat {
    private Vertex[] vertices;
    private int rootIndex;
    private byte w[][];
    private int totalVertices;
    private int totalCost;
    private final int infinity = 1000000;
        
    public Prim_adj_mat(Vertex[] vertices, ArrayList<Edge> edges, int rootIndex, int totalVertices) {
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
    
    
    private Vertex getMin() {
        Vertex min = null;
        int minKey = infinity;
        
        for(int i=1; i<=totalVertices; i++) {
            if ((vertices[i].key < minKey) && vertices[i].isRemovedFromQueue==false) {
                minKey = vertices[i].key;
                min = vertices[i];
            }
        }
        
        return min;
    }
    
    public void computeMST() {
        
        for(int i=1; i<=totalVertices; i++) {
            vertices[i].key = infinity;
            vertices[i].parent = null;
        }
        
        vertices[rootIndex].key = 0;
        
        //BinaryMinHeap queue = new BinaryMinHeap(vertices, totalVertices);
        
        while (true) {
            Vertex u = getMin();
            
            if (u==null) {
                break;
            }
            
            u.setIsRemovedFromQueue(true);

            for (int i = 1; i <= totalVertices; i++) {
                if (w[u.id][i] != 0) {
                    if (!vertices[i].isRemovedFromQueue() && (w[u.id][i] < vertices[i].key)) {
                        vertices[i].parent = u;
                        vertices[i].key = w[u.id][i];
                    }
                }
            }
            
            totalCost += u.key;
        }
        
        System.out.println("Total cost in Prim : " + totalCost);
    }    
}
