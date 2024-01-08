package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630 {

    static int[][] map;
    static int n;
    static int blueCnt = 0 ;
    static int whiteCnt = 0 ;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(1,n,1, n);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);

    }

    static void div(int r1, int r2, int c1, int c2){


        if( r1 == r2){ // finish
            if(map[r1][c1] == 1){
                blueCnt++;
            }else {
                whiteCnt++;
            }
            return;
        }

        int color = checkFinish(r1,r2,c1,c2);
        if(color == 1){
            blueCnt++;
            return;
        }else if(color ==0){
            whiteCnt++;
            return;
        }else {
            ;
        }

        int midR= (r1 + r2 ) / 2;
        int midC = (c1 + c2) / 2;

        div(r1, midR, c1, midC);
        div(r1,midR, midC+1 ,c2);
        div(midR+ 1, r2, c1, midC);
        div(midR +1 , r2, midC+1, c2);

    }

    private static int checkFinish(int r1, int r2, int c1, int c2) {

        int startColor = map[r1][c1];

        for (int i = r1; i < r2+1; i++) {
            for (int j = c1; j < c2+1; j++) {
                if(startColor != map[i][j]){
                    return -1;
                }
            }
        }

        return startColor;
    }

}
