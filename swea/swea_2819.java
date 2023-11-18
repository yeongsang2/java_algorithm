package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea_2819 {


    // 동 서 남 북
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static Set<String> set;
    static String[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i < t+1; i++) {
            board = new String[5][5];
            set = new HashSet<>();

            for (int j = 1; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k < 5; k++) {
                    board[j][k] = st.nextToken();
                }
            }
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    search(j,k, board[j][k]);
                }
            }
            sb.append("#").append(i).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void search(int r, int c, String path){
        if(path.length() == 7){
            set.add(path);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(isPossible(nextR, nextC)){
                search(nextR,nextC, path + board[nextR][nextC]);
            }
        }
    }
    static boolean isPossible(int r,int c){
        if(r >= 1 && r <=4 && c>=1 && c<=4){
            return true;
        }
        return false;
    }
}
