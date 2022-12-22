# Data-Structures-and-Algorithms

A colection of some data structures and algorithms their descriptions a implementation in Java programming language.

## Algorithms

### Dijkstras shortest path algorithm

Dijkstra's algorithm is an algorithm for finding the shortest path between two nodes in a graph. It is a generalization of the breadth-first search algorithm, and is commonly used to solve the single-source shortest path problem for a graph with non-negative edge weights, producing a shortest path tree.

Here is an overview of the steps involved in Dijkstra's algorithm:

1. Initialize a distance array and a predecessor array, with the distance from the source node to all other nodes set to infinity, and the predecessor of all nodes set to null.

2. Set the distance of the source node to 0, and add it to a priority queue (e.g. a min-heap).

3. While the priority queue is not empty:
    Remove the node with the smallest distance from the priority queue.
    For each of the node's neighbors:
        Calculate the tentative distance to the neighbor by adding the weight of the edge between the node and the neighbor to the node's distance.
        If the tentative distance is less than the current distance recorded in the distance array, update the distance and the predecessor for the neighbor.
4. Once the algorithm has completed, the distance and predecessor arrays will contain the shortest path from the source node to all other nodes in the graph.

Dijkstra's algorithm has a time complexity of O(E log V), where E is the number of edges and V is the number of vertices in the graph. This makes it more efficient than the breadth-first search algorithm, which has a time complexity of O(V + E). However, it is not suitable for graphs with negative edge weights, as it does not correctly handle negative weight cycles.
