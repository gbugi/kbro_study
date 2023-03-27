package Kbro_Study.Kbro12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro12_2 {
    static int n,k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][k+1];

        System.out.println(bottom_up());
        dp = new int[n+1][k+1];
        System.out.println(top_down(n,k));
    }

    static int bottom_up() {
        //초기화
        for(int i = 0; i <= k; i++) {
            dp[0][i] = 1;
        }
        for(int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 2; j < k+1; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }
        return dp[n][k];
    }

    static int top_down(int n, int k) {
        if(n==1) dp[n][k] = k;
        else if(k==1) dp[n][k] = 1;
        else if(dp[n][k] == 0) dp[n][k] = (top_down(n-1, k) + top_down(n, k-1)) % 1000000000;
        return dp[n][k];
    }
}
