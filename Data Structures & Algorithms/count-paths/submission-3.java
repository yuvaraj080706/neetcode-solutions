class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i==m-1 && j==n-1){
                    continue;
                }
                dp[i][j] = dp[i+1][j] + dp[i][j+1]; 
            }
        }

        return dp[0][0];
    }

    public int helper(int[][] dp,int i, int j,int m, int n){
        if(i>=m || j>=n){
            return 0;
        }

        if(i==m-1 && j==n-1){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j] = helper(dp,i+1,j,m,n) + helper(dp,i,j+1,m,n);
    }
}
