class pair {
    int dist;
    int i;
    int j;

    pair(int dist, int i, int j) {
        this.dist = dist;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Start or destination is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dis = new int[n][n];

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(1, 0, 0));
        dis[0][0] = 1;

        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {

            pair node = q.poll();

            int d = node.dist;
            int rowi = node.i;
            int coli = node.j;

            if (rowi == n - 1 && coli == n - 1) {
                return d;
            }

            for (int it = 0; it < 8; it++) {

                int drow = rowi + row[it];
                int dcol = coli + col[it];

                if (drow >= 0 && drow < n &&
                    dcol >= 0 && dcol < n &&
                    grid[drow][dcol] == 0 &&
                    dis[drow][dcol] == 0) {

                    dis[drow][dcol] = d + 1;

                    q.add(new pair(d + 1, drow, dcol));
                }
            }
        }

        return -1;
    }
}