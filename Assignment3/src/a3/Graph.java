package a3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;

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
    }

    public ArrayList<Set<String>> connectedComponents(){

        return null;
    }

    // Returns true if this graph is empty; otherwise, returns false.
    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    // Returns true if this graph is full; otherwise, returns false.
    @Override
    public boolean isFull() {
        return numVertices == maxVertices;
    }

    @Override
    public void addVertex(T vertex) throws GraphIsFullException, VertexExistsException {
        numVertices++;
    }

    @Override
    public void addEdge(T fromVertex, T toVertex) {

    }

    @Override
    public Queue<T> getToVertices(T vertex) {
        return null;
    }

    @Override
    public void clearMarks() {

    }

    @Override
    public void markVertex(T vertex) {

    }

    @Override
    public boolean isMarked(T vertex) {
        return false;
    }
}
