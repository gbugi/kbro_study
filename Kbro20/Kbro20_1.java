package Kbro_Study.Kbro20;

import java.util.Arrays;

class Solution {
    private static final int[] DISCOUNT = {10, 20, 30, 40};
    private static int TOTAL_SALES = 0;
    private static int TOTAL_EMO_PLUS = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        getPrices(emoticons, users, 0, new int[emoticons.length]);

        return new int[]{TOTAL_EMO_PLUS, TOTAL_SALES};
    }

    private void getPrices(int[] emoticons, int[][] users, int cur, int[] rates) {
        if (cur == emoticons.length) {
            System.out.println("--------------------"+ Arrays.toString(rates));
            updateAnswer(emoticons, users, rates);
            return;
        }

        for (int dis : DISCOUNT) {
            rates[cur] = dis;
            System.out.println("cur: " + cur + ", " + Arrays.toString(rates));
            getPrices(emoticons, users, cur + 1, rates);
        }
    }

    private void updateAnswer(int[] emoticons, int[][] users, int[] rates) {
        int total_expensive = 0;
        int emo_plus = 0;

        for(int[] user : users) {
            int expensive = 0;
            int rate = user[0];
            int price = user[1];

            for(int i = 0; i < rates.length; i++) {
                if(rate <= rates[i]) {
                    expensive += emoticons[i] * (100 - rates[i]) / 100;
                }
                if(expensive >= price) {
                    expensive = 0;
                    emo_plus += 1;
                    break;
                }
            }
            total_expensive += expensive;
        }
        if(emo_plus > TOTAL_EMO_PLUS) {
            TOTAL_EMO_PLUS = emo_plus;
            TOTAL_SALES = total_expensive;
        } else if(emo_plus == TOTAL_EMO_PLUS) {
            TOTAL_SALES = Math.max(TOTAL_SALES, total_expensive);
        }
    }
}

public class Kbro20_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{40,10000},{25,10000}}, new int[]{7000,9000})));
    }
}
