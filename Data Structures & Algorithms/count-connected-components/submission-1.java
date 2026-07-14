class Solution {
    int count = 0;
    HashMap<Integer,List<Integer>> adj = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        for(int[] e : edges){
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        int res = 0;
        HashSet<Integer> visit = new HashSet<>();

        for(int i=0; i<n; i++){
            if(!visit.contains(i)){
                bfs(i,visit);
                res++;
            }
        }

        return res;
    }

    private void bfs(int i, Set<Integer> visit){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit.add(i);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.getOrDefault(node, Collections.emptyList())){
                if(!visit.contains(nei)){
                    q.offer(nei);
                    visit.add(nei);
                }
            }
        }
    }
}
