package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rgb_distance_1149 {

    static int n;
    static int[][] cost;
    static int min = Integer.MAX_VALUE;
    static int minTmp;

    public static void main(String[] args) throws IOException {
        // 조건 1번집의 색 != 2번 집의 색
        // n번 집의 색 n-1번 != 집의 색
        // i번 ㅈ비의 색은 i-1번, i+1번 집의 색과 같지 않아야 함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); // 집의 수
        cost = new int[1001][n+1];

        for(int i=1 ;i< n+1 ;i++){ //1번집부터 시작
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<3; i++) {
            dfs(0,i,cost[0][i]);
        }
        System.out.println(min);
    }

    //현재 값, 이전 색상?
    public static void dfs(int now, int nowRGB, int minTmp){

//        if(minTmp > min){ //이미 넘어섬
//            return;
//        }
        if(now == n){            //집의수
            min = Math.min(minTmp, min);
//            System.out.println(n + " " + minTmp);
            return;
        }

        for(int i=0;i<3;i++){

            if(nowRGB == i){ //이전 색상과 곂침
                continue;
            }

            if(minTmp + cost[now+1][i] < min) {
                dfs(now + 1, i, minTmp + cost[now + 1][i]);
            }
        }

    }
}
