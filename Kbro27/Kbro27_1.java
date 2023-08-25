package Kbro_Study.Kbro27;

import java.util.Stack;

class Solution {
    static int order_idx = 0;
    static int cnt = 0;
    static Stack<Integer> stack = new Stack<>();

    public int solution(int[] order) {

        for(int i = 1; i <= order.length; i++) {
            if(i != order[order_idx]) {
                stack.push(i);
            } else if(i == order[order_idx]) {
                cnt++;
                order_idx++;

                while(!stack.isEmpty()) {
                    if(stack.peek() != order[order_idx]) break;
                    stack.pop();
                    cnt++;
                    order_idx++;
                }
            }
        }

        return cnt;
    }
}

public class Kbro27_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{4,3,1,2,5}));
    }
}
