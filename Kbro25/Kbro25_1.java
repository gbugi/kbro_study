package Kbro_Study.Kbro25;

class Solution {
    public int solution(int storey) {

        return elevator(storey);
    }

    public int elevator(int storey) {
        if(storey <= 1) return storey;

        int q = storey / 10;
        int r = storey % 10;

        int goUP = r + elevator(q);
        int goDOWN = (10 - r) + elevator(q + 1);

        return Math.min(goUP, goDOWN);
    }
}

public class Kbro25_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(16));
    }
}
