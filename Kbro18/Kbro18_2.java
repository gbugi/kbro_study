package Kbro_Study.Kbro18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Kbro18_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] people = new int[N][2];

            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                people[j][0] = Integer.parseInt(st.nextToken());
                people[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(people, Comparator.comparing((int[] p) -> p[0]));

            int count = 1;
            int max_score = people[0][1];

            for(int j = 1; j < N; j++) {
               if(max_score > people[j][1]) {
                   count++;
                   max_score = people[j][1];
               }
            }
            System.out.println(count);
        }
    }
}
