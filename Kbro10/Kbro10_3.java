package Kbro_Study.Kbro10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Kbro10_3 {
    static int[] parent;
    static int[][] graph;
    static int node1;
    static int node2;
    static int weight;

    static int find(int n) {
        if(parent[n] == n) return n;
        return find(parent[n]);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentA < parentB) parent[parentB] = parent[parentA];
        else parent[parentA] = parent[parentB];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = 0;

        parent = IntStream.iterate(0, i->i+1)
                .limit(v+1)
                .toArray();

        graph = new int[e+1][3];

        for(int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); // 정점 A
            int b = Integer.parseInt(st.nextToken()); // 정점 B
            int c = Integer.parseInt(st.nextToken()); // 가중치 C
            graph[i] = new int[]{a, b, c};
        }
        Arrays.sort(graph, Comparator.comparingInt((int[] o) -> o[2])); //가중치 기준으로 오름차순 정렬

        for(int[] g : graph) {
            node1 = g[0];
            node2 = g[1];
            weight = g[2];
            
            if(find(node1) == find(node2)) continue;

//            System.out.println("유니온 전 어레이 : " + Arrays.toString(parent));
            union(node1, node2);
//            System.out.println("유니온 후 어레이 : " + Arrays.toString(parent));
            answer += weight;
        }
        System.out.println(answer);
    }
}
