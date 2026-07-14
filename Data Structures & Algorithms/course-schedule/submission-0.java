class Solution {
    HashSet<Integer> visit = new HashSet<>();
    Map<Integer,List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] pre) {

        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int pr[] : pre){
            map.get(pr[0]).add(pr[1]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int crs){
        if(visit.contains(crs)){
            return false;
        }

        if(map.get(crs).isEmpty()){
            return true;
        }

        visit.add(crs);
        for(int pre : map.get(crs)){
            if(!dfs(pre)){
                return false;
            }
        }
        visit.remove(crs);
        map.put(crs, new ArrayList<>());

        return true;
    }
}
