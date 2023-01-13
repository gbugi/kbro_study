package Kbro_Study.Kbro7;

import java.util.LinkedList;
import java.util.Queue;

//DFS
class Solution2 {
    int answer = 0; //네트워크 수

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]) {
                dfs(visited, i, computers);
                answer++;
            }
        }


        return answer;
    }

    public void dfs(boolean[] visited, int i, int[][] computers) {
        visited[i] = true;
        for(int j=0; j < computers[i].length; j++) {
            if(i!=j && computers[i][j] == 1 && visited[j] == false) {
                dfs(visited, j, computers);
            }
        }
    }
}

//BFS
class Solution3 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                bfs(visited, i, computers);
            }
        }

        return answer;
    }

    public void bfs(boolean[] visited, int i, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while(!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;

            for(int j = 0; j < computers[node].length; j++) {
                if(node != j && computers[node][j] == 1 && !visited[j]) {
                    q.offer(j);
                }
            }
        }
    }
}

public class Kbro7_3 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

    }
}
