package Kbro_Study.Kbro9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kbro9_5 {
    static int n;
    static int m;
    static int v;
    static int node1;
    static int node2;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수
        v = Integer.parseInt(st.nextToken()); // 탐색 시작 노드

        graph = new int[n+1][n+1]; // 0으로 초기화
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = graph[node2][node1] = 1; // 간선 연결상태 그래프 만들기
        }

        DFS(v);
        visited = new boolean[n+1]; // DFS후 초기화
        System.out.println();
        BFS(v);
    }

    static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for(int i = 1; i <= n; i++) {
            if(!visited[i] && graph[start][i] == 1) {
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int i = 1; i <= n; i++) {
                if(i != node && graph[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
