
import Utils.GraphReader;

public class MSTComparision {

    public static void main(String args[]) {
        String graphType = "sparse";
        int totalVertices = 500;
        
        GraphReader.readGraph("data/" + graphType + "_" + Integer.toString(totalVertices) + ".txt", totalVertices);
        long start, time_for_kruskal, time_for_prim_adj_list, time_for_prim_adj_mat;

        Prim_adj_list prim_adj_list = new Prim_adj_list(GraphReader.vertices, GraphReader.edges, 1, totalVertices);
        start = System.nanoTime();
        prim_adj_list.computeMST();
        time_for_prim_adj_list = System.nanoTime() - start;
/*      
        Prim_adj_mat prim_adj_mat = new Prim_adj_mat(GraphReader.vertices, GraphReader.edges, 1, totalVertices);
        start = System.nanoTime();
        prim_adj_mat.computeMST();
        time_for_prim_adj_mat = System.nanoTime() - start;
*/
        Kruskal kruskal = new Kruskal(GraphReader.vertices, GraphReader.edges, totalVertices);
        start = System.nanoTime();
        kruskal.computeMST();
        time_for_kruskal = System.nanoTime() - start;

        System.out.println("Elapsed time in Kruskal: " + time_for_kruskal/(1000*1000));
        System.out.println("Elapsed time in Prim_adj_list: " + time_for_prim_adj_list/(1000*1000));
        //System.out.println("Elapsed time in Prim_adj_mat: " + time_for_prim_adj_mat/(1000*1000));
    }
}
