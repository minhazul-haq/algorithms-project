package dataStructures;

import java.util.ArrayList;

public class Vertex {
	
    public int id;
    
    //properties for kruskal
    public Vertex p;
    public int rank;	
    
    //properties for prim
    public int key;
    public Vertex parent;
    public ArrayList<Vertex> adjList = new ArrayList();
    public boolean isRemovedFromQueue;
    
    //properties for priority queue
    public int positionInQueue;
	
    public Vertex(int id) {
    	this.id = id;   	    	    	
    }
    
    public void setIsRemovedFromQueue(boolean isTaken) {
        this.isRemovedFromQueue = isTaken;
    }
    
    public boolean isRemovedFromQueue() {
        return isRemovedFromQueue;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if (object != null && object instanceof Vertex)
        {
            int vertexId = ((Vertex)object).id;
            return this.id == vertexId;
        }

        return false;
    }
}
