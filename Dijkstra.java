import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Edge {
  int to;
  int weight;

  Edge(int to, int weight) {
    this.to = to;
    this.weight = weight;
  }
}

class Node implements Comparable<Node> {
  int id;
  int distance;

  Node(int id, int distance) {
    this.id = id;
    this.distance = distance;
  }

  @Override
  public int compareTo(Node other) {
    return Integer.compare(distance, other.distance);
  }
}

public class Dijkstra {
  public static Map<Integer, Integer> shortestPath(Map<Integer, List<Edge>> graph, int source) {
    // distances[i] is the distance from the source node to node i
    int[] distances = new int[graph.size()];
    // predecessors[i] is the predecessor of node i on the shortest path from the source node
    int[] predecessors = new int[graph.size()];
    // visited[i] is true if node i has been visited, false otherwise
    boolean[] visited = new boolean[graph.size()];

    // Initialize distances and predecessors
    for (int i = 0; i < distances.length; i++) {
      distances[i] = Integer.MAX_VALUE;
      predecessors[i] = -1;
    }
    distances[source] = 0;

    // Use a priority queue to efficiently find the node with the smallest distance
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.add(new Node(source, 0));

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int nodeId = node.id;
      if (!visited[nodeId]) {
        visited[nodeId] = true;
        for (Edge edge : graph.get(nodeId)) {
          int neighborId = edge.to;
          int weight = edge.weight;
          if (distances[neighborId] > distances[nodeId] + weight) {
            distances[neighborId] = distances[nodeId] + weight;
            predecessors[neighborId] = nodeId;
            queue.add(new Node(neighborId, distances[neighborId]));
          }
        }
      }
    }

    // Construct the shortest path as a map of node IDs to distances
    Map<Integer, Integer> path = new HashMap<>();
    for (int i = 0; i < distances.length; i++) {
      path.put(i, distances[i]);
    }

    return path;
  }

  public static void main(String[] args) {
    // Create a graph with 5 nodes, where node 0 is connected to nodes 1 and 2 with weights 10 and 5, respectively,
    // and node 1 is connected to node 3 with a weight of 1.
    Map<Integer, List<Edge>> graph = new HashMap<>();
    graph.put(0, List.of(new Edge(1, 10), new Edge(2, 5)));
    graph.put(1, List.of(new Edge(3, 1)));
    graph.put(2, new ArrayList<>());
    graph.put(3, new ArrayList<>());
    graph.put(4, new ArrayList<>());

    // Find the shortest path from node 0 to all other nodes
    Map<Integer, Integer> path = shortestPath(graph, 0);
    for (Map.Entry<Integer, Integer> entry : path.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
