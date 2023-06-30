package Kbro_Study.Kbro21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro21_1 {
    static int h;
    static int w;
    static int[] block;
    static int notZeroCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        block = new int[w];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
            if(block[i] != 0) notZeroCnt += 1;
        }
        if(notZeroCnt <= 1) {
            System.out.println(0);
        }
        else {
            System.out.println(fillRain());
        }

    }

    public static int fillRain() {
        int answer = 0;

        for(int i = 1; i < w-1; i++) {
            int leftMax = findMaxBlock(0, i);
            int rightMax = findMaxBlock(i+1, w);

            if(block[i] < leftMax && block[i] < rightMax) {
                answer += Math.min(leftMax, rightMax) - block[i];
            }
        }
        return answer;
    }

    public static int findMaxBlock(int s, int e) {
        int max = 0;

        for(int i = s; i < e; i++) {
            max = Math.max(max, block[i]);
        }
        return max;
    }
}
