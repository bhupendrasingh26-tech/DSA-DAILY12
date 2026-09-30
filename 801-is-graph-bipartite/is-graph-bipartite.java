class Solution {

    public boolean isBipartite(int[][] graph) {

        int V = graph.length;

        int[] colour = new int[V];
        Arrays.fill(colour, -1);

        for (int i = 0; i < V; i++) {

            if (colour[i] == -1) {

                if (!solve(i, graph, colour)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve(int start, int[][] graph, int[] colour) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        colour[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbour : graph[node]) {

                if (colour[neighbour] == -1) {

                    colour[neighbour] = 1 - colour[node];

                    q.add(neighbour);
                }

                else if (colour[neighbour] == colour[node]) {

                  
                    return false;
                }
            }
        }

        return true;
    }
}