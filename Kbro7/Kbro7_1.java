package Kbro_Study.Kbro7;

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // 방향 배열
        int[][] movement = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        // 시작위치
        int start_y = 0;
        int start_x = 0;
        int cnt = 1; // 횟수 세기위함(첫칸은 무조건 세어줘야하니 1)

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        visited[start_y][start_x] = true;

        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        l.add(start_y); l.add(start_x); l.add(cnt);
        q.offer(l);

        while(!q.isEmpty()) {
            List<Integer> ll = new ArrayList<>();
            ll = q.poll();
            System.out.println("현재위치 & cnt : " + ll);
            int now_y = ll.get(0);
            int now_x = ll.get(1);
            int now_cnt = ll.get(2);

            if(now_y == n-1 && now_x == m-1) return now_cnt;

            for(int i = 0; i < movement.length; i++) {
                int move_y = movement[i][1] + now_y; //현재위치 + 위아래이동좌표
                int move_x = movement[i][0] + now_x; //현재위치 + 좌우이동좌표

                if((0 <= move_y && move_y <n) && (0<=move_x && move_x < m) && (!visited[move_y][move_x]) && maps[move_y][move_x]==1) {
                    l = new ArrayList<>();
                    visited[move_y][move_x] = true;
                    l.add(move_y); l.add(move_x); l.add(now_cnt+1);
                    q.offer(l);
                    System.out.println("q에 들어있는 리스트들: " + q);
                }
            }
        }
        return -1;
    }
}

public class Kbro7_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1},{0,0,0,0,1}}));
    }
}
