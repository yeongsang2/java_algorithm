package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] aArr = new int[n];
        int[] bArr = new int[m];
        int[] nArr = new int[n+m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = n; i < n+m; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nArr.length ; i++) {
            sb.append(nArr[i] + " ");
        }
        System.out.println(sb);
    }
}
