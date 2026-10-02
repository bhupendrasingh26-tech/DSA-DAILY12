class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pVis = new int[V];
        int[] check = new int[V];

        for(int i = 0; i<V ; i++){
            if(vis[i]==0){
              check(i , graph , vis ,pVis, check);  
            }
        }

        List<Integer> ans  = new ArrayList<>();
        for(int i=0; i<V ; i++){
            if(check[i]==1){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean check(int node, int[][] arr ,int[] vis , int[] pVis , int[]check){
        vis[node] = 1;
        pVis[node] = 1;
        check[node] = 0;

        for(int it : arr[node]){
            if(vis[it]==0){
                if(check(it , arr , vis , pVis , check)== true){
                    return true;
                }
            } else if(pVis[it]==1){
                return true;
            }
        }

        pVis[node] = 0;
        check[node] = 1;
        return false;

    }
}