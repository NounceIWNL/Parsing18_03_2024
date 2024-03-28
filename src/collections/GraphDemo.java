package collections;

public class GraphDemo {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        Graph.Node node1 = graph.new Node(1);
        Graph.Node node2 = graph.new Node(2);
        Graph.Node node3 = graph.new Node(3);
        Graph.Node node4 = graph.new Node(4);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node4);
        graph.traverse(node2);

    }
} 