package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_20115 {

    public static void main(String[] args) throws IOException {


        // 3 2 10 9 6
        // 10 9 6 3 2
        // 11
        // 12.5
        // 15.5
        // 20
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Float[] drinks = new Float[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drinks[i] = Float.parseFloat(st.nextToken());
        }

        Arrays.sort(drinks, Collections.reverseOrder());

        int idx = n-1;
        while(idx > 0){
            float temp = drinks[idx] / 2;
            drinks[0] = drinks[0] + temp;
            idx--;
        }

        System.out.println(drinks[0]);
    }
}
