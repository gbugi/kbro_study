package Kbro_Study.Kbro22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kbro22_1 {
    static int n;
    static int dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2][3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        dfs(0,0,0);
        System.out.println(dp[0][0][0]);
    }

    public static int dfs(int idx, int late, int absent) {
        if(late == 2 || absent == 3) {
            return 0;
        }
        if(idx == n) {
            return 1;
        }
        if(dp[idx][late][absent] != -1) {
            return dp[idx][late][absent];
        }
        
        dp[idx][late][absent] = 0; // 방문기록 저장
        dp[idx][late][absent] += (dfs(idx+1, late+1, 0) + dfs(idx+1, late, absent+1)
                + dfs(idx+1, late, 0)) % 1000000;

        return dp[idx][late][absent] % 1000000;
    }
}
