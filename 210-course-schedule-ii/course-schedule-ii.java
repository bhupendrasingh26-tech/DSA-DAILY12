class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int V = numCourses;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];

            adj.get(src).add(dest);
        }

        // Calculate indegree
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

      
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

      
        int[] ans = new int[V];
        int index = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            ans[index++] = node;

            for (int it : adj.get(node)) {

                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

       
        if (index != V) {
            return new int[0];
        }

        return ans;
    }
}