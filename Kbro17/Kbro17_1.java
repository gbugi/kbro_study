package Kbro_Study.Kbro17;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int cnt = 1;

        for(int i = 1; i <= s.length()/2; i++) {
            String result = "";
            String str = s.substring(0, i);

            for(int j = i; j <= s.length(); j+=i) {
                int endIdx = (j+i > s.length()) ? s.length() : j+i;
                String compare = s.substring(j, endIdx);

                if(str.equals(compare)) {
                    cnt++;
                }
                else {
                    if(cnt > 1) {
                        result += cnt;
                        cnt = 1;
                    }
                    result += str;
                    str = compare;
                }
            }
            result += str;
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}

public class Kbro17_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abcabcdede")); //
    }
}
