import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    private final Map<String, String> attributes;
    private final Collection<Node> nodes;
    private final Collection<Edge> edges;

    public Graph() {
        this(new HashMap<>());
    }

    public Graph(Map<String, String> attributes) {
        this(attributes, new ArrayList<>(), new ArrayList<>());
    }

    // Added this constructor, so I'm able to create a new Graph at every change
    public Graph(Map<String, String> attributes, Collection<Node> nodes, Collection<Edge> edges) {
        this.attributes = new HashMap<>(attributes);
        this.edges = new ArrayList<>(edges);
        this.nodes = new ArrayList<>(nodes);
    }

    public Collection<Node> getNodes() {
        return this.nodes;
    }

    public Collection<Edge> getEdges() {
        return this.edges;
    }

    public Graph node(String name) {
        var newNodes = new ArrayList<>(this.getNodes());
        newNodes.add(new Node(name));
        return new Graph(this.attributes, newNodes, this.edges);
    }

    public Graph node(String name, Map<String, String> attributes) {
        var newNodes = new ArrayList<>(this.nodes);
        newNodes.add(new Node(name, attributes));
        return new Graph(this.attributes, newNodes, this.edges);
    }

    public Graph edge(String start, String end) {
        var newEdges = new ArrayList<>(this.edges);
        newEdges.add(new Edge(start, end));
        return new Graph(this.attributes, this.nodes, newEdges);
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        var newEdges = new ArrayList<>(this.edges);
        newEdges.add(new Edge(start, end, attributes));
        return new Graph(this.attributes, this.nodes, newEdges);
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }
}
