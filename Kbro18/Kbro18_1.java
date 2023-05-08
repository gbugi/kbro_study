package Kbro_Study.Kbro18;

import java.util.Arrays;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        int len_section = (int) Math.ceil(minerals.length / 5.0);
        int sum_picks = picks[0] + picks[1] + picks[2];
        // 분할된 섹션보다 곡괭이 수가 적을때는 곡괭이 수에 섹션수를 맞춰줌
        if(len_section > sum_picks) {
            len_section = sum_picks;
        }
        int[][] section = new int[len_section][3]; // 두번째 배열은 dia, iron, stone 피로도 순

        for(int i = 0; i < minerals.length; i++) {
            if(len_section <= i / 5) break;
            if(minerals[i].equals("diamond")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 5;
                section[i / 5][2] += 25;
            } else if(minerals[i].equals("iron")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 5;
            } else if(minerals[i].equals("stone")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 1;
            }
        }

        //돌로 캤을떄 가장 피로도가 많이 드는 섹션을 다이아몬드 곡괭이로 파야하기에 정렬해줌
        Arrays.sort(section, ((o1, o2) -> {
            return o2[2] - o1[2];
        }));
        
        int answer = 0;
        for(int[] s : section) {
            if(picks[0] > 0) {
                answer += s[0];
                picks[0] -= 1;
                continue;
            }
            if(picks[1] > 0) {
                answer += s[1];
                picks[1] -= 1;
                continue;
            }
            if(picks[2] > 0) {
                answer += s[2];
                picks[2] -= 1;
                continue;
            }
        }

        return answer;
    }
}

public class Kbro18_1 {
    public static void main(String[] args) {
        // 다이아 곡괭이: 모든 피로도1
        // 철 곡괭이: 다이아:5, 철:1, 돌:1
        // 돌 곡괭이: 다이아:25, 철:5, 돌:1
        // 광물 5개 캐면 더 못캠
        // picks : [다이아,철,돌]
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,3,2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
    }
}
