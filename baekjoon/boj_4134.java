package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_4134 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nowSos = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            while (true){
                int tot = 0;
                if (nowSos > num){
                    System.out.println(num);
                    break;
                }
                for (int j = 1; j < num+1; j++) {
                    if (num % j == 0){
                        tot++;
                    }
                }
                if (tot == 2){
                    System.out.println(num);
                    nowSos = num;
                    break;
                }else {
                    num ++;
                }
            }
        }
    }
}
