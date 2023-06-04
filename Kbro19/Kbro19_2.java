package Kbro_Study.Kbro19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kbro19_2 {
    static int N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] map;
    static boolean[][] visited;
    static int land_num = 2;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    setIsland(i, j);
                    land_num++;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] >= 2) {
                    visited = new boolean[N][N];
                    BFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void setIsland(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y,0));
        visited[x][y] = true;
        map[x][y] = land_num;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int move_x = now.x + dx[i];
                int move_y = now.y + dy[i];

                if((0 <= move_x && move_x < N && 0 <= move_y && move_y < N)
                        && !visited[move_x][move_y] && map[move_x][move_y] == 1) {
                    visited[move_x][move_y] = true;
                    map[move_x][move_y] = land_num;
                    queue.offer(new Node(move_x, move_y, 0));
                }
            }
        }
    }

    private static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        int cur_land = map[x][y];
        queue.offer(new Node(x,y,0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int move_x = now.x + dx[i];
                int move_y = now.y + dy[i];

                if ((0 <= move_x && move_x < N && 0 <= move_y && move_y < N)
                        && !visited[move_x][move_y] && map[move_x][move_y] != cur_land) {
                    visited[move_x][move_y] = true;
                    if(map[move_x][move_y] == 0) {
                        queue.offer(new Node(move_x, move_y, now.cnt+1));
                    } else {
                        answer = Math.min(answer, now.cnt);
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
