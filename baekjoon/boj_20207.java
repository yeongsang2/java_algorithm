package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] schedule = new int[366];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end + 1; j++) {
                schedule[j] +=1;
            }
        }

        int now =1;
        int width = 0;
        int maxHeight =0;
        int score = 0;

        while(now < 366){
            if(schedule[now] == 0){
                score += width* maxHeight;
                width= 0;
                maxHeight = 0;
                now++;
                continue;
            }
            width++;
            maxHeight = Math.max(maxHeight,schedule[now]);
            now++;
        }
        score += width * maxHeight;
        System.out.println(score);
    }
}
