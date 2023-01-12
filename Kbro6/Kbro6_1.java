package Kbro_Study.Kbro6;

import java.util.Arrays;

class Solution {
    int[] answer = new int[2];

    public int[] solution(int brown, int yellow) {

        int total = brown+yellow; // 카펫 전체개수
        search(total, yellow);

        return answer;
    }

    public void search(int total, int yellow) {
        for(int i = 3; i < total; i++) {
            if(total % i == 0 && total / i >= 3) {
                int j = total / i;
                int row = Math.min(i, j);
                int col = Math.max(i, j);

                if((row-2) * (col -2) == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                }
            }

//            System.out.println("ans1: " + ans1 + "\t" + "ans2: " + ans2);
        }
    }
}

public class Kbro6_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.solution(10,2)));
//        System.out.println(Arrays.toString(solution.solution(8,1)));
        System.out.println(Arrays.toString(solution.solution(18,6)));
    }
}
