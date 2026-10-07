class Pair {
    int reach;
    long distance;

    Pair(int reach, long distance) {
        this.reach = reach;
        this.distance = distance;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int t = road[2];

            adj.get(u).add(new Pair(v, t));
            adj.get(v).add(new Pair(u, t));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));

        int MOD = 1_000_000_007;

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair node = pq.poll();

            int curr = node.reach;
            long currDist = node.distance;

        
            if (currDist > dist[curr]) {
                continue;
            }

            for (Pair edge : adj.get(curr)) {

                int next = edge.reach;
                long newDist = currDist + edge.distance;

                
                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    ways[next] = ways[curr];

                    pq.add(new Pair(next, newDist));
                }

              
                else if (newDist == dist[next]) {

                    ways[next] =
                        (ways[next] + ways[curr]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}