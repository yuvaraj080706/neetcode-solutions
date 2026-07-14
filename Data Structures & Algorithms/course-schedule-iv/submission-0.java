class Solution {
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    List<Boolean> res = new ArrayList<>();

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        for(int[] pre : prerequisites){
            map.computeIfAbsent(pre[0],k -> new ArrayList<>()).add(pre[1]);
        }

        for(int[] q : queries){
            res.add(dfs(q[0],q[1]));
        }

        return res;
    }

    private boolean dfs(int u, int v){
        if(u == v){
            return true;
        }

        for(int nei : map.getOrDefault(u, Collections.emptyList())){
            if(dfs(nei,v)){
                return true;
            }
        }

        return false;
    }
}