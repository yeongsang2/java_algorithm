package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_3980 {

    static int[][] map = new int[11][11];
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

//        int c = Integer.parseInt(br.readLine());
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
//            map = new int[11][11];
            for (int j = 0; j < 11; j++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    map[j][k] = scan.nextInt();
//                    map[j][k] = Integer.parseInt(st.nextToken());//j번 선수가 k포지션
                }
            }

            answer = 0;
            visited = new boolean[11];
            backtracking(0,0);
            System.out.println(answer);
//            sb.append(answer).append("\n");
        }
//        System.out.println(sb.toString());
    }
    static void backtracking(int idx, int total){

        if(idx == 11){
            answer = Math.max(answer, total);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if( !visited[i] && map[idx][i] != 0){
                visited[i] = true;
                backtracking(idx+1 , total + map[idx][i]);
                visited[i] = false;
            }
        }
    }
}
