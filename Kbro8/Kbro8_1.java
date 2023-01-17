package Kbro_Study.Kbro8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kbro8_1 {
    static Queue<List<Integer>> queue = new LinkedList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int cnt = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] miro = new int[N][M]; //미로 2차원 배열
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                miro[i][j] = Character.getNumericValue(ch);
            }
        }

        System.out.println(BFS(0, 0, cnt, visited, miro, N, M));
    }

    static int BFS(int y, int x, int cnt, boolean[][] visited, int[][] miro, int N, int M) {
        visited[y][x] = true;
        queue.offer(new ArrayList<Integer>(Arrays.asList(y,x,cnt)));

        while(!queue.isEmpty()) {
            List<Integer> pollList = queue.poll();
            int now_y = pollList.get(0); int now_x = pollList.get(1); int now_cnt = pollList.get(2);
            if(now_y == N-1 && now_x == M-1) return now_cnt;

            for(int i = 0; i < 4; i++) {
                int move_y = now_y + dy[i];
                int move_x = now_x + dx[i];

                if((0 <= move_y && move_y < N) && (0 <= move_x && move_x < M) && !visited[move_y][move_x] && miro[move_y][move_x] == 1) {
                    visited[move_y][move_x] = true;
                    queue.offer(new ArrayList<Integer>(Arrays.asList(move_y, move_x, now_cnt+1)));
                }
            }
        }
        return -1;
    }
}
