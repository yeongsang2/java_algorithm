
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[][] map;
    static List<int[]> cctvList = new ArrayList<>();
    static int[] cctvDir;
    static int tempCount;
    static int answer = Integer.MAX_VALUE;
    static int wallCnt = 0;

    // 동 서 남 북
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num >=1 && num <= 5){
                    cctvList.add(new int[]{i,j});
                }
                if(num == 6){
                    wallCnt++;
                }
            }
        }
        cctvDir = new int[cctvList.size()];
        // cctv 방향설정
        setCctvDir(0);
        System.out.println(answer - wallCnt);
    }
    static void setCctvDir(int idx){
        if(idx == cctvList.size()){
            searchArea();
            answer = Math.min(answer, tempCount);
            return;
        }

        for (int i = 0; i < 4; i++) {
            cctvDir[idx] = i;
            setCctvDir(idx + 1);
        }
    }

    static void searchArea(){
        tempCount = 0;
        boolean[][] isVisible = new boolean[n][m];
        for (int i = 0; i < cctvList.size(); i++) {
            int[] cctv = cctvList.get(i);
            int r = cctv[0];
            int c  =cctv[1];
            int type = map[r][c];
            int dir = cctvDir[i];

            if(type == 1){
                search(r, c, dir, isVisible);
            }else if(type == 2){
                if(dir == 0 || dir == 1){
                    search(r, c, 0, isVisible);
                    search(r, c, 1, isVisible);
                }else{
                    search(r, c, 2, isVisible);
                    search(r, c, 3, isVisible);
                }
            }else if(type == 3){
                if(dir == 0){
                    search(r, c, 0, isVisible);
                    search(r, c, 3, isVisible);
                }else if(dir == 1){
                    search(r, c, 1, isVisible);
                    search(r, c, 2, isVisible);
                }else if(dir == 2){
                    search(r, c, 0, isVisible);
                    search(r, c, 2, isVisible);
                }else {
                    search(r, c, 1, isVisible);
                    search(r, c, 3, isVisible);
                }
            }else if(type == 4){
                if(dir == 0){
                    search(r, c, 0, isVisible);
                    search(r, c, 1, isVisible);
                    search(r, c, 3, isVisible);
                }else if(dir == 1){
                    search(r, c, 0, isVisible);
                    search(r, c, 1, isVisible);
                    search(r, c, 2, isVisible);
                }else if(dir == 2){
                    search(r, c, 0, isVisible);
                    search(r, c, 2, isVisible);
                    search(r, c, 3, isVisible);
                }else {
                    search(r, c, 1, isVisible);
                    search(r, c, 2, isVisible);
                    search(r, c, 3, isVisible);
                }
            }else{
                for (int j = 0; j < 4; j++) {
                    search(r, c, j, isVisible);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.print(isVisible[i][j] + " ");
                if(!isVisible[i][j]) tempCount++;
//                if(tempCount > answer) break;
            }
//            System.out.println();
        }
//        System.out.println();
    }

    public static void search(int r, int c, int dir, boolean[][] isVisible){

        isVisible[r][c] = true;
        int nextR = r + dr[dir];
        int nextC = c + dc[dir];
        if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && map[nextR][nextC] != 6){
            search(nextR, nextC, dir, isVisible);
        }
    }
}
