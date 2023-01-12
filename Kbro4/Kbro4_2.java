package Kbro_Study.Kbro4;

import java.util.*;

class Solution2 {
    public int[] solution(String[] genres, int[] plays) {

        //HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < plays.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        System.out.println("map값 : " + map);

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(((o1, o2) -> map.get(o2) - map.get(o1)));

        List<Integer> idxList = new ArrayList<>();
        for(String k : keySet) {
            int max = 0;
            int firstIdx = -1;
            //첫번째 index찾기
            for(int i = 0; i < genres.length; i++) {
                if(k.equals(genres[i]) && max < plays[i]){
                    max = plays[i];
                    firstIdx = i;
                }
            }
            //두번째 index찾기
            max = 0;
            int secondIdx = -1;
            for(int i = 0; i < genres.length; i++) {
                if(k.equals(genres[i]) && max < plays[i] && i != firstIdx) {
                    max = plays[i];
                    secondIdx = i;
                }
            }

            idxList.add(firstIdx);
            if(secondIdx >= 0) idxList.add(secondIdx);
        }

        int answer[] = new int[idxList.size()];
        for(int i = 0; i < idxList.size(); i++) answer[i] = idxList.get(i);
        return answer;
    }

    public int[] solution2(String[] genres, int[] plays) {

        //HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> idxList = new ArrayList<>();

        for(int i = 0; i < plays.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        //우선순위 큐에 삽입
        for(String key : map.keySet()){
            pq.offer(map.get(key));
        }
        for(int i = 0; i < map.keySet().size(); i++) {
            int max = 0;
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (pq.peek().equals(map.get(genres[j])) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if (pq.peek().equals(map.get(genres[j])) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            pq.poll();
            idxList.add(firstIdx);
            if(secondIdx >= 0) idxList.add(secondIdx);
        }


        int[] answer = new int[idxList.size()];
        for(int i = 0; i < idxList.size(); i++) answer[i] = idxList.get(i);

        return answer;
    }
}


public class Kbro4_2 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

//        System.out.println(Arrays.toString(new Solution2().solution(genres, plays)));
        System.out.println(Arrays.toString(new Solution2().solution2(genres, plays)));
    }
}
