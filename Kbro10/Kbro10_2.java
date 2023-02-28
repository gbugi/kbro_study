package Kbro_Study.Kbro10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    static int[] parent;

    public int find(int n){
        if (parent[n] == n) return n;
        return find(parent[n]);
    }

    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA < parentB) {
            parent[parentB] = parent[parentA];
        } else {
            parent[parentA] = parent[parentB];
        }
    }

    public int solution(int n, int[][] costs) {

        int answer = 0;
        parent = IntStream.iterate(0, i->i+1)
                .limit(n)
                .toArray();
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2])); //int 배열 두번째 원소로 오름차순
        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            if(find(a) == find(b)) continue;

            union(a,b);
            answer += c;
        }

        return answer;
    }
}

public class Kbro10_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[][]{{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}}));
    }
}
