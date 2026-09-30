class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        int count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        int m = prerequisites.length;
        for(int i = 0; i<V ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m ; i++){
            int dest = prerequisites[i][0];
    int src = prerequisites[i][1];
    adj.get(src).add(dest);
        }

        int[] inDegree = new int[V];
        for(int i =0; i<V; i++ ){
            for(int it : adj.get(i) ){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0; i<V ; i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }

       return count==V;
    }
}