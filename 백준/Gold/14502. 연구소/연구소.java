import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] tempMap;
    static int answer = 0;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n =  Integer.parseInt(st.nextToken());
        m =  Integer.parseInt(st.nextToken());

        map = new int[n][m];
        tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                tempMap[i][j] = temp;
            }
        }

        // 0 빈칸, 1 벽, 2 바이러스
        // 벽3개 놓았을때
        // 바이스러스 퍼트리기
        // 안전영역 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0 ){
                    initMap();
                    map[i][j] = 1;
                    selectWall(1);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(answer);

    }

    static void selectWall(int cnt){

        if(cnt == 3){
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0 ){
                    map[i][j] = 1;
                    selectWall(cnt+1);
                    map[i][j] = 0;
                }
            }
        }

    }
    static void spreadVirus(){


        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        List<int[]> list = new LinkedList<>();
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            for (int i = 0; i < 4; i++) {

                int nextR = r + dr[i];
                int nextC = c  +dc[i];
                if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m){
                    if(map[nextR][nextC] == 0){
                        map[nextR][nextC] = 2;
                        list.add(new int[]{nextR, nextC});
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
        }

        calculateSafetyArea();
        for(int[] temp : list){
            map[temp[0]][temp[1]] = 0;
        }
    }

    static void initMap(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = tempMap[i][j];
            }
        }
    }
    static void calculateSafetyArea(){
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] ==0){
                    cnt++;
                }
            }
        }
        answer = Math.max(answer, cnt);
    }
}
