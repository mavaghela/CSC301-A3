package a3;

import java.util.*;

public class Graph<T> implements GraphInterface<T>
{
    private HashMap<T, Integer> vertices;
    private HashMap<Integer, ArrayList<T>> adjacencyList;
    private int maxVertices;
    private int numVertices;
    private int numEdges;

    public Graph (int maxSize){

        vertices=new HashMap<T, Integer>();
        adjacencyList=new HashMap<Integer, ArrayList<T>>();
        maxVertices = maxSize;
        numVertices = 0;
        numEdges = 0;
    }

    public ArrayList<Set<T>> connectedComponents(){

        return null;
    }

    /** Returns true if this graph is empty; otherwise, returns false. **/
    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    /** Returns true if this graph is full; otherwise, returns false. **/
    @Override
    public boolean isFull() {
        return numVertices >= maxVertices;
    }

    /** Preconditions:  Vertex is not already in this graph.
                        Vertex is not null.
     Throws GraphIsFullException if the graph is full
     Otherwise adds vertex to this graph. **/

    @Override
    public void addVertex(T vertex) throws GraphIsFullException, VertexExistsException {
        if (isFull()){
            throw new GraphIsFullException();
        }
        if(vertices.containsKey(vertex)){
            throw new VertexExistsException();
        }
        numVertices++;
        vertices.put(vertex,numVertices);
        adjacencyList.put(numVertices, new ArrayList<T>());
    }

    /** Adds an edge with the specified weight from fromVertex to toVertex. **/
    @Override
    public void addEdge(T fromVertex, T toVertex) {
        if(fromVertex == toVertex){
            return;
        }
        int fromKey = vertices.get(fromVertex);
        int toKey = vertices.get(toVertex);
        (adjacencyList.get(fromKey)).add(toVertex);
        (adjacencyList.get(toKey)).add(fromVertex);
        numEdges++;
    }

    /** Returns a queue of the vertices that are adjacent from vertex. **/
    @Override
    public Queue<T> getToVertices(T vertex) {
        int key = vertices.get(vertex);
        Queue<T> pie = new LinkedList<>(adjacencyList.get(key));
        return pie;
    }

    /** Sets marks for all vertices to false. **/
    @Override
    public void clearMarks() {

    }

    /** Sets mark for vertex to true. **/
    @Override
    public void markVertex(T vertex) {

    }

    /** Returns true if vertex is marked; otherwise, returns false. **/
    @Override
    public boolean isMarked(T vertex) {
        return false;
    }
}
