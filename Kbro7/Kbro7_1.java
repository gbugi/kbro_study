package Kbro_Study.Kbro7;

import java.sql.Array;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // 방향 배열
        int[] dy = {1, -1, 0, 0}; //상하
        int[] dx = {0, 0, 1, -1}; //좌우

        // 시작위치
        int start_y = 0;
        int start_x = 0;
        int cnt = 0; // 횟수 세기위함

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        visited[start_y][start_x] = true;

        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        l.add(start_y);
        l.add(start_x);
        l.add(cnt);
        q.offer(l);

        while(!q.isEmpty()) {
            List<Integer> ll = new ArrayList<>();
            ll = q.poll();
            int now_y = ll.get(0);
            int now_x = ll.get(1);
            int now_cnt = ll.get(2);

            if(now_y == n-1 && now_x == m-1) return now_cnt;

            for(int i = 0; i < 4; i++) {
                int move_y = dy[i] + now_y; //현재위치 + 위아래이동좌표
                int move_x = dx[i] + now_x; //현재위치 + 좌우이동좌표

                if((0 <= move_y <n) && (0<=move_x<m) && (!visited[move_y][move_x]) && maps[move_y][move_x]==1) {

                }
            }

        }


        int answer = 0;
        return answer;
    }
}

public class Kbro7_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1},{0,0,0,0,1}}));
    }
}
