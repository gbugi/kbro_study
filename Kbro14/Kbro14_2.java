package Kbro_Study.Kbro14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Kbro14_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N+1];
        List<Integer> ans = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = N; i >= 1; i--) {
            ans.add(num[i],i);
        }
        for(int a : ans) {
            System.out.print(a + " ");
        }
    }
}
