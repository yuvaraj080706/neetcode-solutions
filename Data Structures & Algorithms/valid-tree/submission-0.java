class Solution {
    HashSet<Integer> visit = new HashSet<>();
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {

        for(int[] e : edges){
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        return dfs(0,-1);
    }

    private boolean dfs(int i, int parent){
        if(visit.contains(i)){
            return false;
        }

        visit.add(i);
        for(int nei : map.get(i)){
            if(nei == parent){
                continue;
            }

            if(!dfs(nei,i)){
                return false;
            }
        }
        visit.remove(i);
        return true;
    }
}
