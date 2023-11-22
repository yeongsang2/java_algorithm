package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18311 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int[] course = new int[n];
        boolean reverse = false;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            k -= course[i];
            if(k < 0){
                System.out.println(i+1);
                reverse = true;
                break;
            }
        }

        if(!reverse){
            for (int i = n-1; i >= 0; i--) {
                k -= course[i];
                if(k < 0){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
