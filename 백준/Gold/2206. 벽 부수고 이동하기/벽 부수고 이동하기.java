
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Loc{
        int r;
        int c;
        int cost;
        boolean isDestroy;
        public Loc(int r, int c, int cost, boolean isDestroy){
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.isDestroy = isDestroy;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                int temp = Character.getNumericValue(s.charAt(j));
                arr[i][j] = temp;
            }
        }

        boolean[][][] visited = new boolean[n][m][2]; // 0 안부시고 온경우, 부시고 온경우
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(0,0, 0,false));

        while (!queue.isEmpty()){
            Loc loc = queue.poll();
            if(loc.r == n-1 && loc.c == m-1){
                System.out.println(loc.cost+1);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nextR = loc.r + dr[i];
                int nextC = loc.c + dc[i];
                if(nextR >= 0 && nextR < n && nextC >= 0 && nextC <m){
                    if(arr[nextR][nextC] == 1){ // 벽
                        if(!loc.isDestroy){ // 안 부시고 왔다면
                            visited[nextR][nextC][1] = true;
                            queue.add(new Loc(nextR, nextC, loc.cost+1, true));
                        }
                    }else{ // 벽아님
                        // 부시고 온경우
                        if(loc.isDestroy && !visited[nextR][nextC][1]){
                            visited[nextR][nextC][1] = true;
                            queue.add(new Loc(nextR, nextC, loc.cost+1, true));
                        }else if(!loc.isDestroy && !visited[nextR][nextC][0]){
                            visited[nextR][nextC][0] = true;
                            queue.add(new Loc(nextR, nextC, loc.cost+1, false));
                        }
                    }
                }
            }
        }
        System.out.println(-1);

    }
}
