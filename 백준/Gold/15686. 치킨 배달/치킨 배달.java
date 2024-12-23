
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;

    static int n;
    static int m;

    static class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<Point> houseList = new LinkedList<>();
    static List<Point> chickenList = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;
    static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        checked = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if(temp == 1){
                    houseList.add(new Point(i,j));
                }else if(temp == 2){
                    chickenList.add(new Point(i,j));
                }
            }
        }

        for(int i = 0; i < chickenList.size(); i++){
            Point point = chickenList.get(i);
            checked[point.r][point.c] = true;
            dfs(i, 1);
            checked[point.r][point.c] = false;
        }
        System.out.println(answer);

    }
    static void dfs(int idx, int cnt){

//        System.out.println("cnt: " + cnt);
        if(cnt == m){
            search();
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(checked[i][j] + " ");
//                }
//                System.out.println();
//            }
            return;
        }
        for (int i = idx + 1; i < chickenList.size(); i++) {
            Point point = chickenList.get(i);
            checked[point.r][point.c] = true;
            dfs(i,cnt+1);
            checked[point.r][point.c] = false;
        }
    }
    static void search(){
        int tempAnswer = 0;

        for(Point point: houseList){
            if(tempAnswer > answer) break;
            Queue<Point> queue = new LinkedList<>();
            queue.add(point);
            boolean[][] visited = new boolean[n][n];
            visited[point.r][point.c] = true;
            while(!queue.isEmpty()){
                Point poll = queue.poll();
                int r = poll.r;
                int c = poll.c;
                if(arr[r][c] == 2 && checked[r][c]){
                    tempAnswer = tempAnswer + ( Math.abs(r-point.r) + Math.abs(c-point.c));
                    break;
                }
                for (int i = 0; i < 4; i++) {

                    int nextR = r + dr[i];
                    int nextC = c + dc[i];
                    if(nextR >= 0 && nextR < n && nextC >=0 && nextC < n && !visited[nextR][nextC]){
                        visited[nextR][nextC] = true;
                        queue.add(new Point(nextR, nextC));
                    }
                }
            }

        }
        answer = Math.min(answer, tempAnswer);
    }
}
