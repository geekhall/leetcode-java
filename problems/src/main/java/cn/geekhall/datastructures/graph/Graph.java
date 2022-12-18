package cn.geekhall.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Graph.java
 *
 * @author yiny
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;
    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
