package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class DirectedWeightedGraphImpl implements DirectedWeightedGraph {
    private HashMap<Integer, NodeData> node;
    private HashMap<Integer, HashMap<Integer, EdgeData>> edge;
    private int c = 0;

    public DirectedWeightedGraphImpl() {
        this.node = new HashMap<Integer, NodeData>();
        this.edge = new HashMap<Integer, HashMap<Integer, EdgeData>>();
    }

    public DirectedWeightedGraphImpl(HashMap<Integer, NodeData> node, HashMap<Integer, HashMap<Integer, EdgeData>> edge) {
        this.node = node;
        this.edge = edge;
    }

    @Override
    public NodeData getNode(int key) {
        return node.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return edge.get(src).get(dest);
    }

    @Override
    public void addNode(NodeData n) {
        node.put(n.getKey(), n);
        edge.put(n.getKey(), new HashMap<Integer, EdgeData>());
        c++;
    }

    @Override
    public void connect(int src, int dest, double w) {
        EdgeData e = new EdgeDataImpl(src, dest, w, 0, "hi");
        edge.get(src).put(dest, e);
        c++;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        Iterator<NodeData> iter = new Iterator<NodeData>() {
            final int s = c;
            Iterator<NodeData> iterator = node.values().iterator();

            @Override
            public boolean hasNext() {
                if (s != c)
                    throw new RuntimeException("RuntimeException");
                return iterator.hasNext();
            }

            @Override
            public NodeData next() {
                if (s != c)
                    throw new RuntimeException("RuntimeException");
                return iterator.next();
            }
        };
        return iter;
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        ArrayList<EdgeData> arr = new ArrayList<EdgeData>();
        for (int i : edge.keySet()) {
            for (int j : edge.get(i).keySet()) {
                arr.add(edge.get(i).get(j));
            }
        }
        Iterator<EdgeData> iter = new Iterator<EdgeData>() {
            final int s = c;
            Iterator<EdgeData> iterator = arr.iterator();

            @Override
            public boolean hasNext() {
                if (s != c)
                    throw new RuntimeException("RuntimeException");
                return iterator.hasNext();
            }

            @Override
            public EdgeData next() {
                if (s != c)
                    throw new RuntimeException("RuntimeException");
                return iterator.next();
            }
        };
        return iter;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return edge.get(node_id).values().iterator();
    }

    @Override
    public NodeData removeNode(int key) {
        c += edge.get(key).size();
        edge.remove(key);
        for (int i : edge.keySet()) {
            if (edge.get(i).remove(key) != null)
                c++;
        }
        c++;
        return node.remove(key);
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        c++;
        return edge.get(src).remove(dest);
    }

    @Override
    public int nodeSize() {
        return node.size();
    }

    @Override
    public int edgeSize() {
        int sum = 0;
        for (int i : edge.keySet()) {
            sum += edge.get(i).size();
        }
        return sum;
    }

    @Override
    public int getMC() {
        return c;
    }

    @Override
    public String toString() {
        return "DirectedWeightedGraphImpl{" +
                "node=" + "\n" + node +
                ", edge=" + edge +
                '}';
    }
}
