package Kbro_Study.Kbro13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kbro13_3 {
    static int[] lis;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /** DP 이용방식
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // dp배열 1로 초기화(길이 배열)
        }

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(numArr[i] < numArr[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int max = 0;
        for(int d : dp) {
            max = Math.max(max, d);
        }
        System.out.println(max);
         */

        // 이분탐색 이용방식
        N = Integer.parseInt(br.readLine());
        lis = new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int lisIdx = 0;

        for(int i = 1; i < N; i++) {
            System.out.println(lisIdx);
            if(lis[lisIdx] < arr[i]) {
                lisIdx++;
                lis[lisIdx] = arr[i];
            } else {
                int idx = lowerBound(0, lisIdx, arr[i]);
                lis[idx] = arr[i];
            }
        }
        System.out.println(lisIdx+1);
    }

    public static int lowerBound(int Left, int Right, int n) {
        int mid = 0;
        while(Left < Right) {
            mid = (Left + Right) / 2;
            if(n <= lis[mid]) {
                Right = mid;
            } else {
                Left = mid + 1;
            }
        }
        return Left;
    }
}