package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {

    static class Loc{
        int r;
        int w;
        int h;
        public Loc(int r, int w, int h){
            this.r = r;
            this.w = w;
            this.h = h;
        }
    }

    static int[][][] map;

    static Queue<Loc> queue= new LinkedList<>();

    // 상 하 좌 우 위 아래
    static int[] dr = {-1,1,0,0,0,0};
    static int[] dw = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};

    static int m;
    static int n;
    static int h;
    public static void main(String[] args) throws IOException {

        // z, x ,y
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //가
        n = Integer.parseInt(st.nextToken()); //세로 행
        h = Integer.parseInt(st.nextToken()); //높이 열

        map = new int[h][n][m];

        for(int i = h-1 ; i >=0 ; i--){
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int now = Integer.parseInt(st.nextToken());
                    map[i][j][k] = now;
                    // 1 익토
                    if(now == 1){
                        queue.add(new Loc(j,k,i));
                    }
                }
            }
        }

        int dayCount = -1;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){ //그 크기까지만
                Loc loc = queue.poll();
                int nR =0;
                int nW =0;
                int nH =0;

                for (int i = 0; i <6; i++) {
                    nR = loc.r + dr[i];
                    nW = loc.w + dw[i];
                    nH = loc.h + dh[i];
                    if(checkRange(nR,nW,nH)){
                        if(map[nH][nR][nW] == 0){
                            map[nH][nR][nW] = 1; // 익토
                            queue.add(new Loc(nR,nW,nH));
                        }
                    }
                }
            }
            dayCount++;
        }

        if(!checkAllTomato()){
            System.out.println(-1);
        }
        else {
            System.out.println(dayCount);
        }
    }

    static boolean checkRange(int r, int w, int height){
        if(r <n && r>=0 && w <m && w >= 0 && height < h && height >= 0){
            return true;
        }
        return false;
    }

    static boolean checkAllTomato(){
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if( map[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
