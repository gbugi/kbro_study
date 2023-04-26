package Kbro_Study.Kbro16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kbro16_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] max_dp = new int[3];
        int[] min_dp = new int[3];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            if(i == 0) {
                max_dp[0] = n1; min_dp[0] = n1;
                max_dp[1] = n2; min_dp[1] = n2;
                max_dp[2] = n3; min_dp[2] = n3;
            } else {
                int before_max_dp_0 = max_dp[0] , before_max_dp_1 = max_dp[1];
                max_dp[0] = Math.max(max_dp[0], max_dp[1]) + n1;
                max_dp[1] = Math.max(Math.max(before_max_dp_0, max_dp[1]), max_dp[2]) + n2;
                max_dp[2] = Math.max(before_max_dp_1, max_dp[2]) + n3;

                int before_min_dp_0 = min_dp[0] , before_min_dp_1 = min_dp[1];
                min_dp[0] = Math.min(min_dp[0], min_dp[1]) + n1;
                min_dp[1] = Math.min(Math.min(before_min_dp_0, min_dp[1]), min_dp[2]) + n2;
                min_dp[2] = Math.min(before_min_dp_1, min_dp[2]) + n3;
            }
        }

        System.out.println(Arrays.stream(max_dp).max().getAsInt() + " " + Arrays.stream(min_dp).min().getAsInt());
    }
}
