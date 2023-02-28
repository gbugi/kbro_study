package Kbro_Study.Kbro10;

import java.util.Arrays;
import java.util.Comparator;

class Solution1 {
    public int solution(int[][] routes) {
        int location = Integer.MIN_VALUE;
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1])); //차량의 진출시간 기준으로 오름차순

        for(int[] route : routes) {
            int in = route[0];
            int out = route[1];
            if(location < in) {
                location = out;
                answer++;
            }
        }
        return answer;
    }
}

public class Kbro10_1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.solution(new int[][]{{-20,-15},{-14,-5},{-18,-13},{-5,-3}}));
    }
}
