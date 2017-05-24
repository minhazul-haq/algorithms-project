package Utils;

import dataStructures.Edge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EdgeSorter {

    public static void sortNonDecreasing(ArrayList<Edge> edges) {
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return (e1.weight - e2.weight);
            }
        });
    }
}
