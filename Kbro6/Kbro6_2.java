package Kbro_Study.Kbro6;

import java.util.*;

/**
 *  런타임에러, 시간초과 코드
 *  순열 + PriorityQueue
 */

//class Solution2 {
//    private String[] output;
//    private boolean[] visited;
//    private PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//
//    public String solution(int[] numbers) {
//        visited = new boolean[numbers.length];
//        output = new String[numbers.length];
//
//        dfs(numbers, output, visited, 0) ;
//
//        String answer = String.valueOf(pq.poll());
//        return answer;
//    }
//
//    public void dfs(int[] numbers, String[] output, boolean[] visited, int depth) {
//        if(depth == numbers.length) {
//            StringBuilder sb = new StringBuilder();
//            for(String o : output) sb.append(o);
//            pq.offer(Integer.parseInt(String.valueOf(sb)));
//            return;
//        }
//
//        for(int i = 0; i < numbers.length; i++) {
//            if(visited[i] != true) {
//                visited[i] = true;
//                output[depth] = String.valueOf(numbers[i]);
//                dfs(numbers, output, visited, depth+1);
//                visited[i] = false;
//            }
//        }
//    }
//}


class Solution2 {
    public String solution(int[] numbers) {
        String[] numArr = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) numArr[i] = String.valueOf(numbers[i]);
        Arrays.sort(numArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(numArr[0].equals("0")) return "0";
        String answer = "";
        for(String n: numArr) answer += n;

        return answer;
    }
}

public class Kbro6_2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(new int[]{3, 30, 34, 5, 9}));
    }


}
