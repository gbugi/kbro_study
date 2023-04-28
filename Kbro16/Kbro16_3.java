package Kbro_Study.Kbro16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Kbro16_3 {
    static int N, M;
    static char[][] matrix;
    static int[][] dp;
    static Map<Character, int[]> dirMap = new HashMap<>();

    public static int DFS(int x, int y) {
        // 미로를 벗어나면 1 반환
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return 1;
        }

        // 방문한 곳이라면 해당 dp 그대로 반환
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        int[] dir = dirMap.get(matrix[x][y]);
        int move_x = dir[0] + x;
        int move_y = dir[1] + y;

        dp[x][y] = DFS(move_x, move_y);

        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new char[N][M];
        dp = new int[N][M];

        dirMap.put('U', new int[]{-1,0});
        dirMap.put('D', new int[]{1,0});
        dirMap.put('R', new int[]{0,1});
        dirMap.put('L', new int[]{0,-1});

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }

        // dp배열 원소 -1로 초기화(추후에 해당 dp좌표를 방문하면 0, 미로를 벗어나면 1로 변경)
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(dp[i][j] == -1) DFS(i, j);
            }
        }

        int answer = 0;
        for(int[] d : dp) {
            answer += Arrays.stream(d).sum();
        }
        System.out.println(answer);
    }
}
