package Kbro_Study.Kbro17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Kbro17_2 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int[][] matrix;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        dist = new int[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            Arrays.fill(dist[i], Integer.MAX_VALUE);

            for(int j = 0; j < n; j++) {
                matrix[i][j] = s.charAt(j) - '0';
            }
        }
        BFS();
        System.out.println(dist[n-1][n-1]);
    }

    public static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));
        dist[0][0] = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int move_x = now.x + dx[i];
                int move_y = now.y + dy[i];

                if(move_x >= 0 && move_y >= 0 && move_x < n && move_y < n && dist[move_x][move_y] > dist[now.x][now.y]) {
                    // 현재위치가 흰색 방이면
                    if(matrix[move_x][move_y] == 1) dist[move_x][move_y] = dist[now.x][now.y];
                    else dist[move_x][move_y] = dist[now.x][now.y] + 1;
                    queue.offer(new Node(move_x, move_y));
                }
            }
        }
    }
}
