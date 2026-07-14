class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int[] e : edges){
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }


        Set<Integer> visit = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,-1});
        visit.add(0);

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int node = cell[0];
            int parent = cell[1];

            for(int nei : map.getOrDefault(node, Collections.emptyList())){
                if(nei == parent){
                    continue;
                }
                if(visit.contains(nei)){
                    return false;
                }
                visit.add(nei);
                q.offer(new int[]{nei,node});
            }
        }

        return visit.size() == n;
    }
}
