import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

//    static class Node{
//        int end;
//        int cost;
//        public Node(int end, int cost){
//            this.end = end;
//            this.cost = cost;
//        }
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] answer = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(i==j){
                    answer[i][j] = 0;
                }else{
                    answer[i][j] = 100000000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            answer[a][b] = Math.min(answer[a][b], cost);
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n+1; k++) {
                    answer[j][k] = Math.min(answer[j][k], answer[j][i] + answer[i][k]);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(answer[i][j] >= 100000000){
                    System.out.print(0 + " ");
                }else{
                    System.out.print(answer[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}
