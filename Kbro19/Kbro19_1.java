package Kbro_Study.Kbro19;

import java.util.*;

class Solution {
    static int[] distance;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph = new ArrayList<>();

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        distance = new int[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        BFS(destination);

        int length = sources.length;
        int[] answer = new int[length];

        for(int i = 0; i < length; i++) {
            int count = distance[sources[i]];
            if(count != 0 || destination == sources[i]) {
                answer[i] = count;
            } else {
                answer[i] = -1;
            }
        }


        return answer;
    }

    public void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n); visited[n] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> list = graph.get(now);

            for(int i = 0; i < list.size(); i++) {
                if(!visited[list.get(i)]) {
                    queue.offer(list.get(i));
                    visited[list.get(i)] = true;
                    distance[list.get(i)] = distance[now] + 1;
                }
            }
        }
    }
}

public class Kbro19_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[][]{{1,2}, {1,4}, {2,4}, {2,5}, {4,5}}, new int[]{1,3,5}, 5)));
    }
}
