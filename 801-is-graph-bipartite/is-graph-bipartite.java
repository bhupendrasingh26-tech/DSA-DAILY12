class Solution {

    public boolean isBipartite(int[][] graph) {

        int V = graph.length;

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {

            if (color[i] == -1) {

                if (!dfs(i, graph, 0, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int[][] arr, int colour, int[] color) {

        color[node] = colour;

        for (int it : arr[node]) {

            if (color[it] == -1) {

                int nc = 1 - color[node];

                if (!dfs(it, arr, nc, color)) {
                    return false;
                }
            }

            else if (color[it] == color[node]) {
                return false;
            }
        }

        return true;
    }
}