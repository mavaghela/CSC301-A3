package a3;

import java.util.*;

public class Graph<T> implements GraphInterface<T>
{
    private HashMap<T, Boolean> markedVertices;
    private HashMap<T, ArrayList<T>> graphList;
    private int maxVertices;
    private int numVertices;
    private String message;

    public Graph (int maxSize)
    {
        markedVertices = new HashMap<T, Boolean>();
        graphList = new HashMap<T, ArrayList<T>>();
        maxVertices = maxSize;
        numVertices = 0;
    }

    /** Returns a list of connected components of the graph
     For each vertex that does not belong to the connected components
     already on the list, call DFSVisit to obtain a set of vertices connected to the current vertex
     Add the set to the list **/
    public ArrayList<Set<T>> connectedComponents()
    {
        ArrayList<Set<T>> components = new ArrayList<Set<T>>();
        for (T key : markedVertices.keySet()){
            if (!isMarked(key)) {
                Set<T> tempSet = DFSVisit(key);
                components.add(tempSet);
            }
        }
        return components;
    }

    /** Returns true if this graph is empty; otherwise, returns false. **/
    @Override
    public boolean isEmpty()
    {
        return graphList.isEmpty();
    }

    /** Returns true if this graph is full; otherwise, returns false. **/
    @Override
    public boolean isFull()
    {
        return numVertices >= maxVertices;
    }

    /** Preconditions:  Vertex is not already in this graph.
                        Vertex is not null.
     Throws GraphIsFullException if the graph is full
     Otherwise adds vertex to this graph. **/

    @Override
    public void addVertex(T vertex) throws GraphIsFullException, VertexExistsException
    {
        if (isFull()){
            message = String.format("The graph is full, it already has %d vertices.", maxVertices);
            throw new GraphIsFullException(message);
        }
        if(graphList.containsKey(vertex)){
            message = "The vertex already exists.";
            throw new VertexExistsException(message);
        }
        numVertices++;
        markedVertices.put(vertex,false);
        graphList.put(vertex, new ArrayList<T>());
    }

    /** Adds an edge with the specified weight from fromVertex to toVertex. **/
    @Override
    public void addEdge(T fromVertex, T toVertex)
    {
        if(fromVertex == toVertex){
            return;
        }
        if((graphList.get(fromVertex)).contains(toVertex) || graphList.get(toVertex).contains(fromVertex)){
            return;
        }
        (graphList.get(fromVertex)).add(toVertex);
        (graphList.get(toVertex)).add(fromVertex);
    }

    /** Returns a queue of the vertices that are adjacent from vertex. **/
    @Override
    public Queue<T> getToVertices(T vertex)
    {
        Queue<T> pie = new LinkedList<>(graphList.get(vertex));
        return pie;
    }

    /** Sets marks for all vertices to false. **/
    @Override
    public void clearMarks()
    {
        for (T key : markedVertices.keySet())
            markedVertices.put(key, false);
    }

    /** Sets mark for vertex to true. **/
    @Override
    public void markVertex(T vertex)
    {
        markedVertices.put(vertex, true);
    }

    /** Returns true if vertex is marked; otherwise, returns false. **/
    @Override
    public boolean isMarked(T vertex)
    {
        return markedVertices.get(vertex);
    }

    public Set<T> DFSVisit(T startVertex)
    {
        Set<T> dfs = new HashSet<T>();
        Stack<T> stack = new Stack<T>();
        stack.add(startVertex);
        markVertex(startVertex);

        while (!stack.isEmpty()) {
            T element = stack.pop();
            dfs.add(element);
            Queue<T> neighbours = getToVertices(element);

            while(!neighbours.isEmpty()){
                T neighbour = neighbours.remove();
                if(!isMarked(neighbour)) {
                    stack.add(neighbour);
                    markVertex(neighbour);
                }
            }
        }
        return dfs;
    }
}
