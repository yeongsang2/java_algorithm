import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[] checked;
    static char[][] arr;
    static int r;
    static int c;
    static int answer = 0;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        checked = new boolean[26];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        checked[arr[0][0]-65] = true;
        search(0,0, 1);

        if(r==1 && c==1) {
            System.out.println(1);
        } else {
            System.out.println(answer);
        }

    }

    static void search(int row, int col, int cnt){

        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {

            int nextR = row + dr[i];
            int nextC = col + dc[i];
            if(nextR >= 0 && nextR < r && nextC >=0 && nextC < c){

                if(!checked[arr[nextR][nextC] -65]){
                    checked[arr[nextR][nextC] - 65] = true;
                    search(nextR, nextC, cnt+1);
                    checked[arr[nextR][nextC] - 65] = false;
                }
            }
        }

    }
}
