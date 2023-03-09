package Kbro_Study.Kbro11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Kbro11_3 {
    static int N;
    static int M;
    static List<Node> graph;
    static int INF = Integer.MAX_VALUE;
    static long[] dist;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int time;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.time = cost;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 출발지는 0으로

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph.add(new Node(start, end, time));
        }

        if(bellmanFord()) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for(int i = 2; i<=N; i++) {
                if(dist[i]==INF) sb.append(-1);
                else sb.append(dist[i]);
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }

    static boolean bellmanFord() {
        /* 1. 최단거리 계산 */
        for(int i = 1; i <= M; i++) {
            for(Node node : graph) {
                if(dist[node.start] != INF && dist[node.end] > dist[node.start] + node.time) { // 갱신
                    if(i == M)  return true; // 2. 사이클 발생 여부 체크
                    dist[node.end] = dist[node.start] + node.time;
                }
            }
        }

        return false;
    }
}
