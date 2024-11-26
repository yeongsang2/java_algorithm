package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_31403 {
    public static void main(String[] args) throws IOException {

        BufferedReader br;
        int a;
        int b;
        int c;
        br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        System.out.println(a+b-c);
        int temp = Integer.parseInt(Integer.toString(a) + Integer.toString(b)) - c;
        System.out.println(temp);
    }
}
