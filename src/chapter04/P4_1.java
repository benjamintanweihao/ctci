package chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

class P4_1 {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 6);

        Stack<Integer> path = graph.findPath(1, 5);
        System.out.println(Arrays.toString(path.toArray()));
    }

    private static class Graph {
        ArrayList<ArrayList<Integer>> adj;
        boolean [] marked ;
        int [] edgeTo ;


        Graph(int n) {
            adj = new ArrayList<>(n);
            marked = new boolean[n+1];
            edgeTo = new int[n+1];

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u-1).add(v-1);
        }

        Stack<Integer> findPath(int src, int dest) {
            // perform a BFS starting with s.
            Queue<Integer> queue = new LinkedBlockingDeque<>();
            queue.add(src);

            while (!queue.isEmpty()) {
                int v = queue.remove();
                for (Integer vv : adj.get(v-1)) {
                    if (!marked[vv+1]) {
                        queue.add(vv);
                        marked[vv+1] = true;
                        edgeTo[vv+1] = v;
                    }
                }
            }

            Stack<Integer> path = new Stack<>();
            for (int x = dest; x != src; x = edgeTo[x]) {
                path.push(x);
            }
            path.push(src);

            return path;
        }
    }
}
