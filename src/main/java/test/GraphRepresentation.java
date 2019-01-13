package test;

import java.util.LinkedList;

public interface GraphRepresentation {
    void addEdge(int v1, int v2, int dist) throws GraphException;

    int distance(int v1, int v2) throws GraphException;

    LinkedList getNeighbors(int v) throws GraphException;
}
