package Graphs;

public class test {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(1, 2, 10);
        g.addEdge(3, 1, 20);
        g.printGraph();
        functions.dfs(g, 3);
    }
}
