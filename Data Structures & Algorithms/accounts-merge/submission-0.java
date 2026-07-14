class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> emailToAcc = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());
        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(emailToAcc.containsKey(email)){
                    uf.union(i,emailToAcc.get(email));
                }
                else{
                    emailToAcc.put(email,i);
                }
            }
        }

        HashMap<Integer,List<String>> emailGroup = new HashMap<>();

        for(Map.Entry<String,Integer> entry : emailToAcc.entrySet()){
            String email = entry.getKey();
            int accId = entry.getValue();

            int leader = uf.find(accId);
            emailGroup.computeIfAbsent(leader,k -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry : emailGroup.entrySet()){
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(emails);
            res.add(merged);
        }

        return res;
    }
}

class UnionFind{
    int[] parent;
    int[] rank;

    UnionFind(int n){
        this.parent = new int[n];
        this.rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int n){
        int p = parent[n];
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    public boolean union(int u, int v){
        int p1 = find(u);
        int p2 = find(v);

        if(p1 == p2){
            return false;
        }
        else if(rank[p1] > rank[p2]){
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