package Kbro_Study;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution3_2 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Default: min heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        for(int i = 0; i < operations.length; i++){
            String temp = operations[i];
            if(temp.split(" ")[0].equals("I")) {
                System.out.println("삽입 실행");
                pq.offer(Integer.parseInt(temp.split(" ")[1]));
                pq2.offer(Integer.parseInt(temp.split(" ")[1]));
            }
            //최소값 제거
            else if(temp.split(" ")[0].equals("D") && temp.split(" ")[1].equals("-1")){
                System.out.println("최소값 삭제 실행");
                pq2.remove(pq.poll()); //최소값 제거
            }
            //최대값 제거
            else {
                System.out.println("최대값 삭제 실행");
                pq.remove(pq2.poll()); //pq2에선 poll하고 그값을 pq에서 remove
                System.out.println(pq.remove(pq2.poll()));
            }
            System.out.println("pq는: " + pq);
            System.out.println("pq2는 : "+ pq2);
        }

        int[] answer = new int[2];
        if(!pq.isEmpty() && !pq2.isEmpty()){
            answer[0] = pq2.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}

public class Kbro3_2 {
    public static void main(String[] args) {
        Solution3_2 solution3_2 = new Solution3_2();
        System.out.println(Arrays.toString(solution3_2.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
    }
}
