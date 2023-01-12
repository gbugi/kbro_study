package Kbro_Study.Kbro4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, HashSet<String>> hm = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < clothes.length; i++) {
            String cloth = clothes[i][0];
            String type = clothes[i][1];

            hm.putIfAbsent(type, new HashSet<>(){{
                add(cloth);
            }});
            hm.get(type).add(cloth);
        }
        System.out.println(hm);
        for(String key : hm.keySet()){
            answer *= hm.get(key).size()+1;
        }

        return answer-1;
    }
}

public class Kbro4_1 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        Solution solution = new Solution();
        System.out.println(solution.solution(clothes));
        System.out.println(solution.solution(clothes2));
    }
}
