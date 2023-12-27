package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0 ;
        boolean check = false;
        while(n > 0){
            if(n % 5 == 0){
                cnt = n / 5 + cnt;
                break;
            }
            n -=2 ;
            cnt +=1;
        }
        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }

    }
}
