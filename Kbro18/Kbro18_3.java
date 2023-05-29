package Kbro_Study.Kbro18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kbro18_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        while(s.length() != t.length()) {
            if(t.charAt(t.length()-1) == 'A') {
                t = t.deleteCharAt(t.length()-1); // t의 맨 마지막 문자가 A일경우 삭제
            } else { // t의 맨 마지막 문자가 B일경우 삭제 후 reverse
                t = t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if(s.equals(t.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
