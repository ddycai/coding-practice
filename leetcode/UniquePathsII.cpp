class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = 1 - grid[0][0];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - 1 >= 0 && grid[i - 1][j] != 1)
                    dp[i][j] += dp[i - 1][j];
                if(j - 1 >= 0 && grid[i][j - 1] != 1)
                    dp[i][j] += dp[i][j - 1];
            }
        }
        
        if(grid[m - 1][n - 1] == 1)
            return 0;
        else
            return dp[m - 1][n - 1];
        
    }
};
