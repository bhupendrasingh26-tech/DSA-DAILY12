class pair{
    int reach;
    int distance;
    int stops;

    pair(int reach , int distance , int stops){
        this.reach = reach;
        this.distance = distance;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> adj =  new ArrayList<>();

        for(int i=0; i<n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<flights.length ; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            adj.get(u).add(new pair(v , wt , 0));
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.offer(new pair(src , 0 , 0));
        int[][] dist = new int[n][k+2];
        for(int i = 0; i < n; i++) {
    Arrays.fill(dist[i], (int)1e9);
}
        dist[src][0] =0;

        while(!pq.isEmpty()){
            pair node = pq.poll();
            int desti = node.reach;
            int curr = node.distance;
            int stops = node.stops;
            if(desti==dst){
                return curr;
            }
            if(stops>k){
                continue;
            }

            for(pair it : adj.get(desti)){
               int ndis = it.distance + curr;
               if(ndis<dist[it.reach][stops+1] && stops<=k){
                dist[it.reach][stops+1] = ndis;

                pq.offer(new pair(it.reach ,ndis ,stops+1));
               }
            }

           
        }

       return -1;                 

    }
}