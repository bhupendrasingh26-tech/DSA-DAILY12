class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
         q.add(Arrays.asList(0));
         int dest = graph.length-1;

         while(!q.isEmpty()){
            List<Integer> path = q.poll();
            int current = path.get(path.size()-1);
            if(current==dest){
                ans.add(path);
            }
            
            for(int it : graph[current]){
                List<Integer> newPath = new ArrayList(path);
                newPath.add(it);
                q.add(newPath);
            }
         }

         return ans;
    }
}