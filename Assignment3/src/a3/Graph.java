package a3;

import java.util.*;

public class Graph<T> implements GraphInterface<T>
{
    private HashMap<T, Boolean> markedVertices;
    private HashMap<T, ArrayList<T>> graphList;
    private int maxVertices;
    private int numVertices;
    private int numEdges;

    public Graph (int maxSize){

        markedVertices=new HashMap<T, Boolean>();
        graphList=new HashMap<T, ArrayList<T>>();
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
        return graphList.isEmpty();
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
        if(graphList.containsKey(vertex)){
            throw new VertexExistsException();
        }
        numVertices++;
        markedVertices.put(vertex,false);
        graphList.put(vertex, new ArrayList<T>());
    }

    /** Adds an edge with the specified weight from fromVertex to toVertex. **/
    @Override
    public void addEdge(T fromVertex, T toVertex) {
        if(fromVertex == toVertex){
            return;
        }
        (graphList.get(fromVertex)).add(toVertex);
        (graphList.get(toVertex)).add(fromVertex);
        numEdges++;
    }

    /** Returns a queue of the vertices that are adjacent from vertex. **/
    @Override
    public Queue<T> getToVertices(T vertex) {
        Queue<T> pie = new LinkedList<>(graphList.get(vertex));
        return pie;
    }

    /** Sets marks for all vertices to false. **/
    @Override
    public void clearMarks() {

        for (T key : markedVertices.keySet())
            markedVertices.put(key, false);
    }

    /** Sets mark for vertex to true. **/
    @Override
    public void markVertex(T vertex) {
        markedVertices.put(vertex, true);
    }

    /** Returns true if vertex is marked; otherwise, returns false. **/
    @Override
    public boolean isMarked(T vertex) {
        return markedVertices.get(vertex);
    }
}
