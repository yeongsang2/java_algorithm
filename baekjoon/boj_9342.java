package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String str = "[A-F]?A+F+C+[A-F]?$";
        StringBuilder sb = new StringBuilder();
        while(t-- >0){
            sb.append(br.readLine().matches(str) ? "Infected!" : "Good").append("\n");
        }
        System.out.println(sb.toString());

    }
}
