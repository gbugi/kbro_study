package Kbro_Study.Kbro15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro15_1 {
    static int N;
    static int[][] matrix;
    static int[][] dp;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(dp[i][j] == 0) {
                    DFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    public static int DFS(int x, int y) {
        if(dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1; // 첫번째엔 판다를 대나무숲 어디에 내려놔도 1
        int max_dp = 0;

        int move_x, move_y;
        // 상하좌우 이동
        for(int i= 0; i < 4; i++) {
            move_x = x + dx[i];
            move_y = y + dy[i];

            // 범위 벗어났을때 continue
            if(move_x < 0 || move_y < 0 || move_x >= N || move_y >= N) continue;

            // 이동한 곳의 대나무가 더 많을때 DFS 수행
            if(matrix[x][y] < matrix[move_x][move_y]) {
                max_dp = Math.max(max_dp, DFS(move_x,move_y));
            }
        }

        dp[x][y] += max_dp;
        answer = Math.max(answer, dp[x][y]);

        return dp[x][y];
    }
}
