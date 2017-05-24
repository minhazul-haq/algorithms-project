package Utils;

import dataStructures.Edge;
import dataStructures.Vertex;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphReader {
    
    public static Vertex[] vertices;
    public static ArrayList<Edge> edges = new ArrayList();
    
    public static void readGraph(String fileName, int totalVertices) {
        try {
            vertices = new Vertex[totalVertices+1];
            
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] tokens = strLine.split(" ");

                int v1_id = Integer.parseInt(tokens[0]);
                int v2_id = Integer.parseInt(tokens[1]);
                int weight = Integer.parseInt(tokens[2]);
                
                if (vertices[v1_id] == null) {
                    vertices[v1_id] = new Vertex(v1_id);
                }
                
                if (vertices[v2_id] == null) {
                    vertices[v2_id] = new Vertex(v2_id);
                }

                Edge edge = new Edge(vertices[v1_id], vertices[v2_id], weight);
                edges.add(edge);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
