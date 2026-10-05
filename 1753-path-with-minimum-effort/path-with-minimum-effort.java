class pair{
    int distance ;
    int row;
    int col;

    pair(int distance , int row , int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a , b)->a.distance-b.distance);
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];

        for(int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                dist[i][j]=(int)(1e9);
            }
        }

        dist[0][0] = 0;
        pq.offer(new pair(0 , 0 , 0));

        int[] drow ={-1, 0 ,1, 0};
        int [] dcol={0 , 1 ,0 ,-1};

        while(!pq.isEmpty()){
            pair node = pq.poll();
            int diff = node.distance;
            int i = node.row;
            int j = node.col;

            if(i==m-1 && j==n-1){
                return diff;
            }

            for(int it =0 ; it<4 ; it++){
                int nrow = i + drow[it];
                int ncol = j+ dcol[it];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int edgeEffort = Math.abs(heights[i][j]-heights[nrow][ncol]);
                    int ndiff = Math.max(diff , edgeEffort);
                    if(ndiff<dist[nrow][ncol]){
                        dist[nrow][ncol] = ndiff;
                        pq.offer(new pair(ndiff , nrow , ncol));
                    }
                }
            }
        }

        return 0 ;
    }
}