class Solution {
    public int tribonacci(int n) {
        return dfs(n);
    }

    private int dfs(int n){
        if(n==0)    return 0;
        if(n==1 || n==2)    return 1;
        return dfs(n-1) + dfs(n-2) + dfs(n-3);
    }
}