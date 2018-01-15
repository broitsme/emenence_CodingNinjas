package Graphs;

import java.util.*;

public class Graph<E> {
    int nodes;
    private HashMap<E, List> adjMap = new HashMap<E, List>();
    public HashMap<E, Integer> getEdges(E vertex){
        return adjMap.get(vertex).list;
    }
    public boolean contains(E vertex){
        if(adjMap.containsKey(vertex)){
            return true;
        }
        else {
            return false;
        }
    }
    Graph() {
        nodes = 10;
    }

    Graph(int nodes) {
        this.nodes = nodes;
    }

    void addVertex(E vertex) {
        adjMap.put(vertex, new List());
    }

    void addEdge(E src, E dest, int weight) {

        adjMap.get(src).list.put(dest, weight);
        adjMap.get(dest).list.put(src, weight);
    }

    void addEdge(E src, E dest) {
        adjMap.get(src).list.put(dest, 0);
        adjMap.get(dest).list.put(src, 0);
    }

    void printGraph() {
        Iterator iterator = adjMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<E, List> currentVertex = (Map.Entry<E, List>) iterator.next();
            System.out.print(currentVertex.getKey() + " :");
            printlist(currentVertex.getValue());
        }
    }

    private void printlist(List list) {
        Iterator iterator = list.list.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<E, Integer> currentVertex = (Map.Entry<E, Integer>) iterator.next();
            System.out.print("(" + currentVertex.getKey() + ", " + currentVertex.getValue() + ") ");
        }
        System.out.println();
    }

    class List {
        HashMap<E, Integer> list = new HashMap<>();
    }
}
