class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visit = new HashSet<>();
    HashSet<Integer> cycle = new HashSet<>();
    int idx = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for(int[] pre : prerequisites){
            map.computeIfAbsent(pre[0], k-> new ArrayList<>()).add(pre[1]);
        }

        int[] res = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!dfs(i,res)){
                return new int[]{};
            }
        }

        return res; 
    }

    private boolean dfs(int i,int[] res){
        if(visit.contains(i)){
            return true;
        }

        if(cycle.contains(i)){
            return false;
        }

        cycle.add(i);
        for(int pre : map.getOrDefault(i, Collections.emptyList())){
            if(!dfs(pre,res)){
                return false;
            }
        }

        cycle.remove(i);
        visit.add(i);
        res[idx++] = i;
        return true;
    }
}
