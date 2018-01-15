package Graphs;

import java.util.*;

public class functions {

    static void dfs(Graph<Integer> graph, int vertex) {
        HashSet<Integer> visited = new HashSet<>();
        if (graph.contains(vertex)) {
            dfsHelp(vertex, graph, visited);
        } else {
            System.out.println("No such vertex in the graph");
        }
    }

    static void dfsHelp(int vertex, Graph<Integer> graph, HashSet<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        HashMap<Integer, Integer> connectedEdges = graph.getEdges(vertex);
        Iterator iterator = connectedEdges.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> current = (Map.Entry) iterator.next();
            if (!visited.contains(current.getKey())) {
                dfsHelp(current.getKey(), graph, visited);
            }
        }
    }
}
