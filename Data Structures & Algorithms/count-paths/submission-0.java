class Solution {
    int count = 0;
    public int uniquePaths(int m, int n) {
        helper(0,0,m,n);
        return count;
    }

    public void helper(int i, int j,int m, int n){
        if(i>=m || j>=n){
            return;
        }

        if(i==m-1 && j==n-1){
            count++;
            return;
        }
        helper(i+1,j,m,n);
        helper(i,j+1,m,n);
    }
}
