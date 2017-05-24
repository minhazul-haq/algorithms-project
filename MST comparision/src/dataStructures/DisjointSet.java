package dataStructures;

public class DisjointSet {

	public static void makeSet(Vertex x) {
		x.p = x;
		x.rank = 0;
	}
	
	public static void union(Vertex x, Vertex y) {
		link(findSet(x), findSet(y));	
	}
	
	public static void link(Vertex x, Vertex y) {
		if (x.rank > y.rank) {
			y.p = x;	
		}
		else {
			x.p = y;	
		}
		
		if (x.rank == y.rank) {
			y.rank = y.rank + 1;	
		}
	}
	
	public static Vertex findSet(Vertex x) {
		if (x != x.p) {
			x.p = findSet(x.p);	
		}
		
		return x.p;
	}
}
