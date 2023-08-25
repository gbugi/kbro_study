package Kbro_Study.Kbro26;

import java.util.*;

class Solution {
    public long solution(int[] weights) {

        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        long answer = 0;

        for(int weight : weights){
            double w = Double.valueOf(weight);
            if(map.containsKey(w)){
                answer += map.get(w);
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
            map.put((w * 3) / 2, map.getOrDefault((w * 3) / 2, 0) + 1);
            map.put((w * 4) / 2, map.getOrDefault((w * 4) / 2, 0) + 1);
            map.put((w * 4) / 3, map.getOrDefault((w * 4) / 3, 0) + 1);
        }
        return answer;
    }
}

public class Kbro26_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{100,180,360,100,270}));
    }
}
