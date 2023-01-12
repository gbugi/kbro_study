package Kbro_Study.Kbro5;

import java.util.Arrays;

class Solution2 {
    private int answer = 0;
    private boolean[] visit; //방문여부

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];

        dfs(0, k, dungeons); //0은 depth, k 는 현재 피로도

        return answer;
    }

    private void dfs(int depth, int k, int[][]dungeons){
        for(int i = 0; i<dungeons.length; i++){
            System.out.println(i);
            if(!visit[i]&& dungeons[i][0]<=k){
                visit[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}

public class Kbro5_2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(40, new int[][]{{40,20}, {10,10}, {10,10},{10,10},{10,10}}));
    }
}
