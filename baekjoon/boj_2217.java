package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] ropeArr = new Integer[n];

        for (int i = 0; i < n; i++) {
            ropeArr[i] = Integer.parseInt(br.readLine());
        }
        // 1 1 10 10
        Arrays.sort(ropeArr,Collections.reverseOrder()); //reversOrder은 int는 적용 x
        int total = 0;
        for (int i = 0; i < n; i++) {
            int temp =  (ropeArr[i])*(i+1);
            total = Math.max(total,temp);
        }
        System.out.println(total);
    }
}
