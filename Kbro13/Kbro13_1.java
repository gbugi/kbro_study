package Kbro_Study.Kbro13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kbro13_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int len_s1 = s1.length();
        int len_s2 = s2.length();

        int[][] dp = new int[len_s1+1][len_s2+1];

        for(int i = 1; i <= len_s1; i++) {
            for(int j = 1; j <= len_s2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[len_s1][len_s2]);
    }
}
