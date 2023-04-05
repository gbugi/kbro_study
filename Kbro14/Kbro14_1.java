package Kbro_Study.Kbro14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kbro14_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] friends = new char[N][N];
        int[][] visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                friends[i][j] = str.charAt(j);
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if ( i == j ) continue;
                    if(friends[i][j] == 'Y' || (friends[i][k] == 'Y' && friends[k][j] == 'Y')) {
                        visited[i][j] = 1;
                    }
                }
            }
        }

        int count = 0;
        for(int[] visit : visited) {
            int sum = 0;
            for(int v : visit) {
                sum += v;
            }
            count = Math.max(count, sum);
        }
        System.out.println(count);
    }
}
