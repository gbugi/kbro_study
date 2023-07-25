package Kbro_Study.Kbro24;

/**
 * 가로, 세로, 대각선으로 3개가 같은 표시가 만들어지면 같은 표시를 만든 사람이 승리
 * CASE1: X가 O보다 많은 경우(O가 먼저 시작하므로 이런 경우는 제외)
 * CASE2: O가 X보다 두 개 이상 많은 경우(최대 한 개)
 * CASE3: O가 완성되었을 때, X의 개수가 O의 개수와 같을 때(게임이 끝났는데도 더 진행한 경우)
 * CASE4: X가 완성되었을 때, O의 개수가 X의 개수보다 많을 때(게임이 끝났는데도 더 진행한 경우)
 */

class Solution {
    public int solution(String[] board) {
        int O_cnt = 0;
        int X_cnt = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'O') O_cnt++;
                if(board[i].charAt(j) == 'X') X_cnt++;
            }
        }

        // CASE1 || CASE2
        if(O_cnt < X_cnt || O_cnt > X_cnt + 1) return 0;

        // CASE3 || CASE4
        if(WIN(board, 'O')) {
            if(O_cnt == X_cnt) return 0;
        }

        if(WIN(board, 'X')) {
            if(O_cnt > X_cnt) return 0;
        }

        return 1;
    }

    private static boolean WIN(String[] board, char ch) {
        //가로 판단(연속 세개)
        for(int i = 0; i < 3; i++) {
            if(board[i].charAt(0) == ch && board[i].charAt(1) == ch && board[i].charAt(2) == ch) return true;
        }

        //세로 판단(연속 세개)
        for(int i = 0; i < 3; i++) {
            if(board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) return true;
        }

        //두 개의 대각선 판단(연속 세개)
        if(board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch) return true;
        if(board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch) return true;

        return false;
    }
}

public class Kbro24_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"O.X", ".O.", "..X"}));
        System.out.println(solution.solution(new String[]{"OOO", "...", "XXX"}));
        System.out.println(solution.solution(new String[]{"...", ".X.", "..."}));
        System.out.println(solution.solution(new String[]{"...", "...", "..."}));
    }
}
