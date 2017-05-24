
package dataStructures;

public class BinaryMinHeap {

    Vertex[] A;
    int heapSize;
    
    public BinaryMinHeap(Vertex[] vertices, int totalVertices) {
        A = new Vertex[totalVertices+1];
        
        for(int i=1; i<=totalVertices; i++) {
            A[i] = vertices[i];
            A[i].positionInQueue = i;
        }
        
        heapSize = totalVertices;
        
        buildMinHeap();        
    }
    
    private int parent(int i) {
        return (int)(Math.floor(i/2));
    }
    
    private int left(int i) {
        return (2*i);
    }
    
    private int right(int i) {
        return (2*i)+1;
    }
    
    private void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest;
        
        if (l <= heapSize && A[l].key < A[i].key) {
            smallest = l;
        } else {
            smallest = i;
        }
        
        if (r <= heapSize && A[r].key < A[smallest].key) {
            smallest = r;
        } 
        
        if (smallest != i) {
            Vertex temp = A[i];
            
            A[i] = A[smallest];
            A[i].positionInQueue = i;
            
            A[smallest] = temp;
            A[smallest].positionInQueue = smallest;
            
            minHeapify(smallest);
        }
    }
    
    private void buildMinHeap() {
        for (int i=(int)(Math.floor(heapSize/2)); i>=1; i--) {
            minHeapify(i);
        }
    }
    
    public Vertex heapMinimum() {
        return A[1];
    }
    
    public Vertex heapExtractMin() {
        if (heapSize < 1) {
            System.out.println("heap underflow");
        }
        
        Vertex min = A[1];
        
        A[1] = A[heapSize];
        A[1].positionInQueue = 1;
        
        heapSize = heapSize - 1;
    
        minHeapify(1);
        
        return min;
    }
    
    public void heapDecreaseKey(int i, int key) {
        if (key > A[i].key) {
            System.out.println("New key is larger than current key");
        }
        
        A[i].key = key;
        
        while(i>1 && A[parent(i)].key > A[i].key) {
            Vertex temp = A[i];
            
            A[i] = A[parent(i)];
            A[i].positionInQueue = i;
            
            A[parent(i)] = temp;
            A[parent(i)].positionInQueue = parent(i);
                    
            i = parent(i);
        }
    }
    
    public boolean isEmpty() {
        return (heapSize < 1);
    }
}
