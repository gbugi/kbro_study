package Kbro_Study.Kbro14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro14_5 {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static int cnt = 0;
    static int INF = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        visited = new boolean[N];
        int root = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) root = i;
        }

        deleteNode(Integer.parseInt(br.readLine()));
        System.out.println(countLeafNode(root));
    }

    public static void deleteNode(int n) {
        parent[n] = INF;
        for(int i = 0; i < N; i++) {
            // n의 자식 노드까지 삭제
            if(parent[i] == n) {
                deleteNode(i);
            }
        }
    }

    public static int countLeafNode(int n) {
        boolean isLeaf = true;
        visited[n] = true;

        if(parent[n] != INF) {
            for(int i = 0; i < N; i++) {
                if(parent[i] == n && !visited[i]) {
                    countLeafNode(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) cnt++;
        }
        return cnt;
    }

}
