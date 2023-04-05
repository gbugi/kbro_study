package Kbro_Study.Kbro14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro14_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int buy = 0; //사야되는 물병수
        int cnt = 0;

        while(true) {
            cnt = 0;
            int bottle = N;
            while(bottle > 0) {
                if(bottle % 2 != 0) {
                    cnt++;
                }
                bottle /= 2;
            }

            if(cnt <= K) {
                break;
            }

            N += 1;
            buy += 1;

        }
        System.out.println(buy);
    }
}
