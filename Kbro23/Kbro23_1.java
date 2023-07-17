package Kbro_Study.Kbro23;

import java.util.*;

class Solution {
    static List<String> result = new ArrayList<>();

    static class Node {
        private String subject;
        private int start;
        private int time;

        public Node(String subject, String start, String time) {
            this.subject = subject;
            this.start = timeToMin(start);
            this.time = Integer.parseInt(time);
        }

        public int timeToMin(String start) {
            String[] str = start.split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            return h * 60 + m;
        }
    }

    public String[] solution(String[][] plans) {
        Node[] arr = new Node[plans.length];

        for(int i = 0; i < plans.length; i++) {
            Node node = new Node(plans[i][0],plans[i][1],plans[i][2]);
            arr[i] = node;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.start));
        Stack<Node> stack = new Stack<>(); // 진행 중 과제를 담을 stack

        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }

            Node curNode = stack.peek(); // 진행 중 과제
            Node newNode = arr[i]; // 새로운 과제

            int curStart = curNode.start;
            if(curStart + curNode.time <= newNode.start) {
               recursivePop(stack, newNode, curStart);
                //                do{
//                    result.add(curNode.subject);
//                    curStart += curNode.time;
//                    stack.pop();
//                    curNode = stack.isEmpty() ? null : stack.peek();
//                }	while(!stack.isEmpty() && curStart + curNode.time <= newNode.start);
            } else {
                curNode.time -= newNode.start - curStart;
            }
            stack.push(newNode);
        }

        while(!stack.isEmpty()) {
            result.add(stack.pop().subject);
        }

        return result.toArray(String[]::new);
    }

    public void recursivePop(Stack<Node> stack, Node newNode, int curStart) {
        if (stack.isEmpty()) {
            return;
        }
        Node curNode = stack.peek();   // 진행중 과제
        if (curStart + curNode.time <= newNode.start) {
            result.add(stack.pop().subject);
            recursivePop(stack, newNode, curStart + curNode.time);
        } else {
            curNode.time -= newNode.start - curStart;
        }
    }
}

public class Kbro23_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
    }
}
