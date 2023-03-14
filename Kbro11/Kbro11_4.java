package Kbro_Study.Kbro11;

import java.util.*;

class Node {

    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

class Solution {
    static int[][] dist;
    static List<ArrayList<Node>> graph;
    static int INF = Integer.MAX_VALUE;

    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing((Node node) -> node.cost));
        pq.add(new Node(start, 0));
        dist[start][start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if(curNode.cost > dist[start][curNode.end]) continue;

            for(Node adjNode : graph.get(curNode.end)) {
                int weight = curNode.cost + adjNode.cost;
                if(weight < dist[start][adjNode.end]) {
                    dist[start][adjNode.end] = weight;
                    pq.add(new Node(adjNode.end, weight));
                }
            }
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        dist = new int[n+1][n+1];

        for(int i= 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(dist[i], INF);
        }

        for(int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        for(int i = 1; i <= n; i++) dijkstra(i);

        for(int i=1 ;i<n+1; i++) answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);

        return answer;
    }
}

public class Kbro11_4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6,4,6,2,new int[][]{{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}}));
    }
}
