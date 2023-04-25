package Kbro_Study.Kbro16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro16_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dolls = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int len = Integer.MAX_VALUE;
        int cnt = 0;

        while(e <= N && s <= e) {
            if(cnt < K) {
                if(e == N) break;
                if(dolls[e] == 1) {
                    cnt++;
                }
                e++;
            } else {
                len = Math.min(len, e-s);
                if(dolls[s] == 1) {
                    cnt--;
                }
                s++;
            }

        }

        if(len == Integer.MAX_VALUE) len = -1;
        System.out.println(len);
    }
}
