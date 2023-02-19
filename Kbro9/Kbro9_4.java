package Kbro_Study.Kbro9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kbro9_4 {
    static int m,n,k;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static int count = 0; // 지렁이 개수 count

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visited = new boolean[m][n];

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1; //배추가 있는곳
            }
            count = 0;
            for(int j = 0; j < m; j++) {
                for(int l = 0; l < n; l++) {
                    if(!visited[j][l] && map[j][l] == 1) {
                        count++;
                        BFS(j,l);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            visited[x][y] = true;
            queue.poll();

            for(int i = 0; i < 4; i++) {
                int now_x = x + dx[i];
                int now_y = y + dy[i];

                if(now_x >= 0 && now_y >= 0 && now_x < m && now_y < n && !visited[now_x][now_y] && map[now_x][now_y] == 1) {
                    visited[now_x][now_y] = true;
                    queue.offer(new int[]{now_x, now_y});
                }
            }
        }
    }
}
