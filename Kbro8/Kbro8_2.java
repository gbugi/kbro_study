package Kbro_Study.Kbro8;

import java.util.*;

class Solution {
    private ArrayList<ArrayList<Integer>> adjList;
    private boolean[] visited;
    private int depth = 0;
    private int answer = 0;

    public int solution(int n, int[][] edge) {
        adjList = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n + 1];

        //인접리스트 초기틀 생성
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        //인접리스트에 인접한 노드 추가
        for (int i = 0; i < edge.length; i++) {
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }
        //오름차순 정렬
        for (int i = 0; i < adjList.size(); i++) {
            Collections.sort(adjList.get(i));
        }

        BFS(1, 0);

        return answer;
    }

    public void BFS(int start, int cnt) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        queue.offer(cnt);

        Map<Integer, Integer> map = new HashMap<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();
            int now_cnt = queue.poll();

            for (int i = 0; i < adjList.get(node).size(); i++) {
                int next_node = adjList.get(node).get(i);
                if(depth < now_cnt) depth = now_cnt; // 제일 먼 곳의 depth 저장

                if (!visited[next_node]) {
                    visited[next_node] = true;
                    queue.offer(next_node);
                    queue.offer(now_cnt+1);
                    map.put(next_node, now_cnt+1);
                }
            }
        }

        for(int m : map.values()) {
            if(m==depth) {
                answer++;
            }
        }
    }
}



public class Kbro8_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2},{2,4}, {5,2}}));
    }
}
