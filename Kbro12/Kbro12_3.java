package Kbro_Study.Kbro12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro12_3 {
    static int W;
    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            W = Integer.parseInt(st.nextToken()); // 물품의 무게
            V = Integer.parseInt(st.nextToken()); // 물건의 가치

            for(int j = 1; j <= K; j++) {
                // 무게를 더 담을 수 없는 경우
                if(j - W  < 0) {
                    dp[i][j] = dp[i-1][j]; //이전 물품의 값을 그대로 가져옴(Memoization)
                } else {
                    //무게를 더 담을 수 있는 경우(이전행의 j-w의 가치와 현재물품의 가치를 더한값과 이전행의 값 중 최대값)
                    dp[i][j] = Math.max(dp[i-1][j], V + dp[i-1][j-W]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
