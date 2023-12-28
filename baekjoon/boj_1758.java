package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj_1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Long[] tipArr = new Long[n];

        for (int i = 0; i < n; i++) {
            tipArr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(tipArr, Collections.reverseOrder());

        long total = 0;
        for (int i = 0; i < n; i++) {
            long temp = tipArr[i] - i;
            if(temp <= 0){
                 break;
            }
            total += temp;
        }
        System.out.println(total);


    }
}
