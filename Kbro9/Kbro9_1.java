package Kbro_Study.Kbro9;

import java.util.Stack;

/**
 * 최대 cap개 실을수 있음
 * i번째 집은 물류창고에서 i만큼 떨어져 있음
 * i번째 집은 j번째 집과 거리 j- i
 * 모든 배달과 수거 마치고 물류창고로 돌아올 수 있는 최소 이동 거리?
 * 배달할 집의 개수: n, 각 집에 배달할 재활용 택배 상자의 개수: deliveries
 * 각 집에서 수거할 빈 재활용 택배 상자의 개수: pickups
 */

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int box = 0; // 현재까지 담은 박스의 개수
        Stack<Integer> delivery_stack = new Stack<>();
        Stack<Integer> pickup_stack = new Stack<>();
        long answer = 0;

        for(int i = 0; i < n; i++) {
            delivery_stack.push(deliveries[i]);
            pickup_stack.push(pickups[i]);
        }

        // 가장 먼 곳에 배달도 회수도 없는 집인 경우 제거
        while (!delivery_stack.isEmpty() && delivery_stack.peek() == 0) delivery_stack.pop();
        while (!pickup_stack.isEmpty() && pickup_stack.peek() == 0) pickup_stack.pop();

        while(!(delivery_stack.isEmpty() && pickup_stack.isEmpty())) {
            answer += Math.max(delivery_stack.size() * 2, pickup_stack.size() * 2); // 가장 멀리 있는 집 먼저 방문
            box = 0;

            while(!delivery_stack.isEmpty() && box <= cap) {
                if(delivery_stack.peek() + box <= cap) {
                    box += delivery_stack.peek();
                } else {
                    delivery_stack.set(delivery_stack.size()-1, delivery_stack.peek() - (cap - box)); //일부만 실음
                    break;
                }
                delivery_stack.pop();
            }

            box = 0; // 배송완료후 초기화
            while(!pickup_stack.isEmpty() && box <= cap) {
                if(pickup_stack.peek() + box <= cap) {
                    box += pickup_stack.peek();
                } else {
                    pickup_stack.set(pickup_stack.size()-1, pickup_stack.peek() - (cap - box));
                    break;
                }
                pickup_stack.pop();
            }
        }

        return answer;
    }
}

public class Kbro9_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2,2, new int[]{0,0}, new int[]{0,0}));

    }
}
