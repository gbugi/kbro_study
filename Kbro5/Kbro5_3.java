package Kbro_Study.Kbro5;

class Solution3 {

    static char str[] = {'A','E','I','O','U'};
    static int answer = 0;
    static int cnt = 0;
    public int solution(String word) {

        dfs("", word);

        return answer;
    }

    public void dfs(String w, String word) {
        if(w.equals(word)) {
            answer = cnt;
            return;
        }

        if(w.length() >= 5) {
            return;
        }

        for(int i = 0; i < 5; i++) {
            cnt++;
            dfs(w+str[i], word);
        }
    }

}

public class Kbro5_3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.solution("AAAE"));
    }
}
