package a3;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;

public class Graph<T> implements GraphInterface<T>
{
    public Graph (int vertices){

    }

    public ArrayList<Set<String>> connectedComponents(){

        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void addVertex(T vertex) throws GraphIsFullException, VertexExistsException {

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
