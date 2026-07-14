class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] e : edges){
            if(!union(e[0],e[1],parent,rank)){
                return e;
            }
        }

        return new int[0];
    }

    private int find(int[] parent, int n){
        int p = parent[n];
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean union(int u, int v, int[] parent, int[] rank){
        int p1 = find(parent,u);
        int p2 = find(parent,v);

        if(p1 == p2){
            return false;
        }
        
        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
}
