package Kbro_Study.Kbro14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro14_4 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        recursive(size, r, c);
        System.out.println(cnt);
    }

    public static void recursive(int size, int r, int c) {
        if(size ==  1) {
            return;
        }
        // 1사분면
        if(r < size/2 && c < size/2) {
            recursive(size/2, r, c);
        // 2사분면
        } else if(r < size/2 && c >= size/2) {
            cnt += size * size / 4;
            recursive(size/2, r, c - size/2);
        // 3사분면
        } else if(r >= size/2 && c < size/2) {
            cnt += (size * size / 4) * 2;
            recursive(size/2, r - size/2, c);
        // 4사분면
        } else {
            cnt += (size * size / 4) * 3;
            recursive(size/2, r - size/2, c - size/2);
        }
    }
}
