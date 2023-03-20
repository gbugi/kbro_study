package Kbro_Study.Kbro12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kbro12_1 {
    static long[] dp;
    static int[][] wire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n];
        wire = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            wire[i][0] = n1;
            wire[i][1] = n2;
        }

        Arrays.sort(wire, Comparator.comparingInt((int[] o) -> o[0]));
        long max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(recursive(i), max);
        }
        System.out.println(n - max);
    }

    static long recursive(int num) {
        if(dp[num] == 0) {
            dp[num] = 1;

            for(int i = num+1; i < dp.length; i++) {
                if(wire[num][1] < wire[i][1]) {
                    dp[num] = Math.max(dp[num], recursive(i)+1);
//                    System.out.println(i+": "+dp[num]);
                }
            }
        }
        return dp[num];
    }
}
