
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int R, C, N;
    static boolean[][] isBombed;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[][] map;
        int[][] time;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        time = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                time[i][j] = 0;
            }
        }

        for (int i = 2; i < N + 1; i++) {
            if(i % 2 == 0){ // 폭탄 설치
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if(map[j][k] == '.'){
                            map[j][k] = 'O';
                            time[j][k] = i;
                        }
                    }
                }
            }else{ // 폭탄 뿌셔
                isBombed = new boolean[R][C];
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if(map[j][k] == 'O' && ( (time[j][k] + 3) == i)){
                            bomb(map, j, k);
                        }
                    }
                }

                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if(isBombed[j][k]){
                            map[j][k] = '.';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void  bomb(char[][] map, int i, int j){

        int[] dr = new int[]{-1 , 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};

        isBombed[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextR = i + dr[k];
            int nextC = j + dc[k];
            if(nextR < R && nextR >= 0 && nextC < C && nextC >= 0){
                isBombed[nextR][nextC] = true;
            }
        }
    }

}
