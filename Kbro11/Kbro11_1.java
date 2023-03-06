package Kbro_Study.Kbro11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kbro11_1 {
    static final int INF = Integer.MAX_VALUE;
    static List<ArrayList<Node>> arrList;
    static List<ArrayList<Node>> arrBackList;
    static int N, M, X;

    static class Node implements Comparable<Node> {

        int roadNum;
        int time;

        public Node(int roadNum, int time) {
            this.roadNum = roadNum;
            this.time = time;
        }

        // 우선순위 큐의 최소값 비교(
        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 마을사의의 도로 갯수
        X = Integer.parseInt(st.nextToken()); // 마을 번호

        arrList = new ArrayList<>();
        arrBackList = new ArrayList<>();

        // 리스트 틀 생성
        for(int i = 0; i <= N; i++) {
            arrList.add(new ArrayList<>());
            arrBackList.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            arrList.get(start).add(new Node(end, time));
            arrBackList.get(end).add(new Node(start, time));
        }

        int[] dist1 = dijkstra(arrList); // 가는 길 dijkstra
        int[] dist2 = dijkstra(arrBackList); // 돌아오는 길 dijkstra
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i]+ dist2[i]);
        }
        System.out.println(ans);
    }

    public static int[] dijkstra(List<ArrayList<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1]; // 최단경로 갱신 배열
        Arrays.fill(dist, INF); // 최대값으로 배열 초기화
        dist[X] = 0; // 자기자신은 0으로

        while (!pq.isEmpty()) {
            Node queNode = pq.poll();
            int num = queNode.roadNum; // 목표 마을번호

            if (visited[num]) continue; // 방문했으면 continue
            visited[num] = true;
            for (Node node : list.get(num)) {
                // 최단 시간 갱신
                if (!visited[node.roadNum] && dist[node.roadNum] > dist[num] + node.time) {
                    dist[node.roadNum] = dist[num] + node.time;
                    pq.offer(new Node(node.roadNum, dist[node.roadNum]));
                }
            }
        }
        return dist;
    }
}
