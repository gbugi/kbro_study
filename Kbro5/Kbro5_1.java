package Kbro_Study.Kbro5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /**
     * 1번 찍는방식 : 1,2,3,4,5 반복
     * 2번 찍는방식 : 2,1,2,3,2,4,2,5 반복
     * 3번 찍는방식 : 3,3,1,1,2,2,4,4,5,5 반복
     */
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];

        //맞춘 개수 count
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == p1[i%5]) score[0]++;
            if(answers[i] == p2[i%8]) score[1]++;
            if(answers[i] == p3[i%10]) score[2]++;
        }

        List<Integer> answerList = new ArrayList<>();
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        for(int i = 0; i < score.length; i++){
            if(score[i] == max) answerList.add(i+1);
        }

        int[] answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}

public class Kbro5_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(solution.solution(new int[]{1,3,2,4,2})));
    }
}
