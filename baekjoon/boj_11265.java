package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11265 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <n+1 ; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n+1 ; i++) {  // 중간노드
            for (int j = 1; j < n+1 ; j++) { // 출발지
                for (int k = 1; k < n+1; k++) { // 도착점
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(map[a][b] <=c ){
                sb.append("Enjoy other party");
            }else{
                sb.append("Stay here");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
