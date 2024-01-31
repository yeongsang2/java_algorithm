package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_21318 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] level = new int[n+1];
        int[] answerArr = new int[n+1];

        StringTokenizer st= new StringTokenizer(br.readLine());

        for (int i = 1; i < n+1 ; i++) {
            level[i] = Integer.parseInt(st.nextToken());
            if(level[i] < level[i-1]){
                answerArr[i] = answerArr[i-1] +1;
            }else {
                answerArr[i] = answerArr[i-1];
            }
        }

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(answerArr[y] - answerArr[x]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
