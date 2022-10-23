package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt[] = new int[10001];
        // 카운팅 정렬
        for(int i=0; i<n ;i++){
            cnt[Integer.parseInt(br.readLine())]++;
            //해당 인덱스의 값을 1 증가?
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i< 10001; i++){
            while(cnt[i] > 0){
            sb.append(i).append('\n');
            cnt[i]--;
            }
        }
        System.out.println(sb);
    }
}
