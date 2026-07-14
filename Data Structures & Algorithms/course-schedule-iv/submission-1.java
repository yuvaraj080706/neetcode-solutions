class Solution {
    HashMap<Integer,List<Integer>> adj = new HashMap<>();
    HashMap<Integer, Set<Integer>> premap = new HashMap<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        for(int[] pre : prerequisites){
            adj.computeIfAbsent(pre[0],k -> new ArrayList<>()).add(pre[1]);
        }

        for(int i=0; i<numCourses; i++){
            dfs(i);
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries){
            if(premap.get(q[0]).contains(q[1])){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }

        return res;
    }


    private Set<Integer> dfs(int i){
        if(premap.containsKey(i)){
            return premap.get(i);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int nei : adj.getOrDefault(i, Collections.emptyList())){
            set.addAll(dfs(nei));
        }
        set.add(i);
        premap.put(i,set);
        return set;
    }
}