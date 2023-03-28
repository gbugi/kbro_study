package Kbro_Study.Kbro13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro13_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = num[0];
        int max = num[0];

        for(int i=1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + num[i], num[i]);
            System.out.println(dp[i]);
            // 최대값 갱신
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
