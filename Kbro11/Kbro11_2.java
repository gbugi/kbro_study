import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static int[][] dist;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int INF = Integer.MAX_VALUE;
    static int cnt;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }

    }

    static int[][] dijkstra(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[x][y] = matrix[x][y];
        pq.offer(new Node(x,y, dist[x][y]));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(node.x == N-1 && node.y == N-1) break;
            if(node.cost > dist[node.x][node.y]) continue; //최소 비용 갱신 안될땐 continue

            for(int i = 0; i < 4; i++) {
                int move_x = node.x + dx[i];
                int move_y = node.y + dy[i];
                if(move_x >= 0 && move_x < N && move_y >= 0 && move_y < N) {
                    int new_cost = matrix[move_x][move_y] + node.cost;
                    if(dist[move_x][move_y] > new_cost) {
                        dist[move_x][move_y] = new_cost;
                        pq.offer(new Node(move_x, move_y, new_cost));
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            cnt++;
            N = Integer.parseInt(br.readLine());
            matrix = new int[N][N];
            dist = new int[N][N];

            if(N == 0) break;
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }
            System.out.println("Problem" + " " + cnt + ": " + dijkstra(0,0)[N-1][N-1]);
        }

    }
}