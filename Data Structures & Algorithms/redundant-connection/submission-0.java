class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);

            HashSet<Integer> visit = new HashSet<>();
            if(dfs(e[0],-1,adj,visit)){
                return e;
            }
        }

        return new int[0];
    }

    private boolean dfs(int u, int par, List<List<Integer>> adj, HashSet<Integer> visit){
        if(visit.contains(u)){
            return true;
        }

        visit.add(u);
        for(int nei : adj.get(u)){
            if(nei == par){
                continue;
            }
            if(dfs(nei,u,adj,visit)){
                return true;
            }
        }

        return false;
    }
}
