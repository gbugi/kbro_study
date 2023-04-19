package Kbro_Study.Kbro15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kbro15_2 {
    static int N;
    static boolean[] switches;
    static boolean[] targets;
    static boolean[] copy_switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String str1 = br.readLine();
        String str2 = br.readLine();
        switches = new boolean[N];
        targets = new boolean[N];

        for(int i = 0; i < N; i++) {
            if(str1.charAt(i) == '0') switches[i] = true;
            if(str2.charAt(i) == '0') targets[i] = true;
        }

        copy_switches = Arrays.copyOf(switches, N);
        int a1 = iteration(copy_switches, true);
        copy_switches = Arrays.copyOf(switches, N);
        int a2 = iteration(copy_switches, false);
        int answer = Math.min(a1,a2);

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }

    public static void clickSwitches(int idx) {
        if(idx == 0) {
            changeLamp(idx); changeLamp(idx+1);
        } else if(idx == N-1) {
            changeLamp(idx); changeLamp(idx-1);
        } else {
            changeLamp(idx); changeLamp(idx-1); changeLamp(idx+1);
        }
    }

    public static void changeLamp(int idx) {
        if(copy_switches[idx]) copy_switches[idx] = false;
        else copy_switches[idx] = true;
    }

    public static boolean isSame(boolean[] copy_switches) {
        for(int i = 0; i < N; i++) {
            if(copy_switches[i] != targets[i]) return false;
        }
        return true;
    }

    public static int iteration(boolean[] copy_switches, boolean first) {
        int answer = 0;
        if(first) {
            clickSwitches(0);
            answer++;
        }
        for(int i = 1; i < N; i++) {
            if(copy_switches[i-1] != targets[i-1]) {
                clickSwitches(i);
                answer++;
            }
        }
        if(!isSame(copy_switches)) return Integer.MAX_VALUE;

        return answer;
    }
}
