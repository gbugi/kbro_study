package Kbro_Study;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s : scoville){
            minHeap.offer(s); // 최소힙에 s값 추가
        }

        int answer = 0;
        while(minHeap.peek() < K) {
            //minHeap sisze가 2보다 작을때는 poll두번하는 과정에서 NPE 뜸
            if(minHeap.size() < 2 && minHeap.peek() < K) {
                answer = -1;
                break;
            }
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            minHeap.offer(min1+(2*min2));
            answer++;
        }
        System.out.println(minHeap);
        return answer;
    }
}

public class Kbro2_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));

    }
}
